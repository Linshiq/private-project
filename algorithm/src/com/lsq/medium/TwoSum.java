package com.lsq.medium;

/** 
* @author  Linshiq: 
* @date 创建时间：2017年1月16日 下午4:34:34 
* @version 1.0 
* @parameter  
* @since  
* @return  
*/
/**
 * <p>
 * 文件功能说明：
 *     给一个整数数组，找到两个数使得他们的和等于一个给定的数 target。
 *
 *	     你需要实现的函数twoSum需要返回这两个数的下标, 并且第一个下标小于第二个下标。注意这里下标的范围是 1 到 n，不是以 0 开头。 
 *
 * 		 注意事项:
 * 			你可以假设只有一组答案。
 * 
 * 		样例
 * 			给出 numbers = [2, 7, 11, 15], target = 9, 返回 [1, 2].			
 * </p>
 * 
 * @Author linshiqin
 *         <p>
 *         <li>2017年1月16日-下午4:34:34</li>
 *         <li>修改记录</li>
 *         <li>-----------------------------------------------------------</li>
 *         <li>标记：修订内容</li>
 *         <li>linshiqin：创建注释模板</li>
 *         <li>-----------------------------------------------------------</li>
 *         </p>
 */
public class TwoSum {
	
	/*
     * @param numbers : An array of Integer
     * @param target : target = numbers[index1] + numbers[index2]
     * @return : [index1 + 1, index2 + 1] (index1 < index2)
     */
    public static int[] twoSum(int[] numbers, int target) {
        // write your code here
    	
    	int[] result = new int[2];
    	
    	//Arrays.sort(numbers);
    	
    	for (int i = 0; i < numbers.length - 1; i++) {
			
    		for (int j = i+1; j < numbers.length; j++) {
				
    			if(numbers[i] + numbers[j] == target){
    				
    				
    				result[0] = i + 1;
    				result[1] = j + 1;
    				
    				return result;
    			}
			}
		}
    	
    	return result;
    }
    
    public static void main(String[] args) {
    	int[] numbers = new int[] {1,0,-1};
    	
    	System.out.println();
    	
    	for(int i:twoSum(numbers, -1)){
    		
    		System.out.println(i+",");
    	}
	}
}
