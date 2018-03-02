package com.lsq.medium;

import java.util.Arrays;

/** 
* @author  Linshiq: 
* @date 创建时间：2017年3月15日 上午10:34:11 
* @version 1.0 
* @parameter  
* @since  
* @return  
*/
/**
 * <p>
 * 文件功能说明： 假设一个旋转排序的数组其起始位置是未知的（比如0 1 2 4 5 6 7 可能变成是4 5 6 7 0 1 2）。
 * 
 * 你需要找到其中最小的元素。
 * 
 * 你可以假设数组中不存在重复的元素。
 * 
 * 注意事项:
 * 
 * You may assume no duplicate exists in the array.
 * 
 * 样例: 给出[4,5,6,7,0,1,2] 返回 0
 * 
 * </p>
 * 
 * @Author linshiqin
 *         <p>
 *         <li>2017年3月15日-上午10:34:11</li>
 *         <li>修改记录</li>
 *         <li>-----------------------------------------------------------</li>
 *         <li>标记：修订内容</li>
 *         <li>linshiqin：创建注释模板</li>
 *         <li>-----------------------------------------------------------</li>
 *         </p>
 */
public class FindMin {
	/**
	 * @param nums:
	 *            a rotated sorted array
	 * @return: the minimum number in the array
	 */
	public int findMin(int[] nums) {
		// write your code here

		int min = 0;

		int len = nums.length;

		if (len == 0) {
			return 0;
		} else if (len == 1) {
			return nums[0];
		}

		int frist = nums[0];
		int end = nums[len - 1];

		if (end < frist) {// 首个比末位大说明已经旋转过了

			for (int i = len - 1; i > 0; i--) {
				
				if(nums[i-1]>nums[i]){
					return nums[i];
				}
			}

		} else {

			return frist;
		}

		return min;

	}

	private static int oneSolution(int[] nums) {

		Arrays.sort(nums);

		return nums.length > 0 ? nums[0] : 0;
	}
}
