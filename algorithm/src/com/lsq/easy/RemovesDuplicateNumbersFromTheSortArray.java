package com.lsq.easy;

import java.util.Arrays;

/** 
* @author  Linshiq: 
* @date 创建时间：2017年1月13日 下午3:42:10 
* @version 1.0 
* @parameter  
* @since  
* @return  
*/
/**
 * <p>
 * 文件功能说明：
 *       给定一个排序数组，在原数组中删除重复出现的数字，使得每个元素只出现一次，并且返回新的数组的长度。
 *       不要使用额外的数组空间，必须在原地没有额外空间的条件下完成。		
 *       
 *       样例:
 *       给出数组A =[1,1,2]，你的函数应该返回长度2，此时A=[1,2]。	
 * </p>
 * 
 * @Author linshiqin
 *         <p>
 *         <li>2017年1月13日-下午3:42:10</li>
 *         <li>修改记录</li>
 *         <li>-----------------------------------------------------------</li>
 *         <li>标记：修订内容</li>
 *         <li>linshiqin：创建注释模板</li>
 *         <li>-----------------------------------------------------------</li>
 *         </p>
 */
public class RemovesDuplicateNumbersFromTheSortArray {
	/**
     * @param A: a array of integers
     * @return : return an integer
     */
    public static int removeDuplicates(int[] nums) {
        // write your code here
    	
    	int result = 0;
    	
    	for(int i=0;i<nums.length;i++){
    		
    		if(i-1 == -1 || i+1 == nums.length)
    			continue;
    		if(nums[i]==nums[i-1] && nums[i]<nums[i+1]){
    			
    			nums[i] = nums[i+1];
    			
    			result = compare(i-1, nums);
    			
    			i = result != -1?result:i;
    		}
    	}
    	
    	int count = 0;
    	
    	for(int i=0;i<nums.length;i++){
    		
    		if(i+1<nums.length&& nums[i] == nums[i+1]){
    			count = i+1;
    			break;
    		}else{
    			count = i+1;
    		}
    	}
    	
    	//nums = new int[]{};
    	nums = Arrays.copyOf(nums, count);
    	
    	for(int i:nums)
    		System.out.print(i+" ");
    	
    	System.out.println();
    	
    	return count;
    }
    
    private static int compare(int index,int[] nums){
    	
    	if(index-1 == -1 || index+1 == nums.length)
			return -1;
    	
		if(nums[index]==nums[index-1] && nums[index]<nums[index+1]){
			
			nums[index] = nums[index+1];
			compare(index-1, nums);
		}else{
			return index+1;
		}
		
		return -1;
    }
    
    public static void main(String[] args) {
    	
    	int[] nums = new int[]{-10,0,1,2,3};
    	
		System.out.println("end:"+removeDuplicates(nums));
	}
}
