package com.csii.test3;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/** 
* @author  Linshiq: 
* @date 创建时间：2017年1月12日 下午1:46:57 
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
 *         <li>2017年1月12日-下午1:46:57</li>
 *         <li>修改记录</li>
 *         <li>-----------------------------------------------------------</li>
 *         <li>标记：修订内容</li>
 *         <li>linshiqin：创建注释模板</li>
 *         <li>-----------------------------------------------------------</li>
 *         </p>
 */
public class Test {

	public static void main(String[] args) {
		
		StringBuffer sb1 = new StringBuffer("hello");
		StringBuffer sb2 = new StringBuffer("world");
		System.out.println(sb1+" ---- "+sb2);
		change(sb1,sb2);
		System.out.println(sb1+" ---- "+sb2);
		
	}

	/**
	 * @Author linshiqin
	 *         <p>
	 *         <li>2017年7月25日-下午1:34:50</li>
	 *         <li>功能说明：使用list的循环</li>
	 *         </p>
	 * @param sb1
	 * @param sb2
	 */
	private static void change(StringBuffer sb1, StringBuffer sb2) {
		
		sb1 = sb2;
		sb2.append(sb1);
		
	}

}
