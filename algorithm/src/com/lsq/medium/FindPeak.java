package com.lsq.medium;

/** 
* @author  Linshiq: 
* @date 创建时间：2017年2月14日 下午2:15:48 
* @version 1.0 
* @parameter  
* @since  
* @return  
*/
/**
 * <p>
 * 文件功能说明：你给出一个整数数组(size为n)，其具有以下特点： 1.相邻位置的数字是不同的 2.A[0] < A[1] 并且 A[n - 2] >
 * A[n - 1] 假定P是峰值的位置则满足A[P] > A[P-1]且A[P] > A[P+1]，返回数组中任意一个峰值的位置。
 * 
 * 注意事项:
 * 
 * 数组可能包含多个峰值，只需找到其中的任何一个即可
 * 
 * 样例: 给出数组[1, 2, 1, 3, 4, 5, 7, 6]返回1, 即数值 2 所在位置, 或者6, 即数值 7 所在位置.
 * 
 * </p>
 * 
 * @Author linshiqin
 *         <p>
 *         <li>2017年2月14日-下午2:15:48</li>
 *         <li>修改记录</li>
 *         <li>-----------------------------------------------------------</li>
 *         <li>标记：修订内容</li>
 *         <li>linshiqin：创建注释模板</li>
 *         <li>-----------------------------------------------------------</li>
 *         </p>
 */
public class FindPeak {
	/**
	 * @param A:
	 *            An integers array.
	 * @return: return any of peek positions.
	 */
	public static int findPeak(int[] A) {
		// write your code here

		if (A.length < 3)
			return 0;

		int index = A.length / 2;

		int peak = A[index];

		if (A[index - 1] >= peak) {

			for (int i = index - 1; i >= 0; i--) {

				if (A[i] >= peak) {

					peak = A[i];
				} else {
					index = i+1;
					break;
				}

			}
		} else {

			for (int i = index; i < A.length; i++) {

				if (A[i] >= peak) {

					peak = A[i];
				} else {
					index = i-1;
					break;
				}

			}
		}

		return index;
	}
	
	public static void main(String[] args) {
		
		int[] A = new int[]{1,10,9,8,7,6,5,4};
		
		System.out.println("end:"+findPeak(A));
	}
}
