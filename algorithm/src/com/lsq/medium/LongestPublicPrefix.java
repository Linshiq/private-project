package com.lsq.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** 
* @author  Linshiq: 
* @date 创建时间：2017年1月11日 下午1:57:15 
* @version 1.0 
* @parameter  
* @since  
* @return  
*/
/**
 * <p>
 * 文件功能说明： 给k个字符串，求出他们的最长公共前缀(LCP) 样例 在 "ABCD" "ABEF" 和 "ACEF" 中, LCP 为 "A" 在
 * "ABCDEFG", "ABCEFG", "ABCEFA" 中, LCP 为 "ABC"
 * </p>
 * 
 * @Author linshiqin
 *         <p>
 *         <li>2017年1月11日-下午1:57:15</li>
 *         <li>修改记录</li>
 *         <li>-----------------------------------------------------------</li>
 *         <li>标记：修订内容</li>
 *         <li>linshiqin：创建注释模板</li>
 *         <li>-----------------------------------------------------------</li>
 *         </p>
 */
public class LongestPublicPrefix {

	private static List<String> strList = new ArrayList<>();
	/**
	 * @param strs:
	 *            A list of strings
	 * @return: The longest common prefix
	 */
	public static String longestCommonPrefix(String[] strs) {
		// write your code here

		if (strs.length > 1) {
			
			Arrays.sort(strs);
			compare(strs[0], 1, strs);

		} else if (strs.length == 1){

			return strs[0];
		}
		
		String str = "";
		
		if(strList.size()>=1)
			str = strList.get(0);
		
		System.out.println("strList len:" +strList.size() );
		for(String i:strList){
			System.out.println(i);
			if(i.length() < str.length()){
				str = i;
			}
		}
		
		return str;
	}

	public static void compare(String str1, int next, String[] strs) {
		
		String str = "";
		
		if (next >= strs.length)
			return;
		
		if(str1.length() == 0){
			strList.add(str);
		}
		
		for (int i = 0; i < str1.length(); i++) {
			System.out.println(strs[next].length());
			if (str1.charAt(i) == strs[next].charAt(i)) {
				
				str = str + str1.charAt(i);
				
				if(str.length() == str1.length()){
					strList.add(str);
					compare(str, next+1, strs);
				}
			}else{
				strList.add(str);			
				System.out.println(str);
				compare(str, next+1, strs);
				return;
			}
		}
	}
	
	public static void main(String[] args) {
		
		String[] strs = new String[]{"aac","acab","aa","abba","aa"};
		
		System.out.println("end:"+longestCommonPrefix(strs));
	}
}
