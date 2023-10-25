package com.valtech.training.day3;


public class Rot13Helper {
	
	public static char rotate(char c) {
		if(c>='a' && c<='m' || c>='A' && c<='M') {
			c=(char)(c+13);
		}else if (c>='n' && c<='z' || c>='N' && c<='Z') {
			c=(char)(c-13);
		}
		return c;
		
	}

	public static void main(String[] args) {
		String S="Hello World";
		for(int i=0;i<S.length();i++) {
			System.out.print(rotate(S.charAt(i)));
		}
		}
		

}
