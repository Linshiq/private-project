package com.lsq.util;

/** 
* @author  Linshiq: 
* @date 创建时间：2017年3月13日 下午3:53:20 
* @version 1.0 
* @parameter  
* @since  
* @return  
*/
/**
 * <p>
 * 文件功能说明： 配合FindFirstBadVersion使用
 * </p>
 * 
 * @Author linshiqin
 *         <p>
 *         <li>2017年3月13日-下午3:53:20</li>
 *         <li>修改记录</li>
 *         <li>-----------------------------------------------------------</li>
 *         <li>标记：修订内容</li>
 *         <li>linshiqin：创建注释模板</li>
 *         <li>-----------------------------------------------------------</li>
 *         </p>
 */
public class SVNRepo {

	private static int firstBadVersion;

	private static int count = 0;

	public static int getFirstBadVersion() {
		return firstBadVersion;
	}

	public static void setFirstBadVersion(int firstBadVersion) {
		SVNRepo.firstBadVersion = firstBadVersion;
	}

	public static boolean isBadVersion(int n) {
		System.out.println(count++);
		if (n >= firstBadVersion) {
			return true;
		} else {
			return false;
		}

	}

	public static void main(String[] args) {

		int n = 10;

//		int min = 1, max = n, mid = 0;
//		// 二分搜索
//		while (min + 1 < max) {
//			mid = min + (max - min) / 2;
//			if (isBadVersion(mid)) {
//				max = mid;
//			} else {
//				min = mid;
//			}
//		}
//		// 当退出循环时，min和max相差1，我们要确定其中哪个是第一错误版本
//		if (isBadVersion(min)) {
//			return min;
//		} else {
//			return max;
//		}
	}
}
