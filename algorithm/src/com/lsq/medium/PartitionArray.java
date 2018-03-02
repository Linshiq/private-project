package com.lsq.medium;

import java.util.Arrays;

/** 
* @author  Linshiq: 
* @date 创建时间：2017年1月16日 下午6:59:12 
* @version 1.0 
* @parameter  
* @since  
* @return  
*/
/**
 * <p>
 * 文件功能说明：
 *       	给出一个整数数组 nums 和一个整数 k。划分数组（即移动数组 nums 中的元素），使得：
 *       					所有小于k的元素移到左边
 *       					所有大于等于k的元素移到右边
 *       
 *       返回数组划分的位置，即数组中第一个位置 i，满足 nums[i] 大于等于 k。
 *       
 *       注意事项
 *        你应该真正的划分数组 nums，而不仅仅只是计算比 k 小的整数数，如果数组 nums 中的所有元素都比 k 小，则返回 nums.length。
 *        
 *        样例
 *        	给出数组 nums = [3,2,2,1] 和 k = 2，返回 1.
 *        		
 * </p>
 * 
 * @Author linshiqin
 *         <p>
 *         <li>2017年1月16日-下午6:59:12</li>
 *         <li>修改记录</li>
 *         <li>-----------------------------------------------------------</li>
 *         <li>标记：修订内容</li>
 *         <li>linshiqin：创建注释模板</li>
 *         <li>-----------------------------------------------------------</li>
 *         </p>
 */
public class PartitionArray {
	/** 
     *@param nums: The integer array you should partition
     *@param k: As description
     *return: The index after partition
     */
    public int partitionArray(int[] nums, int k) {
	    //write your code here
    	
    	Arrays.sort(nums);
    	
    	for (int i = 0; i < nums.length; i++) {
			
    		if(nums[i] >= k){
    			return i;
    		}
		}
    	
    	return nums.length;
    }
}
