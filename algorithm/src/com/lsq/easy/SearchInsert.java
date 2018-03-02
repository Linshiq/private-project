package com.lsq.easy;
/** 
* @author  Linshiq: 
* @date 创建时间：2017年1月17日 上午11:33:19 
* @version 1.0 
* @parameter  
* @since  
* @return  
*/
/**
 * <p>
 * 文件功能说明：
 *       给定一个排序数组和一个目标值，如果在数组中找到目标值则返回索引。如果没有，返回到它将会被按顺序插入的位置。
 *       你可以假设在数组中无重复元素。
 *       
 *       样例
 *       
 *       [1,3,5,6]，5 → 2
 *
 *		[1,3,5,6]，2 → 1
 *		
 *		[1,3,5,6]， 7 → 4
 *		
 *		[1,3,5,6]，0 → 0			
 * </p>
 * 
 * @Author linshiqin
 *         <p>
 *         <li>2017年1月17日-上午11:33:19</li>
 *         <li>修改记录</li>
 *         <li>-----------------------------------------------------------</li>
 *         <li>标记：修订内容</li>
 *         <li>linshiqin：创建注释模板</li>
 *         <li>-----------------------------------------------------------</li>
 *         </p>
 */
public class SearchInsert {
	/** 
     * param A : an integer sorted array
     * param target :  an integer to be inserted
     * return : an integer
     */
    public int searchInsert(int[] A, int target) {
        // write your code here
    	
    	if(A.length>=1 && target < A[0])
    		return 0;
    		
    	for (int i = 0; i < A.length; i++) {
			
    		if(A[i] == target){
    			
    			return i;
    		}else if(A[i] > target){
    			
    			return i;
    		}
		}
    	
    	return A.length;
    }
}
