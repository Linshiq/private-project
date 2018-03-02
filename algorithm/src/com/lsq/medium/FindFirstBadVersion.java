package com.lsq.medium;

import com.lsq.util.SVNRepo;

/** 
* @author  Linshiq: 
* @date 创建时间：2017年3月13日 下午3:51:30 
* @version 1.0 
* @parameter  
* @since  
* @return  
*/
/**
 * <p>
 * 文件功能说明：代码库的版本号是从 1 到 n
 * 的整数。某一天，有人提交了错误版本的代码，因此造成自身及之后版本的代码在单元测试中均出错。请找出第一个错误的版本号。
 * 
 * 你可以通过 isBadVersion 的接口来判断版本号 version 是否在单元测试中出错，具体接口详情和调用方法请见代码的注释部分。
 * 
 * 注意事项:
 * 
 * 请阅读上述代码，对于不同的语言获取正确的调用 isBadVersion 的方法，比如java的调用方式是SVNRepo.isBadVersion(v)
 * 
 * 样例 给出 n=5
 * 
 * 调用isBadVersion(3)，得到false
 * 
 * 调用isBadVersion(5)，得到true
 * 
 * 调用isBadVersion(4)，得到true
 * 
 * 此时我们可以断定4是第一个错误的版本号
 * 
 * </p>
 * 
 * @Author linshiqin
 *         <p>
 *         <li>2017年3月13日-下午3:51:30</li>
 *         <li>修改记录</li>
 *         <li>-----------------------------------------------------------</li>
 *         <li>标记：修订内容</li>
 *         <li>linshiqin：创建注释模板</li>
 *         <li>-----------------------------------------------------------</li>
 *         </p>
 */
public class FindFirstBadVersion {

	/**
	 * @param n:
	 *            An integers.
	 * @return: An integer which is the first bad version.
	 */
	public static int findFirstBadVersion(int n) {

		if (n == 1) {

			return 1;
		} else if (n < 1) {

			return -1;
		}

		int firstBad = 1;

		int start = 1;
		int end = n;

		int beforS = start;
		int beforE = end;
		/*
		 * 三种情况: 1.第一个版本就是错的 2.只有最后一个版本是错的 3.错误版本在中间
		 */
		if (SVNRepo.isBadVersion(start)) {

			return firstBad;
		} else if (SVNRepo.isBadVersion(end)) {

			if (!SVNRepo.isBadVersion(end - 1)) {
				return end;
			}

			int mid = end / 2 + 1; // 重置

			if (SVNRepo.isBadVersion(mid)) {

				beforS = start;
				beforE = end;

				start = (start + mid) / 2 + 1;

				end = mid;

			} else {

				beforS = start;
				beforE = end;

				end = (mid + end) / 2 + 1;

				start = mid;

			}

			boolean flag = false;

			while (true) {

		//		System.out.println("start:" + start + " mid:" + mid + " end:" + end);

				if (SVNRepo.isBadVersion(start) && SVNRepo.isBadVersion(end)) {

					for (int i = beforS; i <= start; i++) {

						if (SVNRepo.isBadVersion(i)) {
							return i;
						}
					}

				} else if (!SVNRepo.isBadVersion(start) && !SVNRepo.isBadVersion(end)) {

					for (int i = beforE; i >= end; i--) {

						if (!SVNRepo.isBadVersion(i)) {
							return i+1;
						}
					}

				} else if (SVNRepo.isBadVersion(mid) && flag) {

					beforS = start;
					beforE = end;

					start = (start + mid) / 2 + 1;

					end = mid;
					
					mid = (start + end) / 2;
				} else if(flag){

					beforS = start;
					beforE = end;

					end = (mid + end) / 2 + 1;

					start = mid;
					mid = (start + end) / 2;
				}
				
				flag = true;
			}

		} else {
			return -1;
		}

		// return firstBad;
	}
	
	public static int otherPeople(int n){
		int min = 1, max = n, mid = 0;
		// 二分搜索
		while (min + 1 < max) {
			mid = min + (max - min) / 2;
			if (SVNRepo.isBadVersion(mid)) {
				max = mid;
			} else {
				min = mid;
			}
		}
		// 当退出循环时，min和max相差1，我们要确定其中哪个是第一错误版本
		if (SVNRepo.isBadVersion(min)) {
			return min;
		} else {
			return max;
		}
	}
	
	public static void main(String[] args) {

		SVNRepo.setFirstBadVersion(52);

		System.out.println("badversion:" + SVNRepo.getFirstBadVersion());

		System.out.println("end:" + FindFirstBadVersion.otherPeople(100));
		
		System.out.println("------");
		
		//System.out.println("end:" + FindFirstBadVersion.findFirstBadVersion(10));
	}
}
