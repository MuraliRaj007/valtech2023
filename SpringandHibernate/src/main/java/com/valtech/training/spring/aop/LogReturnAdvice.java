package com.valtech.training.spring.aop;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class LogReturnAdvice implements AfterReturningAdvice {

	@Override
	public void afterReturning(Object returnObject, Method method, Object[] args, Object tarObject) throws Throwable {

		System.out.println("Return Value "+returnObject);
	}

}
