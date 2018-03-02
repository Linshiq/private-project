package com.lsq.medium;

import java.util.ArrayList;
import java.util.List;

/** 
* @author  Linshiq: 
* @date 创建时间：2017年1月6日 下午2:24:32 
* @version 1.0 
* @parameter  
* @since  
* @return  
*/
/**
 * <p>
 * 文件功能说明：
 *       	 和大于S的最小子数组
 *       样例
 *		给定数组 [2,3,1,2,4,3] 和 s = 7, 子数组 [4,3] 是该条件下的最小长度子数组。		
 * </p>
 * 
 * @Author linshiqin
 *         <p>
 *         <li>2017年1月6日-下午2:24:32</li>
 *         <li>修改记录</li>
 *         <li>-----------------------------------------------------------</li>
 *         <li>标记：修订内容</li>
 *         <li>linshiqin：创建注释模板</li>
 *         <li>-----------------------------------------------------------</li>
 *         </p>
 */
public class MinimumSubarrayLargerThanS {
	
	private static StringBuffer Str = new StringBuffer();
	private static List<String> listStr = new ArrayList<>();
	/**
     * @param nums: an array of integers
     * @param s: an integer
     * @return: an integer representing the minimum size of subarray
     */
    public int minimumSize(int[] nums, int s) {
        // write your code here    	
    	int sum = 0;
    	
    	for(int i=0;i<nums.length;i++){
//    		for(int j=i+1;j<nums.length;j++){
//    			
//    			sum = nums[i] + nums[j];
//    			if(sum >= s){
//    				Str = nums[i] + "," + nums[j];
//    				listStr.add(Str);
//    				System.out.println("minimumSize"+Str);
//    			}else{
//    				Str = nums[i] + "," + nums[j];;
//    				sum = getThree(j, sum, nums,s); 
//    				if(sum != -1){
//    					System.out.println(sum);
//    				}else{
//    					listStr.add(-1 +"");
//    				}				
//    			}		
//    		}
    		sum = nums[i];
    		if(sum >= s){
    			Str.append(nums[i]);
    			listStr.add(Str.toString());
    			Str.delete(0, Str.toString().length());
    		}else{
    			Str.append(nums[i]);
    			sum = getThree(i+1,sum, nums, s);
    			if(sum == -1){
    				listStr.add(-1 +"");
    			}
    		}
    		sum = 0;
    	}
    	int index = 1;
    	if(listStr.size() > 0){
	    	String strT = listStr.get(0);
	    	for(String Str:listStr){
	    		System.out.println(Str);
	    		if(index == listStr.size() && listStr.size()!=1){
	    			return -1;
	    		}else if(Str.equals("-1")){
	    			index++;
	    			continue;
	    		}
	    		if(strT.length() > Str.length()){
	    			strT = Str;
	    		}
	    	}
	    	
	    	index = 0;
	    	for(int i=0;i<strT.length();i++){
	    		if(strT.charAt(i) == ',')
	    			index++;
	    	}
	    	//String[] sN = strT.split(",");
	    	return index + 1;
    	}
    	return -1;
    }
    
    
    private static int getThree(int s,int sum,int[] nums,int result){
    	int sumNext = 0 ;
   	
    	for(int i = s;i<nums.length;i++){
    		
    		sumNext = sum + nums[i];
    		if(sumNext>=result){
    			Str.append( "," + nums[i]);
    			listStr.add(Str.toString());
    			Str.delete(0, Str.toString().length());
    			System.out.println("getT "+Str+" listStr " + listStr.size());
    			return sumNext;
    		}else{
    			Str.append( "," + nums[i]);
    			sumNext = getThree(i+1, sumNext, nums, result);
    			if(sumNext != -1){
					return sumNext;
				}else{
					System.out.println(sumNext);
				}
    		}
    	}
    	
    	return sumNext;
    }
    
    public static void main(String[] args) {
    	MinimumSubarrayLargerThanS s = new MinimumSubarrayLargerThanS();
    	
    	int[] nums =new int[]{9,1,8,2,7,3,6,4,5,10};
    	
    	System.out.println("END:"+s.minimumSize(nums, 55));
	}
}
