package com.lsq.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** 
* @author  Linshiq: 
* @date 创建时间：2017年1月9日 下午2:04:39 
* @version 1.0 
* @parameter  
* @since  
* @return  
*/
/**
 * <p>
 * 文件功能说明：
 *    给出一个字符串数组S，找到其中所有的乱序字符串(Anagram)。如果一个字符串是乱序字符串，那么他存在一个字母集合相同，但顺序不同的字符串也在S中。

	样例
		对于字符串数组 ["lint","intl","inlt","code"]
		
		返回 ["lint","inlt","intl"]
 * </p>
 * 
 * @Author linshiqin
 *         <p>
 *         <li>2017年1月9日-下午2:04:39</li>
 *         <li>修改记录</li>
 *         <li>-----------------------------------------------------------</li>
 *         <li>标记：修订内容</li>
 *         <li>linshiqin：创建注释模板</li>
 *         <li>-----------------------------------------------------------</li>
 *         </p>
 */
public class OutOfOrderString {
	
	private static List<String> listStr = new ArrayList<>();
	private static List<String> listStrs = new ArrayList<>();
	/**
     * @param strs: A list of strings
     * @return: A list of strings
     */
    public static List<String> anagrams(String[] strs) {
        // write your code here
    	  	
    	listStrs = Arrays.asList(strs);
    	listStrs = new ArrayList<String>(listStrs);  
    	
    	for(int i=0;i<listStrs.size() - 1 ;i++){
    		  		
    		char[] c1 = listStrs.get(i).toCharArray();
    		Arrays.sort(c1);

    		
    		System.out.println("one for before "+i);
    		if(compare(c1,i+1)){
    			System.out.println("one for after "+i);
    			listStr.add(listStrs.get(i));
    			listStrs.remove(i);
    			i--;
    		}
    	}
    	
    	return listStr;
    }
    
    private static boolean compare(char[] c1,int index){
    	
    	boolean flag = false;
    	System.out.println("index "+index);
    	String str1 = "";
    	String str2 = "";
    	for(int i = index;i<listStrs.size();i++){
    		
    		char[] c2 = listStrs.get(i).toCharArray();
    		
    		if(c1.length != c2.length){
    			continue;
    		}else{
    			Arrays.sort(c2);
    			str1 = String.valueOf(c1);
    			str2 = String.valueOf(c2);
    			
    			if(str1.equals(str2)){
    				listStr.add(listStrs.get(i));
        			listStrs.remove(i);
        			flag = true;
        			i--;
    			}
    		}
    		System.out.println(listStrs.get(i));

    	}
    	
    	return flag;
    }
    

    
    public static void main(String[] args) {
    	String[] strs = new String[]{"",""}; 
    	for(String s:OutOfOrderString.anagrams(strs)){
    		System.out.println("s:"+s);
    	}
    	

	}
}
