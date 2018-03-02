package com.lsq.problem;

import java.util.Arrays;

/** 
* @author  Linshiq: 
* @date 创建时间：2018年1月26日 上午9:26:31 
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
 *         <li>2018年1月26日-上午9:26:31</li>
 *         <li>修改记录</li>
 *         <li>-----------------------------------------------------------</li>
 *         <li>标记：修订内容</li>
 *         <li>linshiqin：创建注释模板</li>
 *         <li>-----------------------------------------------------------</li>
 *         </p>
 */
public class Solution617 {

	/*
	 * @param nums: an array with positive and negative numbers
	 * 
	 * @param k: an integer
	 * 
	 * @return: the maximum average
	 */
	public static double maxAverage(int[] nums, int k) {
		// write your code here

		/*
		 * 给出一个整数数组，有正有负。找到这样一个子数组，他的长度大于等于 k，且平均值最大。
		 * 
		 * 注意事项 保证数组的大小 >= k
		 * 
		 * 您在真实的面试中是否遇到过这个题？ Yes 样例 给出 nums = [1, 12, -5, -6, 50, 3], k = 3
		 * 
		 * 返回 15.667 // (-6 + 50 + 3) / 3 = 15.667
		 */

		if (k > nums.length) {
			Arrays.sort(nums);
			return nums.length > 0 ? nums[0] : -1;
		}

		double max = Integer.MIN_VALUE;

		double sum = 0;

		double index = 0;

		for (int i = 0; i < nums.length ; i++) {
			
//			for (int j = i; j < nums.length; j++) {
//
//				sum += nums[j];
//				
//				
//				index++;
//
//				if (index >= k && (sum / k) > max) {
//
//					max = sum / index;
//				}
//			}
//			
//			sum = 0;
//			index = 0;
			
			if(sum <= 0){
				
				sum = nums[i];
				index = 1;
			}else {
				index ++;
				sum = ( sum + nums[i] ) / index;				
			}
			
			if ( index >= k &&  sum > max) {

				max = sum ;
				
				System.out.println(sum);
			}
			
		}

		return max;
	}

	public static void main(String[] args) {
		
		long startTime = System.currentTimeMillis() ;
		System.out.println(maxAverage(new int[] { 1, 12, -5, -6, 50, 3 }, 3));
		long endTime = System.currentTimeMillis() ;
		
		System.out.println((endTime - startTime)+"ms");
	}
}
