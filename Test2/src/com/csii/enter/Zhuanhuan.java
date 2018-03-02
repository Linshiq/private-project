package com.csii.enter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Zhuanhuan {
	
	private static BigDecimal big = BigDecimal.ZERO;

	public static BigDecimal getBig() {
		return big;
	}

	public static void setBig(BigDecimal big) {
		Zhuanhuan.big = big;
	}

	public static enum  E_SHIFOUBZ{
		/**
		  * 1 - 是
		  *
		  */
		YES("YES","1","是"),
		 /**
		  * 0 - 否
		  *
		  */
		UU("NO","0","否");
		private E_SHIFOUBZ(String __id__ ,String __value__,String __longName__){
			this.__id__ = __id__;
			this.__value__ = __value__;
			this.__longName__ = __longName__;
		}
		private String __id__;
		
		private String __value__;
		
		private String __longName__;
		
		public String getId(){
			return this.__id__;
		}
		
		public String getValue(){
			return this.__value__;
		}
		
		public String getLongName(){
			return this.__longName__;
		}
	}
	
	public static void main(String[] args) {
		
		for(int i=0;i<10;i++){
			
			Zhuanhuan.setBig(Zhuanhuan.getBig().add(BigDecimal.ONE));
		}
		
		System.out.println(Zhuanhuan.getBig());
	}
}
