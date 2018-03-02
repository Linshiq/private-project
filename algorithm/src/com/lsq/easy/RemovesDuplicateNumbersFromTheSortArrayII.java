package com.lsq.easy;

import java.util.Arrays;

/** 
* @author  Linshiq: 
* @date 创建时间：2017年1月18日 上午10:23:39 
* @version 1.0 
* @parameter  
* @since  
* @return  
*/
/**
 * <p>
 * 文件功能说明： 跟进“删除重复数字”： 如果可以允许出现两次重复将如何处理？
 *
 * 样例
 * 
 * 给出数组A =[1,1,1,2,2,3]，你的函数应该返回长度5，此时A=[1,1,2,2,3]。
 * </p>
 * 
 * @Author linshiqin
 *         <p>
 *         <li>2017年1月18日-上午10:23:39</li>
 *         <li>修改记录</li>
 *         <li>-----------------------------------------------------------</li>
 *         <li>标记：修订内容</li>
 *         <li>linshiqin：创建注释模板</li>
 *         <li>-----------------------------------------------------------</li>
 *         </p>
 */
public class RemovesDuplicateNumbersFromTheSortArrayII {
	/**
	 * @param A:
	 *            a array of integers
	 * @return : return an integer
	 */
	public static int removeDuplicates(int[] nums) {
		// write your code here

		int count = 0;
		int countLen = 0;
		int maxNum = 0;
		int max;
		
		if(nums.length>2){
			
			max = nums[nums.length-1];
			
			if(nums[nums.length-1] == nums[nums.length-2] && nums[nums.length-2]==nums[nums.length-3])
				maxNum = 2;
			else if(nums[nums.length-1] == nums[nums.length-2] && nums[nums.length-2]!=nums[nums.length-3]){
				maxNum = 2;
			}else if(nums[nums.length-1] != nums[nums.length-2]){
				maxNum = 1;
			}
			
		}else if(nums.length==2){
			
			max = nums[nums.length-1];
			
			if(nums[nums.length-1] != nums[nums.length-2]){
				maxNum = 1;
			}
		}else{
			return nums.length;
		}
		
		for (int i = 0; i < nums.length - 1; i++) {

			if (nums[i] == nums[i + 1]) {

				count++;
			} else {
				
				count = 0;
			}

			if (count == 2) {

				count = 0;
				replace(i + 1, nums, nums[i]);
			}

		}
		
		for (int i = 0; i < nums.length-1; i++) {
			
			if(max == nums[i]){
				
				if(maxNum == 1){
					
					countLen = i+1;
					break;
				}else if(max == nums[i+1] && maxNum == 2){
					countLen = i+2;
					break;
				}
			}
		}
		
//		for (int i = 0; i < nums.length; i++) {
//			System.out.println(nums[i]);
//		}
		
		nums = Arrays.copyOf(nums, countLen);

		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
		
		return nums.length;
	}

	private static void replace(int index, int[] nums, int num) {

		int nextIndex = index + 1;

		for (int i = index; i < nums.length - 1; i++) {

			if (num == nums[nextIndex]) {

				nextIndex++;

				i = i - 1;

			} else {

				nums[i] = nums[nextIndex];

				nextIndex++;

			}

			if (nextIndex == nums.length)
				return;
		}

	}

	public static void main(String[] args) {

		int[] nums = new int[] { -14, -14, -14, -14, -14, -14, -14, -13, -13, -13, -13, -12, -11, -11, -11, -9, -9, -9,
				-7, -7, -7, -6, -6, -5, -5, -5, -4, -4, -4, -3, -3, -3, -2, -2, -2, -1, -1, 0, 0, 0, 0, 1, 1, 1, 2, 2,
				2, 2, 3, 3, 3, 3, 3, 4, 4, 4, 5, 5, 6, 6, 6, 7, 7, 7, 7, 8, 8, 8, 8, 9, 9, 10, 10, 11, 11, 11, 11, 11,
				12, 12, 12, 12, 13, 13, 13, 13, 14, 14, 15, 16, 17, 18, 18, 18, 20, 20, 21, 21, 21, 21, 21, 22, 22, 22,
				22, 23, 24, 24, 25 };
		// int[] nums = new int[] { 1, 1, 1, 2, 2, 3 };
		removeDuplicates(nums);
	}
}
