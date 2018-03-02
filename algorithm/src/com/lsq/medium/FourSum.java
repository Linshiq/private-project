package com.lsq.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** 
* @author  Linshiq: 
* @date 创建时间：2017年2月9日 上午10:24:33 
* @version 1.0 
* @parameter  
* @since  
* @return  
*/
/**
 * <p>
 * 文件功能说明： 给一个包含n个数的整数数组S，在S中找到所有使得和为给定整数target的四元组(a, b, c, d)。
 * 
 * 注意事项:
 * 
 * 四元组(a, b, c, d)中，需要满足a <= b <= c <= d
 * 
 * 答案中不可以包含重复的四元组。
 * 
 * 样例: 例如，对于给定的整数数组S=[1, 0, -1, 0, -2, 2] 和 target=0. 满足要求的四元组集合为：
 * 
 * (-1, 0, 0, 1) (-2, -1, 1, 2) (-2, 0, 0, 2)
 * </p>
 * 
 * @Author linshiqin
 *         <p>
 *         <li>2017年2月9日-上午10:24:33</li>
 *         <li>修改记录</li>
 *         <li>-----------------------------------------------------------</li>
 *         <li>标记：修订内容</li>
 *         <li>linshiqin：未解决</li>
 *         <li>-----------------------------------------------------------</li>
 *         </p>
 */
public class FourSum {

//	private static ArrayList<ArrayList<Integer>> resultAry = new ArrayList<>();
//	private static ArrayList<Integer> intAry = new ArrayList<>();

	/**
	 * @param numbers
	 *            : Give an array numbersbers of n integer
	 * @param target
	 *            : you need to find four elements that's sum of target
	 * @return : Find all unique quadruplets in the array which gives the sum of
	 *         zero.
	 */
	// 速度测试 方式1
	public static ArrayList<ArrayList<Integer>> fourSum(int[] numbers, int target) {
		/* your code */
		
		ArrayList<ArrayList<Integer>> resultAry = new ArrayList<>();
		
		ArrayList<Integer> intAry = null;
		
		Arrays.sort(numbers);
		
		int sum = 0;
		
		for (int i = 0; i < numbers.length - 3; i++) {
			
			sum = numbers[i];
			
			if (sum > target)
				break;
			
			for (int j = i+1; j < numbers.length - 2; j++) {
				
				sum = sum + numbers[j];
				
				if (sum > target){
					sum = sum - numbers[j];
					
					if(numbers[i] > 0 && numbers[j] > 0){
						break;
					}
						
					continue;
				}
				
				for (int j2 = j+1; j2 < numbers.length - 1; j2++) {
					
					sum = sum + numbers[j2];
					
					if (sum > target){
						sum = sum - numbers[j2];
						
						if(numbers[i] > 0 && numbers[j] > 0 && numbers[j2] > 0){
							break;
						}
						
						continue;
					}
					
					for (int k = j2+1; k < numbers.length; k++) {
						
						sum = sum + numbers[k];
						
						if (sum > target){
							sum = sum - numbers[k];
							
							if(numbers[i] > 0 && numbers[j] > 0 && numbers[j2] > 0 && numbers[k]>0){
								break;
							}
							
							continue;
						}
						else if(sum == target){
							
							intAry = new ArrayList<>();
							intAry.add(numbers[i]);
							intAry.add(numbers[j]);
							intAry.add(numbers[j2]);
							intAry.add(numbers[k]);
							
							if ( !resultAry.contains(intAry)) {

								resultAry.add(intAry);
							}
						}
						
						sum = sum - numbers[k];
					}
					
					sum = sum - numbers[j2];
				}
				
				sum = sum - numbers[j];
			}
		}

		return resultAry;

	}
	
