package com.lsq.medium;

/** 
* @author  Linshiq: 
* @date 创建时间：2017年2月14日 下午4:11:04 
* @version 1.0 
* @parameter  
* @since  
* @return  
*/
/**
 * <p>
 * 文件功能说明：
 *       假设有一个排序的按未知的旋转轴旋转的数组(比如，0 1 2 4 5 6 7 可能成为4 5 6 7 0 1 2)。
 *       给定一个目标值进行搜索，如果在数组中找到目标值返回数组中的索引位置，否则返回-1。			
 *       
 *       你可以假设数组中不存在重复的元素。
 *       
 *       样例
 *       
 *       给出[4, 5, 1, 2, 3]和target=1，返回 2
 *       
 *       给出[4, 5, 1, 2, 3]和target=0，返回 -1
 * </p>
 * 
 * @Author linshiqin
 *         <p>
 *         <li>2017年2月14日-下午4:11:04</li>
 *         <li>修改记录</li>
 *         <li>-----------------------------------------------------------</li>
 *         <li>标记：修订内容</li>
 *         <li>linshiqin：创建注释模板</li>
 *         <li>-----------------------------------------------------------</li>
 *         </p>
 */
public class SearchSortArray {
	/** 
     *@param A : an integer rotated sorted array
     *@param target :  an integer to be searched
     *return : an integer
     */
    public int search(int[] A, int target) {
        // write your code here
    	
    	int min = -1;

		int len = A.length;

		if (len == 0) {
			return min;
		} else if (len == 1) {
			
			if(target == A[0])
				return 0;
			else
				return min;
		}

		int frist = A[0];
		int end = A[len - 1];

		if (end < frist) {// 首个比末位大说明已经旋转过了
			
			if(target <= end){ // 需定位的数字比末位小,说明处于后列
				
				for (int i = len - 1; i > 0; i--) {
					
					if(target == A[i] ){
						return i;
					}
					
					if(A[i-1]>A[i]){
						return min;
					}
				}
			}else{
				
				for (int i = 0; i < len; i++) {
					
					if(target == A[i] ){
						return i;
					}
					
					if(A[i+1]<A[i]){
						return min;
					}
				}
			}
				
		} else {

			for (int i = 0; i < len; i++) {
				if(target == A[i] ){
					return i;
				}
			}
		}

		return min;
    	
    }
    
    public static void main(String[] args) {
		
//    	int[] A = new int[]{2,3,1};
//    	
//    	int[] B = Arrays.copyOf(A, A.length);
//    	
//    	Arrays.sort(B);
//    	
//    	for (int i:A) {
//    		System.out.print(i);
//		}
//    	System.out.println();
//    	for(int i:B){
//    		System.out.print(i);
//    	}
//    	
//    	
//    	StringBuffer sb = new StringBuffer();
//    	
//    	sb.append("select xxx");
//    	sb.append("from xxx");
//    	sb.append("where xx");
//    	
//    	System.out.println("------------or------------------");
//    	
//    	sb.append("select xx from xxx where xxx");
    	
    	String str = "A";
		str = String.format("%3s",str);
		System.out.println("-"+str+"-");
		str = str.replaceAll("\\s", "Z");
		System.out.println("-"+str+"-");
	}
}
