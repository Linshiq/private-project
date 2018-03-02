package com.lsq.problem;

/** 
* @author  Linshiq: 
* @date 创建时间：2018年2月22日 下午4:50:47 
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
 *         <li>2018年2月22日-下午4:50:47</li>
 *         <li>修改记录</li>
 *         <li>-----------------------------------------------------------</li>
 *         <li>标记：修订内容</li>
 *         <li>linshiqin：创建注释模板</li>
 *         <li>-----------------------------------------------------------</li>
 *         </p>
 */
public class Solution4 {

	private static int num = 1;
	private final static int two = 2;
	private final static int three = 3;
	private final static int five = 5;

	/**
	 * @Author linshiqin
	 *         <p>
	 *         <li>2018年2月22日-下午4:51:14</li>
	 *         <li>功能说明：设计一个算法，找出只含素因子2，3，5 的第 n 小的数。
	 * 
	 *         符合条件的数如：1, 2, 3, 4, 5, 6, 8, 9, 10, 12...
	 * 
	 *         注意事项 我们可以认为1也是一个丑数</li>
	 *         </p>
	 * @param n
	 * @return
	 */
	public int nthUglyNumber(int n) {

		int countN = 0;
		int m = 0;
		int lastNumber = 2;

		while (countN < n) {
			m++;
			int number = m;
			while (number % two == 0)
				number = number / 2;
			while (number % three == 0)
				number = number / 3;
			while (number % five == 0)
				number = number / 5;
			if (number == 1) {
				countN++;
			}
		}

		return m;
	}
}
