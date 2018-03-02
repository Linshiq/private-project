package com.lsq.problem;
/** 
* @author  Linshiq: 
* @date 创建时间：2018年1月25日 下午2:00:01 
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
 *         <li>2018年1月25日-下午2:00:01</li>
 *         <li>修改记录</li>
 *         <li>-----------------------------------------------------------</li>
 *         <li>标记：修订内容</li>
 *         <li>linshiqin：创建注释模板</li>
 *         <li>-----------------------------------------------------------</li>
 *         </p>
 */
public class Solution125 {

	/*
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @param V: Given n items with value V[i]
     * @return: The maximum value
     */
    public int backPackII(int m, int[] A, int[] V) {
        // write your code here
    	
		/*
		 * 给出n个物品的体积A[i]和其价值V[i]，将他们装入一个大小为m的背包，最多能装入的总价值有多大？
		 * 
		 * 注意事项 A[i], V[i], n, m均为整数。你不能将物品进行切分。你所挑选的物品总体积需要小于等于给定的m。
		 */
    	
		/*
		 * 样例 对于物品体积[2, 3, 5, 7]和对应的价值[1, 5, 2, 4], 假设背包大小为10的话，最大能够装入的价值为9。
		 */
    	
    	if(A.length != V.length || m <= 0){
    		return m;
    	}
    	
    	int value = 0;
    	
    	for (int i = 0; i < A.length; i++) {
			
    		
		}
    	
    	return 0;
    }
}
