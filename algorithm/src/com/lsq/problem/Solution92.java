package com.lsq.problem;

import java.util.Arrays;

/** 
* @author  Linshiq: 
* @date 创建时间：2018年2月7日 下午4:05:27 
* @version 1.0 
* @parameter  
* @since  
* @return  
*/
/**
 * <p>
 * 文件功能说明：
 * 
 * </p>
 * 
 * @Author linshiqin
 *         <p>
 *         <li>2018年2月7日-下午4:05:27</li>
 *         <li>修改记录</li>
 *         <li>-----------------------------------------------------------</li>
 *         <li>标记：修订内容</li>
 *         <li>linshiqin：创建注释模板</li>
 *         <li>-----------------------------------------------------------</li>
 *         </p>
 */
public class Solution92 {
	/*
	 * 在n个物品中挑选若干物品装入背包，最多能装多满？假设背包的大小为m，每个物品的大小为A[i]
	 * 
	 * 注意事项 你不可以将物品进行切割。
	 * 
	 * 您在真实的面试中是否遇到过这个题？ Yes 样例 如果有4个物品[2, 3, 5, 7]
	 * 
	 * 如果背包的大小为11，可以选择[2, 3, 5]装入背包，最多可以装满10的空间。
	 * 
	 * 如果背包的大小为12，可以选择[2, 3, 7]装入背包，最多可以装满12的空间。
	 * 
	 * 函数需要返回最多能装满的空间大小。
	 */

	/**
	 * @param m:
	 *            An integer m denotes the size of a backpack
	 * @param A:
	 *            Given n items with size A[i]
	 * @return: The maximum size
	 */
	public int backPack(int m, int[] A) {
		// write your code here

		int sum = 0;

		Arrays.sort(A);

		calculation(m, A, 0,0);

		return -1;
	}

	private static int calculation(int m, int[] A, int sum,int index) {

		for (int i = index; i < A.length; i++) {

			sum += A[i];

			if (sum > m) {
				return sum - A[i];
			} else {

			}
		}

		return sum;
	}
}
