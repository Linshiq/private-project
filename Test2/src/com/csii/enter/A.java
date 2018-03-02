package com.csii.enter;

public class A {

	private String a;
	private String b;

	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}

	public String getB() {
		return b;
	}

	public void setB(String b) {
		this.b = b;
	}

	@Override
	public String toString() {
		return "A [a=" + a + ", b=" + b + "]";
	}

	public A() {
		super();
		// TODO Auto-generated constructor stub
	}

	private static String s = "10";

	public static void comp(String str1) {

		System.out.println(str1 == s);
	}
	
	public static int[] a(int[] nums,int target){
		
		int sum = 0;

		for (int i = 0; i < nums.length; i++) {

			if (nums[i] == target) {

				return new int[] { i, i };
			}

			sum = nums[i];
						
			for (int j = i + 1; j < nums.length; j++) {
				
				if ((sum = sum + nums[j]) == target) {

					return new int[] { i, j };
				}
			}
		}

		return new int[] {};
	}
	
	public static void main(String[] args) {
		
		for(int i:a(new int[]{3,2,4}, 6)){
			System.out.println(i);
		}
	}
}
