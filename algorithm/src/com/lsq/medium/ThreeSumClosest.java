package com.lsq.medium;

/** 
* @author  Linshiq: 
* @date 创建时间：2017年1月16日 下午2:26:39 
* @version 1.0 
* @parameter  
* @since  
* @return  
*/
/**
 * <p>
 * 文件功能说明： 给一个包含 n 个整数的数组 S, 找到和与给定整数 target 最接近的三元组，返回这三个数的和。
 * 
 * 注意事项! 只需要返回三元组之和，无需返回三元组本身
 * 
 * 样例 例如 S = [-1, 2, 1, -4] and target = 1. 和最接近 1 的三元组是 -1 + 2 + 1 = 2.
 * </p>
 * 
 * @Author linshiqin
 *         <p>
 *         <li>2017年1月16日-下午2:26:39</li>
 *         <li>修改记录</li>
 *         <li>-----------------------------------------------------------</li>
 *         <li>标记：修订内容</li>
 *         <li>linshiqin：创建注释模板</li>
 *         <li>-----------------------------------------------------------</li>
 *         </p>
 */
public class ThreeSumClosest {

	/**
	 * @param numbers:
	 *            Give an array numbers of n integer
	 * @param target
	 *            : An integer
	 * @return : return the sum of the three integers, the sum closest target.
	 */
	public static int threeSumClosest(int[] numbers, int target) {
		// write your code here
		int sum = 0;
		int result = 0;
		int difference = 0;

		int minDifference = Integer.MAX_VALUE;

		if (numbers.length < 3)
			return sum;

		int i = 0;
		int j = 1;
		int k = 2;

		while (i < numbers.length - 2) {
						
			sum = numbers[i] + numbers[j] + numbers[k];

			difference = Math.abs(target - sum);

			if (difference == 0) {

				return sum;
			} else if (difference < minDifference) {

				minDifference = difference;

				result = sum;

				k++;
			} else {
				
				k++;
			}
			
			if( k == numbers.length){
				
				j++;
				k = j + 1;
			}
			
			if( j == numbers.length -1){
				
				i ++ ;
				j = i + 1;
				k = j + 1;
			}
			
			System.out.println(k);
		}

		return result;
	}

	public static void main(String[] args) {

		int[] numbers = new int[] { -2, -3, -4, -5, -100, 99, 1, 4, 4, 4, 5, 1, 0, -1, 2, 3, 4, 5 };

		System.out.println("end:" + threeSumClosest(numbers, 77));
	}
}
