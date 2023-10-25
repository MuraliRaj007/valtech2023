package com.valtech.training.day1;

public class Example {
	
	public Example(int x,double y) {
		System.out.println(x+y);
		
	}
	public Example(double x,int y) {
		System.out.println(x+y);
		
	}

	public static void main(String[] args) {
		new Example(5,6.0);
		new Example(5.0,6);
		

	}

}
