package com.lsq.medium;

import java.util.Arrays;

/** 
* @author  Linshiq: 
* @date 创建时间：2017年1月14日 下午2:41:40 
* @version 1.0 
* @parameter  
* @since  
* @return  
*/
/**
 * <p>
 * 文件功能说明： 给出一个无序的正数数组，找出其中没有出现的最小正整数。
 * 
 * 样例
 * 
 * 如果给出 [1,2,0], return 3
 * 
 * 如果给出 [3,4,-1,1], return 2
 * </p>
 * 
 * @Author linshiqin
 *         <p>
 *         <li>2017年1月14日-下午2:41:40</li>
 *         <li>修改记录</li>
 *         <li>-----------------------------------------------------------</li>
 *         <li>标记：修订内容</li>
 *         <li>linshiqin：创建注释模板</li>
 *         <li>-----------------------------------------------------------</li>
 *         </p>
 */
public class FirstMissingPositive {
	/**
	 * @param A:
	 *            an array of integers
	 * @return: an integer
	 */
	public static int firstMissingPositive(int[] A) {
		// write your code here
		int count = 0;

		Arrays.sort(A);

		for (int i = 0; i < A.length; i++) {
			count++;
			if (A[i] > 0) {
				return getMinPositive(i, A, count);
			}
		}

		if (count == A.length)
			return 1;
		else
			return 0;
	}

	private static int getMinPositive(int index, int[] A, int count) {
		count--;
		if (A[index] != 1)
			return 1;
		
		for (int i = index; i < A.length; i++) {
			count++;
			System.out.println(A[i]);
			if (i + 1 == A.length || i == index)
				continue;

			if (A[i + 1] - A[i] != 1 && A[i + 1] - A[i] != 0) {
				return A[i] + 1;
			} else if (A[i] - A[i - 1] != 1 && A[i] - A[i - 1] != 0) {
				return A[i] - 1;
			}
		}
		if (count == A.length)
			return A[A.length - 1] + 1;
		else
			return A[index] + 1;
	}
	
	public static void main(String[] args) {
		
		int[] A = new int[]{2,2,4,0,1,3,3,3,4,3};
		
		System.out.println("end"+firstMissingPositive(A));
	}
}
