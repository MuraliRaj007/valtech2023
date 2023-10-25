package com.valtech.training.day2;

public interface Arithmetic {
	
	int ZERO=0;
	
	int add(int a,int b);
	
	int sub(int a,int b);
	
	int mul(int a,int b);
	
	int div(int a,int b)throws DivByZeroEx;

}
