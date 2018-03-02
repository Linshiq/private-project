package com.tool;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommUtil {
	
	/**
	 * @Author linshiqin
	 *         <p>
	 *         <li>2016年8月30日-下午4:30:59</li>
	 *         <li>功能说明：判断输入的是否为数字</li>
	 *         </p>
	 * @param str
	 * @return
	 */
	public static boolean isNumeric(String str){ 
		   Pattern pattern = Pattern.compile("[0-9]*"); 
		   Matcher isNum = pattern.matcher(str);
		   if( !isNum.matches() ){
		       return false; 
		   } 
		   return true; 
	}
	public static void main(String[] args) {
		System.out.println(CommUtil.isNumeric("s"));
	}
}
