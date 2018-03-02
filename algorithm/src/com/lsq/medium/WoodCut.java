package com.lsq.medium;

import java.util.Arrays;

/** 
* @author  Linshiq: 
* @date 创建时间：2017年1月18日 上午10:02:34 
* @version 1.0 
* @parameter  
* @since  
* @return  
*/
/**
 * <p>
 * 文件功能说明：
 *    有一些原木，现在想把这些木头切割成一些长度相同的小段木头，需要得到的小段的数目至少为 k。当然，我们希望得到的小段越长越好，你需要计算能够得到的小段木头的最大长度。
 *    
 *    注意事项
 *    	木头长度的单位是厘米。原木的长度都是正整数，我们要求切割得到的小段木头的长度也要求是整数。无法切出要求至少 k 段的,则返回 0 即可。
 *    
 *    样例
 *    	有3根木头[232, 124, 456], k=7, 最大长度为114.			
 * </p>
 * 
 * @Author linshiqin
 *         <p>
 *         <li>2017年1月18日-上午10:02:34</li>
 *         <li>修改记录</li>
 *         <li>-----------------------------------------------------------</li>
 *         <li>标记：修订内容</li>
 *         <li>linshiqin：创建注释模板</li>
 *         <li>-----------------------------------------------------------</li>
 *         </p>
 */
public class WoodCut {
	
	/** 
     *@param L: Given n pieces of wood with length L[i]
     *@param k: An integer
     *return: The maximum length of the small pieces.
     */
    public static int woodCut(int[] L, int k) {
        // write your code here
    	
    	if(L.length == 0)
    		return 0;
    	
    	int maximum = 0;
    	int oneLen = 0;
    	int maxLen = 0;
    	int allLen = L.length;
    	
    	Arrays.sort(L);
    	
    	if(k >= L.length){
    		
    			if(L[L.length-1]/2 < L[0]){
    				
    				for (int i = L[0]; i > 0; i--) {
        				
        	    		oneLen = L[0]/i;
        	    		
//        	    		if(i == L[0] && j!=0)
//        	    			break;
        	    		
        	    		if(oneLen < 1)
        	    			oneLen = 1;
        	    		
        	    		maximum = getCutNumT(i, L,0) + oneLen;
        	    		
        	    		System.out.println("maximum:"+maximum+" i:"+i);
        	    		
        	    		if(maximum>=k){
        	    			
        	    			return i;
        	    		}
        			}
    			}else{
    				
//    				for (int i = L.length-1; i >= 0; i--) {
//
//        				for (int j = L[i]; j > 0; j--) {
//            				
//            	    		oneLen = L[i]/j;
//            	    		
//            	    		if(oneLen < 1)
//            	    			oneLen = 1;
//            	    		
//            	    		maximum = getCutNumT(j, L,i) + oneLen;
//            	    		
//            	    		System.out.println("maximum:"+maximum+" i:"+i);
//            	    		
//            	    		if(maximum>=k && maxLen < j){
//            	    			
//            	    			maxLen = j;
//            	    			
//            	    			
//            	    		}else if(maximum == k){
//            	    			return maxLen;
//            	    		}
//            			}
//					}
    				
    				
    			}
	    	   	
    	}else{
    		boolean flag = false;
    		    		
    		while(true){
    			
    			for(int i = L[allLen - k];i>0;i++){
    				
    				oneLen = L[allLen - k]/i;
    	    		
    	    		if(oneLen < 1)
    	    			oneLen = 1;
    	    		
    	    		maximum = getCutNum(i, L,allLen - k+1) + oneLen;
    	    		
    	    		System.out.println("maximum:"+maximum+" i:"+i);
    	    		
    	    		if(maximum>=k && maxLen < i){
    	    			
    	    			maxLen = i;
    	    			
    	    			flag = true;
    	    			
    	    			break;
    	    		}else if(maximum < k && maxLen !=0){
    	    			
    	    			return maxLen;
    	    		}
    			}
    			
    			if(flag){
    				
    				k--;
    				
    				if(k == -1)
    				    break;
    				
    			}else{
    				k++;
    				
    				if(k == allLen)
    				    break;
    			}
    		}
    	}
    	return maxLen;
    }
    
    private static int getCutNum(int cutLen,int[] L,int index){
    	
    	int num = 0;
    	
    	for(int i=index;i<L.length;i++){
    		
    		num = num + L[i]/cutLen;
    	}
    	
    	return num;
    }
    
    private static int getCutNumT(int cutLen,int[] L,int index){
    	
    	int num = 0;
    	
    	for(int i=0;i<L.length;i++){
    		if(i==index)
    			continue;
    		num = num + L[i]/cutLen;
    	}
    	
    	return num;
    }
    public static void main(String[] args) {
		
    	int[] L = new int[]{232,124,456};
    	
    	System.out.println("end:"+woodCut(L, 7));
    	
    	System.out.println(456/116);
	}
}
