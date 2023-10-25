package com.valtech.training.day2;

public class SimpleInterestImpl  implements SimpleInterest{
	
	private Arithmetic arithmetic;

	public SimpleInterestImpl(Arithmetic arithmetic2) {
	this.arithmetic=arithmetic2;
	}

	@Override
	public double si(int p, int r, int t) {
		
		int result=arithmetic.mul(p,r);
		result=arithmetic.mul(result, t);
		return arithmetic.div(result, 100);
		
	}

	public void setArithmetic(Arithmetic arithmetic) {
		this.arithmetic = arithmetic;
	}

	public static void main(String[] args) {
		Arithmetic arithmetic= new ArithmeticImpl();
		SimpleInterest s=new SimpleInterestImpl(arithmetic);
		System.out.println(s.si(200,3,4));

	}

	

}
