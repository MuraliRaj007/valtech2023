package com.valtech.training.spring.aop;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.ArrayUtils;
import org.springframework.aop.MethodBeforeAdvice;

public class CounterAdvice implements MethodBeforeAdvice {

	private Map<String, Integer> counters = new HashMap<String, Integer>();

	public void loadCounters() {

		File file = new File("counters.txt");
		if (file.exists()) {
			try {
				ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file));
				counters = (Map<String, Integer>) inputStream.readObject();
			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Loading Counters" + counters);
	}

	public void saveCounters() {
		System.out.println("Saving Counters" + counters);
		try {
			ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(new File("counters.txt")));
			outputStream.writeObject(counters);
			outputStream.flush();
			outputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * method is the method to be invoked args are parameters passed to method
	 * target is the object on which method is called
	 */

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {

		for (int i = 0; i < args.length; i++) {
			int a = (int) args[i];
			args[i] = a % 2 == 0 ? a : -a;
		}
		String methodName = method.getName();
		System.out.println("Method being invoked is " + methodName);
		System.out.println("Arguments are " + ArrayUtils.toString(args));
		if (counters.containsKey(methodName)) {
			counters.put(methodName, counters.get(methodName) + 1);
		} else {
			counters.put(methodName, 1);
		}
		System.out.println(counters);
	}

}
