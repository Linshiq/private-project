package com.csii.enter;

import java.util.ArrayList;
import java.util.List;

/** 
* @author  Linshiq: 
* @date 创建时间：2017年1月3日 下午2:29:57 
* @version 1.0 
* @parameter  
* @since  
* @return  
*/
/**
 * <p>
 * 文件功能说明：
 * 
 * </p>
 * 
 * @Author linshiqin
 *         <p>
 *         <li>2017年1月3日-下午2:29:57</li>
 *         <li>修改记录</li>
 *         <li>-----------------------------------------------------------</li>
 *         <li>标记：修订内容</li>
 *         <li>linshiqin：创建注释模板</li>
 *         <li>-----------------------------------------------------------</li>
 *         </p>
 */
public class testso {
	public List<List<Integer>> threeSum(int[] nums) {
        
		List<List<Integer>> list = new ArrayList<>();
		
		for(int i = 0 ; i < nums.length ; i++){
			for(int j=0; j < nums.length ; j++){
				if(i == j)
					continue;
				else if(nums[i] + nums[j] == getThree(i, j, nums)){
					List<Integer> listOne = new ArrayList<>();
					listOne.add(nums[i]);
					listOne.add(nums[j]);
					listOne.add(getThree(i, j, nums));
					list.add(listOne);
				}
					
			}
		}
		
		return list;
    }
	
	public int getThree(int one ,int two,int[] nums){
		
		int three = 0;
		
		for(int i=0;i< nums.length;i++){
			if(i==one || two == i)
				continue;
			else
				three = nums[i];
		}
		
		return three;
	}
	
	public static void main(String[] args) {
		
	}
}
