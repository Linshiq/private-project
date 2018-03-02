package com.csii.test;

public class TestBasic {

	TestBasic(){
		System.out.println("TestBasic");
	}
	
	static{
		System.out.println("A");
	}
	
	public static void main(String[] args) {
		
		String s1="";
		String s2="1";
		s2="";
		
		int i = 1;
		
		i+=2;
		System.out.println(s1==s2);
		System.out.println(i);
		
		String s3 = new String("s");
		String s4 = new String("s");
		System.out.println(s3==s4);
	}
	
}
