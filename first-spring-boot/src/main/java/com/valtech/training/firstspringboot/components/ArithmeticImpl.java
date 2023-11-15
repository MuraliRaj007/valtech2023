package com.valtech.training.firstspringboot.components;

public class ArithmeticImpl implements Arithmetic {

	@Override
	public int add(int a, int b) {
		return a + b;
	}

	@Override
	public int sub(int a, int b) {
		return a - b;
	}

	@Override
	public int mul(int a, int b) {
		return a * b;
	}

	@Override
	public int div(int a, int b) {

		return a / b;
	}

	public static void main(String[] args)  {
		Arithmetic a = new ArithmeticImpl();
		System.out.println(a.add(3, 4));
		System.out.println(a.sub(7, 4));
		System.out.println(a.mul(3, 4));
		
		System.out.println(a.div(1, 0));
	}

}
