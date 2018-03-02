package com.lsq.easy;

import java.util.Arrays;

/** 
* @author  Linshiq: 
* @date 创建时间：2017年2月7日 下午1:24:24 
* @version 1.0 
* @parameter  
* @since  
* @return  
*/
/**
 * <p>
 * 文件功能说明：合并两个排序的整数数组A和B变成一个新的数组。
 * 
 * 样例:
 * 
 * 给出A=[1,2,3,4]，B=[2,4,5,6]，返回 [1,2,2,3,4,4,5,6]
 * </p>
 * 
 * @Author linshiqin
 *         <p>
 *         <li>2017年2月7日-下午1:24:24</li>
 *         <li>修改记录</li>
 *         <li>-----------------------------------------------------------</li>
 *         <li>标记：修订内容</li>
 *         <li>linshiqin：创建注释模板</li>
 *         <li>-----------------------------------------------------------</li>
 *         </p>
 */
public class MergeSortedArrayII {

	/**
	 * @param A
	 *            and B: sorted integer array A and B.
	 * @return: A new sorted integer array
	 */
	public int[] mergeSortedArray(int[] A, int[] B) {
		// Write your code here

		int len = A.length + B.length;

		int[] C = new int[len];

		len = A.length;

		for (int i = 0; i < A.length; i++) {
			C[i] = A[i];
		}

		int index = 0;

		if (B.length > 0)

			for (int i = len; i < C.length; i++) {
				C[i] = B[index];
				index++;
			}

		Arrays.sort(C);

		return C;
	}
}
