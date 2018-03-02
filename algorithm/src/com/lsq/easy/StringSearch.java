package com.lsq.easy;


/** 
* @author  Linshiq: 
* @date 创建时间：2017年1月9日 上午11:47:50 
* @version 1.0 
* @parameter  
* @since  
* @return  
*/
/**
 * <p>
 * 文件功能说明：
 *      对于一个给定的 source 字符串和一个 target 字符串，你应该在 source 字符串中找出 target 字符串出现的第一个位置(从0开始)。如果不存在，则返回 -1。	
 *      样例
			如果 source = "source" 和 target = "target"，返回 -1。
			
			如果 source = "abcdabcdefg" 和 target = "bcd"，返回 1。 
		返回值为下标值
 * </p>
 * 
 * @Author linshiqin
 *         <p>
 *         <li>2017年1月9日-上午11:47:50</li>
 *         <li>修改记录</li>
 *         <li>-----------------------------------------------------------</li>
 *         <li>标记：修订内容</li>
 *         <li>linshiqin：创建注释模板</li>
 *         <li>-----------------------------------------------------------</li>
 *         </p>
 */
public class StringSearch {
	/**
     * Returns a index to the first occurrence of target in source,
     * or -1  if target is not part of source.
     * @param source string to be scanned.
     * @param target string containing the sequence of characters to match.
     */
    public static int strStr(String source, String target) {
        //write your code here
    	
    	if(null == source || null == target)
    		return -1;
    	if(source.length()<target.length()){
    		return -1;
    	}else if(source.length() == 0 && target.length() == 0){
    		return 0;
    	}
    	
    	int targetLen = target.length();
    	//System.out.println("targetLen："+targetLen);
    	for(int i = 0; i<source.length();i++){
    	//	System.out.println(i+" s:"+source.substring(i, targetLen));
    		if(i+targetLen > source.length()){
    			System.out.println();
    			return -1;
    		}else if(source.substring(i, i+targetLen).equals(target)){
    			return i;
    		}
    	}
    	
        return -1;
    }
    
    public static void main(String[] args) {
    		//long starTime=System.currentTimeMillis();
    		System.out.println(System.currentTimeMillis());
    		System.out.println(StringSearch.strStr("tartarget", "target"));
		 // long endTime=System.currentTimeMillis();
		  System.out.println(System.currentTimeMillis());
		 // long Time=endTime-starTime;
		  //System.out.println("time :"+Time);
//		  StringBuilder bulider=new StringBuilder("");
//		  starTime=System.currentTimeMillis();
//		  for(int j=0;j<10000;j++){
//		   bulider.append(j);
//		  }
//		  endTime=System.currentTimeMillis();
//		  Time=endTime-starTime;
//		  System.out.println(Time);
		
	}
}
