package com.lsq.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/** 
* @author  Linshiq: 
* @date 创建时间：2017年1月7日 上午11:43:36 
* @version 1.0 
* @parameter  
* @since  
* @return  
*/
/**
 * <p>
 * 文件功能说明： 两个字符串是变位词 写出一个函数 anagram(s, t) 判断两个字符串是否可以通过改变字母的顺序变成一样的字符串。 样例 给出 s
 * = "abcd"，t="dcab"，返回 true. 给出 s = "ab", t = "ab", 返回 true. 给出 s = "ab", t =
 * "ac", 返回 false.
 * </p>
 * 
 * @Author linshiqin
 *         <p>
 *         <li>2017年1月7日-上午11:43:36</li>
 *         <li>修改记录</li>
 *         <li>-----------------------------------------------------------</li>
 *         <li>标记：修订内容</li>
 *         <li>linshiqin：创建注释模板</li>
 *         <li>-----------------------------------------------------------</li>
 *         </p>
 */
public class StringDisplacement {

	/**
	 * @param s:
	 *            The first string
	 * @param b:
	 *            The second string
	 * @return true or false
	 */
	public static boolean anagram(String s, String t) {
		// write your code here
		boolean flag = false;

		char[] sC = s.toCharArray();
		char[] tC = t.toCharArray();
		if (s.length() != t.length()) {
			return flag;
		} else {

			Map<Character, Integer> sMap = new HashMap<>();
			Map<Character, Integer> tMap = new HashMap<>();

			int num = 0;
			for (char c : sC) {
				for (char cT : sC) {
					if (c == cT)
						sMap.put(c, num++);
				}
				num = 0;
			}
			for (char c : tC) {
				for (char cT : tC) {
					if (c == cT)
						tMap.put(c, num++);
				}
				num = 0;
			}
			
			Set<Character> sCS = new HashSet<>();
			Set<Character> tCS = new HashSet<>();
			for (char c : sC) {
				sCS.add(c);
			}
			for (char c : tC) {
				tCS.add(c);
			}

			if (sCS.size() != tCS.size()) {
				return flag;
			} else {
				int index = 0;
				int mapSize = 0;
				for (Character c : sCS) {
					
					for (Character cT : tCS) {

						if (c == cT) {
							System.out.println(index);
							index++;
							break;
						}
					}
					
					if(sMap.get(c) == tMap.get(c)){
						mapSize ++;
					}
				}
				System.out.println(index);
				if (index == sCS.size() && mapSize == sMap.size())
					flag = true;
			}
		}

		return flag;
	}

	public static void main(String[] args) {
		System.out.println(StringDisplacement.anagram("aacc", "ccac"));
	}
}
