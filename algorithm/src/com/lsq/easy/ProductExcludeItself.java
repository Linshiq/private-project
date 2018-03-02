package com.lsq.easy;

import java.util.ArrayList;

/** 
* @author  Linshiq: 
* @date 创建时间：2017年1月14日 下午2:34:15 
* @version 1.0 
* @parameter  
* @since  
* @return  
*/
/**
 * <p>
 * 文件功能说明：
 *    给定一个整数数组A。
 *    
 *       定义B[i] = A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1]， 计算B的时候请不要使用除法。
 *       
 *       样例
 *       给出A=[1, 2, 3]，返回 B为[6, 3, 2]			
 * </p>
 * 
 * @Author linshiqin
 *         <p>
 *         <li>2017年1月14日-下午2:34:15</li>
 *         <li>修改记录</li>
 *         <li>-----------------------------------------------------------</li>
 *         <li>标记：修订内容</li>
 *         <li>linshiqin：创建注释模板</li>
 *         <li>-----------------------------------------------------------</li>
 *         </p>
 */
public class ProductExcludeItself {
	/**
     * @param A: Given an integers array A
     * @return: A Long array B and B[i]= A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1]
     */
    public ArrayList<Long> productExcludeItself(ArrayList<Integer> A) {
        // write your code
    	ArrayList<Long> arrayL = new ArrayList<>();
    	
    	for(int i = 0;i<A.size();i++){
    		
    		mul(arrayL, i, A);
    	}
    	
    	
    	return arrayL;
    }
    
    private void mul(ArrayList<Long> arrayL, int index ,ArrayList<Integer> A){
    	
    	Long mul = 1l;
    	
    	for(int i = 0;i<A.size();i++){
    		
    		if(i == index)
    			continue;
    		
    		mul = mul * A.get(i);
    	}
    	
    	arrayL.add(mul);
    }
}
