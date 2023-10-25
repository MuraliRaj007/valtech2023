package com.valtech.training.jdk;

public class AdderImpl implements Adder {

	@Override
	public int add(int a, int b) {
		
		return a+b;
	}
	
	public static void main(String[] args) {
		Adder a=new AdderImpl();
		System.out.println(a.add(2,3));
		Adder a1=new Adder() {
			
			@Override
			public int add(int a, int b) {
				// TODO Auto-generated method stub
				return a+b;
			}
		};
		System.out.println(a1.add(2, 3));
		
		
//		Lambda Expression
		Adder a2=(i,j)->{return i+j;};
		System.out.println(a2.add(2, 3));
	}

}
