package com.valtech.training.spring.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class AllInOneAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation methodInvocation) throws Throwable {
		System.out.println("All in one " + methodInvocation.getMethod().getName());
		Object[] args = methodInvocation.getArguments();
		for (int i = 0; i < args.length; i++) {
			int j = (int) args[i];
			args[i] = j < 0 ? -j : j;
		}
		Integer ret = (Integer) methodInvocation.proceed();
		return ret < 0 ? -ret : ret;
	}

}
