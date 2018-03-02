package com.csii.test;

public class test {

	public static void main(String[] args) {
		
		char []string = new char[]{'h','e','l','l','o',' ','w','o','r','l','d'};
		

		 StringBuffer sb = new StringBuffer();
	        for(char c:string){
	        	System.out.println(c);
	            sb.append(c); 
	        }
	        System.out.println(sb.toString());
	        System.out.println(sb.toString().replaceAll(" ", "%20"));
	        System.out.println(sb.toString().replaceAll(" ", "%20").length());
	        
	        String str = "hello world";
	        char[] strC = str.toCharArray();
	        for(char c:strC){
	        	System.out.println(c);
	        }
	     // Write your code here
	        char []string1 = new char[]{'h','e','l','l','o',' ','w','o','r','l','d'};
	        String str1 = "";
	        for(int i=0;i<string1.length;i++){
	            if(string1[i]==' '){
	                str1 = str1 + "%20";
	            }else{
	                str1 = str1 + string1[i];
	            }
	        }
	        System.out.println("str1="+str1);
	        string1 = str1.toCharArray();
	        
	        System.out.println(string1.length);
	}

	public static int i = 1;

	/**
	 * 
	 * @param idcode
	 *            身份证号码前17位(请至少输入前 17 位)
	 * @return 正确校验的身份证号
	 */
	private static String getCheckCode(String idcode) {

		if (idcode.length() < 17) {
			System.out.println("少于17位");
		}
		// 加权因子
		int r[] = { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2 };
		// 校验码
		char checker[] = { '1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2' };
		int sumQT = 0;
		for (int i = 0; i <= 16; i++) {
			sumQT += (idcode.charAt(i) - 48) * r[i];
		}
		String verifiedId = idcode.substring(0, 17) + checker[(sumQT % 11)];

		return verifiedId;
	}

}
