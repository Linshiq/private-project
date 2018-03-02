package com.lsq.medium;

import java.util.Arrays;

/** 
* @author  Linshiq: 
* @date 创建时间：2017年2月8日 下午2:30:20 
* @version 1.0 
* @parameter  
* @since  
* @return  
*/
/**
 * <p>
 * 文件功能说明： 给定一个整数数组，找到一个和最接近于零的子数组。返回第一个和最有一个指数。你的代码应该返回满足要求的子数组的起始位置和结束位置
 * 
 * 样例
 * 
 * 给出[-3, 1, 1, -3, 5]，返回[0, 2]，[1, 3]， [1, 1]， [2, 2] 或者 [0, 4]。
 * </p>
 * 
 * @Author linshiqin
 *         <p>
 *         <li>2017年2月8日-下午2:30:20</li>
 *         <li>修改记录</li>
 *         <li>-----------------------------------------------------------</li>
 *         <li>标记：修订内容</li>
 *         <li>linshiqin：创建注释模板</li>
 *         <li>-----------------------------------------------------------</li>
 *         </p>
 */
public class SubarraySumClosest {

	/**
	 * @param nums:
	 *            A list of integers
	 * @return: A list of integers includes the index of the first number and
	 *          the index of the last number
	 */
	public static int[] subarraySumClosest(int[] nums) {
		// write your code here 没有达成

		int[] result = new int[2];
		int minSum = Integer.MAX_VALUE;
		int zero = 0;
		int sum = 0;
		
		int[] nums2 = Arrays.copyOf(nums, nums.length);
		
		Arrays.sort(nums2);
		
		if(nums.length > 0){
			
			if(nums2[0] > 0){
				
				zero = nums2[0];
				
			}else if(nums2[nums.length - 1] < 0){
				
				zero = Math.abs(nums2[nums.length - 1]);
			}
		}
		
		for (int i = 0; i < nums.length; i++) {

			for (int j = i; j < nums.length; j++) {

				sum = sum + nums[j];

				if (sum == zero) {
					result = new int[] { i, j };
					return result;

				} else if (Math.abs(sum) < Math.abs(minSum)) {
					// System.out.println("sum:"+sum+" i:"+i+" j:"+j);
					result = new int[] { i, j };
					minSum = sum;

				} else {
					continue;
				}
			}
			
			sum = 0;
		}

		return result;

	}
	
	public static void main(String[] args) {

		int[] nums = new int[] { 15, 137, 17, 120, 177, 66, 98, 187, 67, 44, 2, 84, 37, 21, 18, 98, 19, 66, 8, 56, 40,
				19, 6, 93, 27, 62, 24, 26, 76, 4, 11, 76, 28, 51, 47, 75, 77, 23, 12, 92, 75, 20, 61, 7, 88, 72, 10, 63,
				93, 17, 48, 97, 11, 99, 13, 77, 91, 15, 29, 12, 6, 98, 78, 21, 50, 39, 37, 60, 70, 56, 58, 47, 77, 82,
				95, 64, 58, 99, 100, 44, 29, 88, 58, 88, 12, 60, 77, 26, 76, 35, 78, 30, 71, 100, 67, 26, 67, 89, 19,
				20, 2, 30, 63, 27, 14, 91, 31, 18, 53, 49, 41, 27, 18, 48, 79, 26, 88, 56, 65, 85, 90, 18, 83, 4, 19,
				32, 12, 42, 27, 62, 94, 87, 84, 38, 12, 57, 47, 90, 54, 70, 55, 26, 64, 67, 73, 96, 88, 45, 52, 85, 100,
				56, 55, 64, 30, 97, 68, 51, 88, 69, 63, 2, 15, 3, 36, 20, 60, 31, 61, 61, 2, 39, 65, 51, 43, 58, 74, 43,
				54, 51, 28, 31, 82, 63, 82, 43, 21, 95, 48, 29, 31, 6, 30, 74, 83, 79, 96, 69, 45, 25, 22, 59, 76, 18,
				32, 70, 16, 77, 2, 27, 28, 53, 2, 88, 97, 65, 17, 61, 74, 24, 10, 22, 36, 91, 100, 8, 47, 76, 55, 35,
				32, 56, 74, 54, 55, 45, 10, 39, 87, 12, 60, 7, 39, 50, 86, 24, 43, 95, 13, 29, 89, 80, 74, 35, 68, 38,
				56, 48, 42, 10, 26, 19, 19, 57, 46, 79, 88, 12, 78, 14, 94, 81, 3, 6, 69, 48, 22, 9, 82, 37, 92, 95, 8,
				38, 62, 27, 32, 82, 73, 57, 43, 16, 81, 15, 22, 85, 72, 80, 73, 31, 86, 84, 2, 22, 36, 90, 21, 3, 71,
				96, 47, 19, 35, 73, 7, 48, 64, 98, 90, 99, 63, 30, 78, 18, 65, 23, 45, 34, 82, 60, 89, 61, 45, 18, 70,
				93, 59, 20, 40, 34, 83, 80, 16, 42, 92 };

		int[] result = SubarraySumClosest.subarraySumClosest(nums);
		if (result != null)
			System.out.println("end:" + result[0] + " " + result[1]);

	}
}
