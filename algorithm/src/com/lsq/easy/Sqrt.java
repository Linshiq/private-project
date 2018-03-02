package com.lsq.easy;

/** 
* @author  Linshiq: 
* @date 创建时间：2017年1月17日 上午10:39:54 
* @version 1.0 
* @parameter  
* @since  
* @return  
*/
/**
 * <p>
 * 文件功能说明： 实现 int sqrt(int x) 函数，计算并返回 x 的平方根。
 * 
 * 样例 sqrt(3) = 1
 * 
 * sqrt(4) = 2
 * 
 * sqrt(5) = 2
 * 
 * sqrt(10) = 3
 * </p>
 * 
 * @Author linshiqin
 *         <p>
 *         <li>2017年1月17日-上午10:39:54</li>
 *         <li>修改记录</li>
 *         <li>-----------------------------------------------------------</li>
 *         <li>标记：修订内容</li>
 *         <li>linshiqin：创建注释模板</li>
 *         <li>-----------------------------------------------------------</li>
 *         </p>
 */
public class Sqrt {
	/**
	 * @param x:
	 *            An integer
	 * @return: The sqrt of x
	 */
	public static int sqrt(int x) {
		// write your code here

		if (x == 1)
			return 1;

		for (double i = 1; i <= x/2; i++) {

			if (i * i == x) {

				return (int)i;
			} else if(i * i > x){
				
				return (int)i-1;
			}
		}
				
		return 0;
	}
	
	public static void main(String[] args) {
		
		System.out.println("end:"+sqrt(2147483647));
	}
}
