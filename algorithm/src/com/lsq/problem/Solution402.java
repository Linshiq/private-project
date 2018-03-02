package com.lsq.problem;

import java.util.ArrayList;
import java.util.List;

/** 
* @author  Linshiq: 
* @date 创建时间：2018年1月25日 下午5:06:20 
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
 *         <li>2018年1月25日-下午5:06:20</li>
 *         <li>修改记录</li>
 *         <li>-----------------------------------------------------------</li>
 *         <li>标记：修订内容</li>
 *         <li>linshiqin：创建注释模板</li>
 *         <li>-----------------------------------------------------------</li>
 *         </p>
 */
public class Solution402 {
	/*
	 * @param A: An integer array
	 * 
	 * @return: A list of integers includes the index of the first number and
	 * the index of the last number
	 */
	public static List<Integer> continuousSubarraySum(int[] A) {
		// write your code here

		List<Integer> result = new ArrayList<>();

		if (A == null || A.length <= 0) {
			return result;
		}

		result.add(0); // 无论如何先存首个地址

		if (A.length == 1) {

			result.add(0);
			return result;
		}

		int max = Integer.MIN_VALUE;

		int sum = 0;
		int startIndex = 0;

		for (int i = 0; i < A.length; i++) {

			if (sum <= 0) {// 小于等于0没必须接着往后加,重新开始计数

				startIndex = i; // 重置起始位置

				sum = A[i];
			} else {
				
				sum += A[i];
			}

			if (sum > max) {

				result = new ArrayList<>();

				result.add(startIndex);
				result.add(i);

				max = sum;
			}
		}

		return result;
	}

	public static void main(String[] args) {

		System.out.println(continuousSubarraySum(new int[] { -5, 10, 5, -3, 1, 1, 1, -2, 3, -4 }));
	}
}
