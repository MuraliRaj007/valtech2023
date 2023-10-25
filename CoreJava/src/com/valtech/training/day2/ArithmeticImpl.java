package com.valtech.training.day2;

public class ArithmeticImpl implements Arithmetic{
	
	@Override
	public int add(int a, int b) {
		return a+b;
	}

	@Override
	public int sub(int a, int b) {
		return a-b;
	}

	@Override
	public int mul(int a, int b) {
		return a*b;
	}

	@Override
	public int div(int a, int b)throws DivByZeroEx {
		if(b==0) {
			throw new DivByZeroEx("zero cannot be used as denominator");
		}
		return a/b;
	}
	
	public static void main(String[] args)throws DivByZeroEx {
		Arithmetic a=new ArithmeticImpl();
		System.out.println(a.add(3, 4));
		System.out.println(a.sub(7, 4));
		System.out.println(a.mul(3, 4));
		try {
		System.out.println(a.div(12, 0));
	}catch(DivByZeroEx e) {
		System.out.println(e.getMessage());
	}
		System.out.println(a.div(1, 0));
	}

}
