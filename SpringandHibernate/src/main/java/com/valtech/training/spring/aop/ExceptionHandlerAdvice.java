package com.valtech.training.spring.aop;

import org.springframework.aop.ThrowsAdvice;

public class ExceptionHandlerAdvice implements ThrowsAdvice {
	
	public void afterThrowing(Exception e) {
		System.out.println("Exception is "+e.getLocalizedMessage());
	}
	

}
