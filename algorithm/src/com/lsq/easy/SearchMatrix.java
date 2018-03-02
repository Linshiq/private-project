package com.lsq.easy;

/** 
* @author  Linshiq: 
* @date 创建时间：2017年1月17日 下午7:25:19 
* @version 1.0 
* @parameter  
* @since  
* @return  
*/
/**
 * <p>
 * 文件功能说明： 写出一个高效的算法来搜索 m × n矩阵中的值。
 * 
 * 这个矩阵具有以下特性： 每行中的整数从左到右是排序的 每行的第一个数大于上一行的最后一个整数。
 * 
 * 样例
 * 
 * [ [1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 50] ]
 * 
 * 给出 target = 3，返回 true
 * </p>
 * 
 * @Author linshiqin
 *         <p>
 *         <li>2017年1月17日-下午7:25:19</li>
 *         <li>修改记录</li>
 *         <li>-----------------------------------------------------------</li>
 *         <li>标记：修订内容</li>
 *         <li>linshiqin：创建注释模板</li>
 *         <li>-----------------------------------------------------------</li>
 *         </p>
 */
public class SearchMatrix {
	/**
	 * @param matrix,
	 *            a list of lists of integers
	 * @param target,
	 *            an integer
	 * @return a boolean, indicate whether matrix contains target
	 */
	public boolean searchMatrix(int[][] matrix, int target) {
		// write your code here

		 int index = matrix.length / 2;
	        int len = 0;
	        if( matrix.length > 0){
			    len = matrix[0].length;

	    		if (matrix[index][0] >= target) {
	    
	    			for (int i = 0; i <= index / 2; i++) {
	    
	    				for (int j = 0; j < len; j++) {
	    					if (matrix[i][j] == target)
	    						return true;
	    				}
	    
	    			}
	    		} else {
	    
	    			for (int i = index; i < matrix.length; i++) {
	    
	    				for (int j = 0; j < len; j++) {
	    					if (matrix[i][j] == target)
	    						return true;
	    				}
	    			}
	    		}
	        }
			return false;
	}
}
