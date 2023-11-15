package com.valtech.training.spring.test;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.valtech.training.spring.Arithmetic;

class AOPTest {

	private ClassPathXmlApplicationContext applicationContext;

	@BeforeEach
	void initialize() {
		applicationContext = new ClassPathXmlApplicationContext("aop.xml");
	}

	@AfterEach
	void closeAll() {
		applicationContext.close();
	}

	@Test
	void test() {
		Arithmetic arithmetic = applicationContext.getBean(Arithmetic.class);
		System.out.println(arithmetic.getClass().getName());
		assertEquals(5, arithmetic.add(2, 3));
		assertEquals(5, arithmetic.add(3, -2));
		assertEquals(1, arithmetic.sub(2, 3));
		assertEquals(10, arithmetic.mul(5, 2));
		try {
			arithmetic.div(5, 0);
			fail("No Exception");
		} catch (Exception e) {
		}
	}

}