	// 速度测试 方式二
	public static List<List<Integer>> fourSum2(int[] numbers, int target) {
		/* your code */
		List<List<Integer>> resultAry = new ArrayList<List<Integer>>();

		if (numbers == null || numbers.length <= 3) {
			return resultAry;
		}
		else if (numbers.length == 4) {

			if ((numbers[0] + numbers[1] + numbers[2] + numbers[3]) != target) {

				return resultAry;
			}
			else {
				ArrayList<Integer> subList = new ArrayList<Integer>();
				subList.add(numbers[0]);
				subList.add(numbers[1]);
				subList.add(numbers[2]);
				subList.add(numbers[3]);
				resultAry.add(subList);
				return resultAry;
			}
		}

		Arrays.sort(numbers);
		
		if((numbers[numbers.length - 1] < 0 && target > 0 ) || (numbers[0] > target)){
			return resultAry;
		}
		
		handle(numbers, new ArrayList<Integer>(), resultAry, 0, target, 0);

		return resultAry;

	}

	private static void handle(int[] numbers, ArrayList<Integer> subList, List<List<Integer>> resultAry, int sum, int target, int index) {

		if (index >= numbers.length  || subList.size() > 4 || sum > target) {
			return;
		}
			
		for (int i = index; i < numbers.length; i++) {

			sum += numbers[i];

			if (sum > target) {
				return;
			}

			subList.add(numbers[i]);
			
			if (subList.size() == 4) {

				if (sum == target) {

					List<Integer> copy = new ArrayList<Integer>(subList);

					//	Collections.sort(copy);

					if (!resultAry.contains(copy)) {
						resultAry.add(copy);
					}

				}

				subList.remove(subList.size() - 1);
			}
			else if (subList.size() < 4) {

				handle(numbers, subList, resultAry, sum, target, i + 1);

				subList.remove(subList.size() - 1);
			}
			else {

				subList.remove(subList.size() - 1);
				return;
			}

			sum -= numbers[i];
		}
	}
	
	public static void main(String[] args) {
		
		
		
		int[] numbers = new int[] {1,2,5,6,7,3,5,8,-33,-5,-72,12,-34,100,99,1,2,5,6,7,3,5,8,-33,-5,-72,12,-34,100,0,0,-2,2,-5,99,1,2,5,6,7,3,5,8,-33,-5,-72,12,-34,100,99,1,2,5,6,7,3,5,8,-33,-5,-72,12,-34,100,99,1,2,5,6,7,3,5,8,-33,-5,-72,12,-34,100,99,1,2,5,6,7,3,5,8,-33,-5,-72,12,-34,100,99,1,2,5,6,7,3,5,8,-33,-5,-72,12,-34,100,99,1,2,5,6,7,3,5,8,-33,-5,-72,12,-34,100,99,1,2,5,6,7,3,5,8,-33,-5,-72,12,-34,100,99,1,2,5,6,7,3,5,8,-33,-5,-72,12,-34,100,99,1,2,5,6,7,3,5,8,-33,-5,-72,12,-34,100,99,1,2,5,6,7,3,5,8,-33,-5,-72,12,-34,100,99,1,2,5,6,7,3,5,8,-33,-5,-72,12,-34,100,99,1,2,5,6,7,3,5,8,-33,-5,-72,12,-34,100,99,1,2,5,6,7,3,5,8,-33,-5,-72,12,-34,100,99,1,2,5,6,7,3,5,8,-33,-5,-72,12,-34,100,99,1,2,5,6,7,3,5,8,-33,-5,-72,12,-34,100,99,1,2,5,6,7,3,5,8,-33,-5,-72,12,-34,100,99,1,2,5,6,7,3,5,8,-33,-5,-72,12,-34,100,99,1,2,5,6,7,3,5,8,-33,-5,-72,12,-34,100,99};
		
		long startTime = System.currentTimeMillis();
		
		ArrayList<ArrayList<Integer>> s1 = fourSum(numbers, 11);
		
		long endTime = System.currentTimeMillis();
		
		System.out.println((endTime-startTime)+"ms");
		
		long startTime1 = System.currentTimeMillis();
		
		List<List<Integer>> s2 =  fourSum2(numbers, 11);
		
		long endTime1 = System.currentTimeMillis();
		
		System.out.println((endTime1-startTime1)+"ms");
		
		/*for (ArrayList<Integer> a : fourSum(numbers, 11)) {

			for (int b : a) {
				System.out.print(b + " ");
			}
			System.out.println();
		}*/
	}
}
