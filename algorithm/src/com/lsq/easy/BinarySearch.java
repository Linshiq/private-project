package com.lsq.easy;

/** 
* @author  Linshiq: 
* @date 创建时间：2017年1月17日 下午7:17:14 
* @version 1.0 
* @parameter  
* @since  
* @return  
*/
/**
 * <p>
 * 文件功能说明： 给定一个排序的整数数组（升序）和一个要查找的整数target，用O(logn)的时间查找到target第一次出现的下标（从0开始），
 * 如果target不存在于数组中，返回-1。
 * 
 * 样例
 * 
 * 在数组 [1, 2, 3, 3, 4, 5, 10] 中二分查找3，返回2。
 * </p>
 * 
 * @Author linshiqin
 *         <p>
 *         <li>2017年1月17日-下午7:17:14</li>
 *         <li>修改记录</li>
 *         <li>-----------------------------------------------------------</li>
 *         <li>标记：修订内容</li>
 *         <li>linshiqin：创建注释模板</li>
 *         <li>-----------------------------------------------------------</li>
 *         </p>
 */
public class BinarySearch {

	/**
	 * @param nums:
	 *            The integer array.
	 * @param target:
	 *            Target to find.
	 * @return: The first position of target. Position starts from 0.
	 */
	public int binarySearch(int[] nums, int target) {
		// write your code here
		int index = nums.length / 2 - 1;

		if (nums[index] >= target) {

			for (int i = 0; i <= index; i++) {

				if (nums[i] == target)
					return i;
			}

		} else {

			for (int i = index; i < nums.length; i++) {

				if (nums[i] == target)
					return i;
			}
		}

		return -1;
	}
}
