package com.valtech.training.spring.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.valtech.training.spring.HelloWorld;
import com.valtech.training.spring.Line;
import com.valtech.training.spring.SimpleInterest;
import com.valtech.training.spring.UtilsBean;

class IocTest {

	private ApplicationContext applicationContext;
	private ApplicationContext childApplicationContext;

	@BeforeEach
	void initialize() {
		applicationContext = new ClassPathXmlApplicationContext("ioc.xml");
		childApplicationContext = new ClassPathXmlApplicationContext(new String[] { "ioc-child.xml" },
				applicationContext);
	}
	
	@Test
	void testChildApplicationContext() {
		Line line=(Line) childApplicationContext.getBean("line");
		System.out.println(line);
	}

	@Test
	void testUtils() {
		UtilsBean utilsBean = applicationContext.getBean(UtilsBean.class);
		System.out.println(utilsBean.getNames());
		System.out.println(utilsBean.getSettings());
		System.out.println(utilsBean.getLinePoints());
	}

	@Test
	void testSimpleInterest() {
		SimpleInterest simpleInterest = applicationContext.getBean(SimpleInterest.class);
		System.out.println(simpleInterest.si(3000, 12, 3));
	}

	@Test
	void testLine() {
		System.out.println(applicationContext.getBean("l1"));
	}

	@Test
	void testLineWithoutValues() {
		System.out.println(applicationContext.getBean("l2"));
	}

	@Test
	void testPointSetter() {
		System.out.println(applicationContext.getBean("p2"));
	}

	@Test
	void test() {
		HelloWorld helloWorld = (HelloWorld) applicationContext.getBean("hw");
		assertEquals("Hello World", helloWorld.hello("World"));
		assertEquals(applicationContext.getBean("hw"), applicationContext.getBean("abc"));
	}

	@Test
	void testPoint() {
		System.out.println(applicationContext.getBean("p1"));
	}

}
