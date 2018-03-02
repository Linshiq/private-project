package com.lsq.medium;

import java.util.ArrayList;
import java.util.Arrays;

/** 
* @author  Linshiq: 
* @date 创建时间：2017年1月16日 下午3:57:31 
* @version 1.0 
* @parameter  
* @since  
* @return  
*/
/**
 * <p>
 * 文件功能说明： 给出一个有n个整数的数组S，在S中找到三个整数a, b, c，找到所有使得a + b + c = 0的三元组。
 * 
 * 注意事项 在三元组(a, b, c)，要求a <= b <= c。 结果不能包含重复的三元组。不能使用while循环,否则空间会超过限制,可以使用for循环
 * 
 * 样例 如S = {-1 0 1 2 -1 -4}, 你需要返回的三元组集合的是： (-1, 0, 1) (-1, -1, 2)
 * 
 * 
 * 
 * </p>
 * 
 * @Author linshiqin
 *         <p>
 *         <li>2017年1月16日-下午3:57:31</li>
 *         <li>修改记录</li>
 *         <li>-----------------------------------------------------------</li>
 *         <li>标记：修订内容</li>
 *         <li>linshiqin：创建注释模板</li>
 *         <li>-----------------------------------------------------------</li>
 *         </p>
 */
public class ThreeSum {
	/**
	 * @param numbers
	 *            : Give an array numbers of n integer
	 * @return : Find all unique triplets in the array which gives the sum of
	 *         zero.
	 */
	public static ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
		// write your code here

		ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
		ArrayList<Integer> list = new ArrayList<>();
		Arrays.sort(numbers);

		int sum = 0;

		if (numbers.length < 3)
			return null;

		for (int i = 0; i < numbers.length; i++) {

			for (int l = i + 1; l < numbers.length; l++) {

				for (int k = l + 1; k < numbers.length; k++) {

					sum = numbers[i] + numbers[l] + numbers[k];

					if (sum == 0) {

						list.add(numbers[i]);
						list.add(numbers[l]);
						list.add(numbers[k]);

						if (!arrayList.contains(list)) {

							arrayList.add(list);
						}

						list = new ArrayList<>();

					}

				}
			}

		}

		return arrayList;
	}

	public static void main(String[] args) {

		int[] numbers = new int[] { 1, 0, -1, -1, -1, -1, 0, 1, 1, 1 };

		for (ArrayList<Integer> l : threeSum(numbers)) {

			for (int i : l) {

				System.out.print(i + ",");
			}
			System.out.println();
		}
	}
}
