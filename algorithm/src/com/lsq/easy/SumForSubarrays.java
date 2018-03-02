package com.lsq.easy;

import java.util.ArrayList;

/** 
* @author  Linshiq: 
* @date 创建时间：2017年1月12日 下午7:20:28 
* @version 1.0 
* @parameter  
* @since  
* @return  
*/
/**
 * <p>
 * 文件功能说明： 给定一个整数数组，找到和为零的子数组。你的代码应该返回满足要求的子数组的起始位置和结束位置
 * 
 * 样例 给出 [-3, 1, 2, -3, 4]，返回[0, 2] 或者 [1, 3].
 * </p>
 * 
 * @Author linshiqin
 *         <p>
 *         <li>2017年1月12日-下午7:20:28</li>
 *         <li>修改记录</li>
 *         <li>-----------------------------------------------------------</li>
 *         <li>标记：修订内容</li>
 *         <li>linshiqin：创建注释模板</li>
 *         <li>-----------------------------------------------------------</li>
 *         </p>
 */
public class SumForSubarrays {
	private static ArrayList<Integer> arrayInt = new ArrayList<>();

	/**
	 * @param nums:
	 *            A list of integers
	 * @return: A list of integers includes the index of the first number and
	 *          the index of the last number
	 */
	public static ArrayList<Integer> subarraySum(int[] nums) {
		// write your code here

		int sum = -1;

		for (int i = 0; i < nums.length; i++) {

			sum = nums[i];

			if (sum == 0) {
				arrayInt.add(i);
				arrayInt.add(i);
				break;
			}

			if (getSum(i + 1, sum, nums)) {
				arrayInt.add(i);
				break;
			}

		}

		return arrayInt;

	}

	private static boolean getSum(int index, int sum, int[] nums) {

		for (int i = index; i < nums.length; i++) {

			sum = sum + nums[i];

			if (sum == 0) {
				arrayInt.add(i);
				return true;
			}
		}

		return false;
	}

	public static void main(String[] args) {

		int[] nums = new int[] { 4, 10, 13, 4, -1, 0, 3, 3, 5 };

		System.out.println("end:");

		for (int i : subarraySum(nums)) {
			System.out.println(i);
		}
	}
}
