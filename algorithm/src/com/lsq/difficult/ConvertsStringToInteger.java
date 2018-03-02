package com.lsq.difficult;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/** 
* @author  Linshiq: 
* @date 创建时间：2017年1月11日 下午4:50:01 
* @version 1.0 
* @parameter  
* @since  
* @return  
*/
/**
 * <p>
 * 文件功能说明： 实现atoi这个函数，将一个字符串转换为整数。如果没有合法的整数，返回0。如果整数超出了32位整数的范围，
 * 返回INT_MAX(2147483647)如果是正整数，或者INT_MIN(-2147483648)如果是负整数
 * 
 * 样例 "10" =>10
 * 
 * "-1" => -1
 * 
 * "123123123123123" => 2147483647
 * 
 * "1.0" => 1
 * 
 * "    52lintcode   " =>52 （一）.""的话返回0。
 * 
 * （二）.字符串两边有空格自动屏蔽，有小数点小数点后面的内容舍弃。
 * 
 * （三）."+123"和"123"效果一样。
 * 
 * （四）."a...","-h..."这种，除了符号位只要非数字打头，返回0。
 * 
 * （五）."123gdah3423","-123ff777"这种返回123，-123。
 * 
 * （六）.超了范围之后，判断正负性。
 * </p>
 * 
 * @Author linshiqin
 *         <p>
 *         <li>2017年1月11日-下午4:50:01</li>
 *         <li>修改记录</li>
 *         <li>-----------------------------------------------------------</li>
 *         <li>标记：修订内容</li>
 *         <li>linshiqin：创建注释模板</li>
 *         <li>-----------------------------------------------------------</li>
 *         </p>
 */
public class ConvertsStringToInteger {
	/**
	 * @param str:
	 *            A string
	 * @return An integer
	 */
	public static int atoi(String str) {
		// write your code here
		str = str.trim();

		StringBuffer sb = new StringBuffer();

		try {

			if ("".equals(str) || null == str)
				return 0;
			else
				return Integer.parseInt(str);

		} catch (NumberFormatException e) {

			if (str.charAt(0) != '-' && str.charAt(0) != '+') {

				processInteger(str, sb, 0);

				if (sb.length() == 0) {

					return 0;
				} else if (str.length() > sb.length()) {
					return Integer.parseInt(sb.toString());
				} else {
					return Integer.MAX_VALUE;
				}

			} else if (str.charAt(0) == '+') {

				processInteger(str, sb, 1);

				if (sb.length() == 0) {

					return 0;
				} else if (str.length() > sb.length()) {

					return Integer.parseInt(sb.toString());
				} else {

					return Integer.MAX_VALUE;
				}

			} else if (str.charAt(0) == '-') {
				sb.append(str.charAt(0));
				processInteger(str, sb, 1);

				if (sb.length() == 1) {

					return 0;
				} else if (str.length() > sb.length()) {

					return Integer.parseInt(sb.toString());

				} else {

					return Integer.MIN_VALUE;
				}
			}
		}
		return 0;

	}

	private static void processInteger(String str, StringBuffer sb, int index) {

		for (int i = index; i < str.length(); i++) {

			if (str.charAt(i) < '0' || str.charAt(i) > '9')
				break;

			sb.append(str.charAt(i));
		}
	}

	public static void main(String[] args) {
		
		//int a = 3;
		
		//fastPower(3, 5, 7);
		
		String s = "123455677612321,2321321321";
		
		String s1 = "232565646521321";
		
		System.out.println(s.contains(s1));
	}
	
	public static int fastPower(int a, int b, int n) {
		// write your code here
		
		BigDecimal aBig = BigDecimal.valueOf(a);
		
		BigDecimal bBig = BigDecimal.valueOf(b);
		
		for (int i = 0; i < n; i++) {
			
			aBig = aBig.multiply(aBig);
		}
		
		BigDecimal[] bigs = aBig.divideAndRemainder(bBig);
		
		StringBuffer sb = new StringBuffer();
		
		for(BigDecimal big:bigs){
			
			sb.append(big);
		}
		
		return Integer.valueOf(sb.toString());
    }
}
