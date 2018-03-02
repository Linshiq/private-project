package com.lsq.easy;

/** 
* @author  Linshiq: 
* @date 创建时间：2017年1月12日 下午5:53:08 
* @version 1.0 
* @parameter  
* @since  
* @return  
*/
/**
 * <p>
 * 文件功能说明：
 *       	给定一个数组和一个值，在原地删除与值相同的数字，返回新数组的长度。

			元素的顺序可以改变，并且对新的数组不会有影响。	
			
			样例
				给出一个数组 [0,4,4,0,0,2,4,4]，和值 4
				
				返回 4 并且4个元素的新数组为[0,0,0,2]
 * </p>
 * 
 * @Author linshiqin
 *         <p>
 *         <li>2017年1月12日-下午5:53:08</li>
 *         <li>修改记录</li>
 *         <li>-----------------------------------------------------------</li>
 *         <li>标记：修订内容</li>
 *         <li>linshiqin：创建注释模板</li>
 *         <li>-----------------------------------------------------------</li>
 *         </p>
 */
public class DeleteElement {
	/** 
     *@param A: A list of integers
     *@param elem: An integer
     *@return: The new length after remove
     */
    public static int removeElement(int[] A, int elem) {
        // write your code here
    	
    	int count = 0;
    	
    	int index = 0;
    	
    	for(int i=0;i<A.length;i++){
    		
    		if(A[i] != elem){
    			count  ++;
    			
    			A[index] = A[i];
    			index++;
    		}
    	}
    	
    	return count;
    	
    }
    
    
    
    public static void main(String[] args) {
    	
    	int[] A = new int[]{2};
    	
    	System.out.println("end"+removeElement(A, 3));
	}
}
