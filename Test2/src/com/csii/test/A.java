package com.csii.test;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;

/** 
* @author  Linshiq: 
* @date 创建时间：2016年10月31日 上午10:41:24 
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
 *         <li>2016年10月31日-上午10:41:24</li>
 *         <li>修改记录</li>
 *         <li>-----------------------------------------------------------</li>
 *         <li>标记：修订内容</li>
 *         <li>linshiqin：创建注释模板</li>
 *         <li>-----------------------------------------------------------</li>
 *         </p>
 */
public class A {

	public static void 自身结汇(){
		for(int i=1;i<100;i++){
			 BigDecimal number = BigDecimal.valueOf(11111+i);
			 BigDecimal mairujia = BigDecimal.valueOf(87.4700000);
			 BigDecimal guodujia = number.divide(mairujia,10,BigDecimal.ROUND_HALF_DOWN).multiply(BigDecimal.valueOf(100));
	         System.out.println(guodujia+" 对应输入金额:"+(11111+i));
			}
	}
	
	public static void 代客结汇(){
		for(int i=1;i<100;i++){
			 double a = 811.4700000;
			 BigDecimal number = BigDecimal.valueOf(11111+i);
			 BigDecimal mairujia = BigDecimal.valueOf(a);
			 BigDecimal guodujia = number.divide(BigDecimal.valueOf(100),10,BigDecimal.ROUND_HALF_DOWN).multiply(mairujia);
	         System.out.println(guodujia+" 对应输入金额:"+(11111+i));
			}
	}
	
	public static void jdss(){
		
		BigDecimal x1 = BigDecimal.valueOf(0.1404);
		BigDecimal y2 = BigDecimal.valueOf(0.1076);
		BigDecimal z3 = BigDecimal.valueOf(0.1767);
		
		BigDecimal oSum = BigDecimal.valueOf(1086.83);
		
		BigDecimal sum = BigDecimal.ZERO;
		BigDecimal x = BigDecimal.valueOf(0);
		BigDecimal y = BigDecimal.valueOf(0);
		BigDecimal z = BigDecimal.valueOf(0);
		System.out.println("start");
		int i = 0;
		int j = 0 ;
		int k = 0;
		for(i = 0 ;i<2701;i++){
			System.out.println("i="+i);
			for(j = 0 ;j<2701;j++){
				//System.out.println("j="+j);
				for(k = 0 ;k<2701;k++){
					
					sum = sum.add(x1.multiply(x)).add(y2.multiply(y)).add(z3.multiply(z));
					if(sum.compareTo(oSum)==0){
						System.out.println("0.1404*"+x+"+0.1076*"+y+"+0.1767*"+z +"="+sum);
					}else
						sum = BigDecimal.ZERO;
					z = BigDecimal.valueOf(k);
				}
				y = BigDecimal.valueOf(j);
			}
			x = BigDecimal.valueOf(i);
		}
		System.out.println("end");
	}
	
	public static void main(String[] args) {
		
		try {
			
			BigDecimal.ONE.divide(BigDecimal.ZERO);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			System.out.println("hi"+e.toString());
		}
	}
}
