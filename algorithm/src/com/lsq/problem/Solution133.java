package com.lsq.problem;

import java.util.ArrayList;
import java.util.List;

/** 
* @author  Linshiq: 
* @date 创建时间：2018年1月25日 下午4:08:09 
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
 *         <li>2018年1月25日-下午4:08:09</li>
 *         <li>修改记录</li>
 *         <li>-----------------------------------------------------------</li>
 *         <li>标记：修订内容</li>
 *         <li>linshiqin：创建注释模板</li>
 *         <li>-----------------------------------------------------------</li>
 *         </p>
 */
public class Solution133 {
	/*
	 * @param dictionary: an array of strings
	 * 
	 * @return: an arraylist of strings
	 */
	public List<String> longestWords(String[] dictionary) {
		// write your code here

		/*
		 * 样例 在词典
		 * 
		 * { "dog", "google", "facebook", "internationalization", "blabla" } 中,
		 * 最长的单词集合为 ["internationalization"]
		 * 
		 * 在词典
		 * 
		 * { "like", "love", "hate", "yes" } 中，最长的单词集合为 ["like", "love", "hate"]
		 */

		List<String> result = new ArrayList<>();

		if (dictionary.length <= 0) {

			return result;
		} 
		
		int len = dictionary[0].length();
		
		for (int i = 0; i < dictionary.length; i++) {
			
			if(len == dictionary[i].length()){// 等于最长长度,加进
				
				result.add(dictionary[i]);
			}else if(len < dictionary[i].length()){// 遍历到长度比原长度还长的,则替换掉,同时清除原记录
				
				result = new ArrayList<>(); 
				
				len = dictionary[i].length();
				
				result.add(dictionary[i]);
			}
		}
		
		return result;
	}
}
