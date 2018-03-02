package com.csii.test;
/** 
* @author  LinShiqin: 
* @date 创建时间：2016年4月21日 上午9:46:55 
* @return  
*/
public class productCustno {

	public static void main(String[] args) {
		
		String string = "32312310";
		
		System.out.println(string+"-"+get(string));
		
	}
	
	public static String get(String str) {
		
		
		long a = Long.parseLong(String.valueOf(str.charAt(0)));
		long b = Long.parseLong(String.valueOf(str.charAt(1)));
		long c = Long.parseLong(String.valueOf(str.charAt(2)));
		long d = Long.parseLong(String.valueOf(str.charAt(3)));
		long e = Long.parseLong(String.valueOf(str.charAt(4)));
		long f = Long.parseLong(String.valueOf(str.charAt(5)));
		long g = Long.parseLong(String.valueOf(str.charAt(6)));
		long h = Long.parseLong(String.valueOf(str.charAt(7)));

		
		long recor = 11 - (3 * a + 7 * b + 9 * c + 10 * d + 5 * e + 8 * f + 4 * g + 2 * h) % 11;
		
		return recor+"";
	}
}
