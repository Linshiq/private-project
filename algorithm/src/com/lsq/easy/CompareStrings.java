package com.lsq.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/** 
* @author  Linshiq: 
* @date 创建时间：2017年1月7日 下午1:35:36 
* @version 1.0 
* @parameter  
* @since  
* @return  
*/
/**
 * <p>
 * 文件功能说明：
 *     比较两个字符串A和B，确定A中是否包含B中所有的字符。字符串A和B中的字符都是 大写字母
 *     样例
给出 A = "ABCD" B = "ACD"，返回 true

给出 A = "ABCD" B = "AABC"， 返回 false  			
 * </p>
 * 
 * @Author linshiqin
 *         <p>
 *         <li>2017年1月7日-下午1:35:36</li>
 *         <li>修改记录</li>
 *         <li>-----------------------------------------------------------</li>
 *         <li>标记：修订内容</li>
 *         <li>linshiqin：创建注释模板</li>
 *         <li>-----------------------------------------------------------</li>
 *         </p>
 */
public class CompareStrings {
	/**
     * @param A : A string includes Upper Case letters
     * @param B : A string includes Upper Case letter
     * @return :  if string A contains all of the characters in B return true else return false
     */
    public static boolean compareStrings(String A, String B) {
        // write your code here
    	boolean flag = false;
    	
    	if(A.length() == 0 && B.length() > 0){
    		return flag;
    	}
    	
    	char[] cA = A.toCharArray();
    	char[] cB = B.toCharArray();
    	
    	Map<Character, Integer> aMap = new HashMap<>();
		Map<Character, Integer> bMap = new HashMap<>();
    	
		Set<Character> bSet = new HashSet<>();
		
    	int index = 0;
    	
    	for(char c:cA){
    		if(c < 65 || c>90)
    			return flag;
    		else
    			for(char c1:cA){			
    				if(c1 == c){
    					index++;
    					aMap.put(c, index);
    				}
    			}
    		index = 0;
    	}
    	
    	
    	for(char c:cB){
    		if(c < 65 || c>90)
    			return flag;
    		else{
    			
    			bSet.add(c);
    			for(char c1:cB){
    				if(c1 == c){
    					index++;
    					bMap.put(c, index);
    				}
    			} 
    		}
    		index = 0;
    	}
    	
    	for(char c:bSet){
    		System.out.println(c + " aMap = " + aMap.get(c) +" bMap = " + bMap.get(c));
    		if(bMap.get(c) <= aMap.get(c)){
    			index ++ ;
    			System.out.println(index);
    			continue;
    		}
    		if(!flag){
    			return flag;
    		}
    	}
    	
    	if(bSet.size() == 0 || index == bSet.size())
    		flag = true;
    	
    	return flag;
    }
    
    public static void main(String[] args) {
		System.out.println(CompareStrings.compareStrings("", "A"));
	}
}