package com.lsq.easy;

import java.util.Arrays;

/** 
* @author  Linshiq: 
* @date 创建时间：2017年1月13日 下午4:53:42 
* @version 1.0 
* @parameter  
* @since  
* @return  
*/
/**
 * <p>
 * 文件功能说明：
 *       合并两个排序的整数数组A和B变成一个新的数组。
 *       
 *        注意事项:
 *        	你可以假设A具有足够的空间（A数组的大小大于或等于m+n）去添加B中的元素。
 *        
 *        样例:
 *        
 *        给出 A = [1, 2, 3, empty, empty], B = [4, 5]
 *        合并之后 A 将变成 [1,2,3,4,5]			
 * </p>
 * 
 * @Author linshiqin
 *         <p>
 *         <li>2017年1月13日-下午4:53:42</li>
 *         <li>修改记录</li>
 *         <li>-----------------------------------------------------------</li>
 *         <li>标记：修订内容</li>
 *         <li>linshiqin：创建注释模板</li>
 *         <li>-----------------------------------------------------------</li>
 *         </p>
 */
public class MergeSortedArray {
	/**
     * @param A: sorted integer array A which has m elements, 
     *           but size of A is m+n
     * @param B: sorted integer array B which has n elements
     * @return: void
     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        // write your code here
    	
    	if(A.length > m+n)
    		return ;
    	
    	int indexB = 0;
    	
    	for(int i=m;i<m+n;i++){
    		
    		if(indexB < n){
    			A[i] = B[indexB];
    			
    			indexB++;
    		}else
    			break;
    		
    	}
    	
    	Arrays.sort(A);
    }
}
