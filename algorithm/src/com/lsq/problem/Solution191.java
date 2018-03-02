package com.lsq.problem;

/** 
* @author  Linshiq: 
* @date 创建时间：2018年1月25日 下午4:47:40 
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
 *         <li>2018年1月25日-下午4:47:40</li>
 *         <li>修改记录</li>
 *         <li>-----------------------------------------------------------</li>
 *         <li>标记：修订内容</li>
 *         <li>linshiqin：创建注释模板</li>
 *         <li>-----------------------------------------------------------</li>
 *         </p>
 */
public class Solution191 {
	/*
	 * @param nums: An array of integers
	 * 
	 * @return: An integer
	 */
	public int maxProduct(int[] nums) {
		// write your code here

		/*
		 * 找出一个序列中乘积最大的连续子序列（至少包含一个数）。
		 * 
		 * 样例 比如, 序列 [2,3,-2,4] 中乘积最大的子序列为 [2,3] ，其乘积为6。
		 */

		int maxMul = Integer.MIN_VALUE;

		int mul = 1;

		for (int i = 0; i < nums.length; i++) {

			for (int j = i; j < nums.length; j++) {

				mul *= nums[j];

				if (mul > maxMul) {

					maxMul = mul;
				}
			}

			mul = 1;
		}

		return maxMul;
	}
}
