package com.lsq.medium;

/** 
* @author  Linshiq: 
* @date 创建时间：2017年2月14日 下午3:38:22 
* @version 1.0 
* @parameter  
* @since  
* @return  
*/
/**
 * <p>
 * 文件功能说明： 给定一个包含 n 个整数的排序数组，找出给定目标值 target 的起始和结束位置。 如果目标值不在数组中，则返回[-1, -1]
 * 
 * 样例:
 * 
 * 给出[5, 7, 7, 8, 8, 10]和目标值target=8,返回[3, 4]
 * </p>
 * 
 * @Author linshiqin
 *         <p>
 *         <li>2017年2月14日-下午3:38:22</li>
 *         <li>修改记录</li>
 *         <li>-----------------------------------------------------------</li>
 *         <li>标记：修订内容</li>
 *         <li>linshiqin：创建注释模板</li>
 *         <li>-----------------------------------------------------------</li>
 *         </p>
 */
public class SearchRange {
	/**
	 * @param A
	 *            : an integer sorted array
	 * @param target
	 *            : an integer to be inserted return : a list of length 2,
	 *            [index1, index2]
	 */
	public int[] searchRange(int[] A, int target) {
		// write your code here

		int[] result = new int[] { -1, -1 };

		if (A.length == 0) {

			return result;
		} else if (A.length == 1 && A[0] == target) {

			return new int[] { 0, 0 };
		}

		int index = A.length / 2;

		int start = -1;
		int end = -1;

		if (A[index] > target) {

			for (int i = index - 1; i >= 0; i--) {

				if (A[i] == target) {
					if (end == -1) {
						end = i;
					}
					start = i;

				} 
			}

		} else if (A[index] < target) {

			for (int i = index + 1; i < A.length; i++) {

				if (A[i] == target) {
					if (start == -1) {
						start = i;
					}
					end = i;

				} 
			}

		} else {

			for (int i = index; i >= 0; i--) {

				if (A[i] == target) {
					start = i;
				} else {
					break;
				}
			}

			for (int i = index; i < A.length; i++) {

				if (A[i] == target) {
					end = i;
				} else {
					break;
				}
			}
		}

		result[0] = start;
		result[1] = end;

		return result;
	}
}
