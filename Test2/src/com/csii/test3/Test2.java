package com.csii.test3;

import java.util.ArrayList;
import java.util.List;

/** 
* @author  Linshiq: 
* @date 创建时间：2017年2月4日 下午5:20:57 
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
 *         <li>2017年2月4日-下午5:20:57</li>
 *         <li>修改记录</li>
 *         <li>-----------------------------------------------------------</li>
 *         <li>标记：修订内容</li>
 *         <li>linshiqin：创建注释模板</li>
 *         <li>-----------------------------------------------------------</li>
 *         </p>
 */
public class Test2 {

	public static void a(long i) {

		System.out.println("end:" + i);
	}

	public static boolean checkPowerOf2(int n) {

		if (n < 0)
			return false;

		String s = Integer.toBinaryString(n);

		for (int i = s.length() - 1; i > 0; i--) {

			if (s.charAt(i) != '0')
				return false;
		}

		return s.charAt(0) == '1' ? true : false;
	}	
	
	public static void main(String[] args) {

		
		long i = 0;
		

	}
}
