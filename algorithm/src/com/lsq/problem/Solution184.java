package com.lsq.problem;

import java.util.Arrays;

/** 
* @author  Linshiq: 
* @date 创建时间：2018年1月26日 下午4:21:03 
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
 *         <li>2018年1月26日-下午4:21:03</li>
 *         <li>修改记录</li>
 *         <li>-----------------------------------------------------------</li>
 *         <li>标记：修订内容</li>
 *         <li>linshiqin：创建注释模板</li>
 *         <li>-----------------------------------------------------------</li>
 *         </p>
 */
public class Solution184 {
	/*
	 * @param nums: A list of non negative integers
	 * 
	 * @return: A string
	 */
	public static String largestNumber(int[] nums) {
		// write your code here
		
		/*
		 * 给出一组非负整数，重新排列他们的顺序把他们组成一个最大的整数。
		 * 
		 * 注意事项 最后的结果可能很大，所以我们返回一个字符串来代替这个整数。
		 * 
		 * 您在真实的面试中是否遇到过这个题？ Yes 样例 给出 [1, 20, 23, 4, 8]，返回组合最大的整数应为8423201。
		 */
		
		String[] str = new String[nums.length];
		
		for (int i = 0; i < nums.length; i++) {
			str[i] = nums[i]+"";
		}
		
		Arrays.sort(str);
		
		StringBuffer sb = new StringBuffer();
		
		for (int i = 9; i >= 0; i--) {
			
			for (int j = str.length - 1; j >= 0; j--) {// 先找出全是9的数字
				
				if((str[0].charAt(0)+"").equals(i)){
					
					
				}
			}
		}
		
		
				
		if("0".equals(str[str.length - 1]) && str[0].equals(str[str.length - 1])){
			return "0"; 
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		
		System.out.println(largestNumber(new int[]{41,23,87,55,50,53,18,9,39,63,35,33,54,25,26,49,74,61,32,81,97,99,38,96,22,95,35,57,80,80,16,22,17,13,89,11,75,98,57,81,69,8,10,85,13,49,66,94,80,25,13,85,55,12,87,50,28,96,80,43,10,24,88,52,16,92,61,28,26,78,28,28,16,1,56,31,47,85,27,30,85,2,30,51,84,50,3,14,97,9,91,90,63,90,92,89,76,76,67,55}));
	}
}
