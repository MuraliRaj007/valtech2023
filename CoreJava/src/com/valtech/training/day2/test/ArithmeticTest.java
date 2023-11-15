package com.valtech.training.day2.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.valtech.training.day2.Arithmetic;
import com.valtech.training.day2.ArithmeticImpl;
import com.valtech.training.day2.DivByZeroEx;

class ArithmeticTest {
	
	private Arithmetic arithmetic;
	
	@BeforeAll
	static void beforeAll() {

		System.out.println("First Test");
	}
	
	@AfterAll
	static void afterAll() {

		System.out.println("Destroy");
	}
	
	@BeforeEach
	void beforeEach() {

		arithmetic=new ArithmeticImpl();
		System.out.println("Test started");
	}
	
	@AfterEach
	void afterEach() {

		System.out.println("Test ended");
	}

	@Test
	void testAdd() {
		assertEquals(5,arithmetic.add(2, 3));
		assertEquals(5, arithmetic.add(3, 2));
		assertEquals(5, arithmetic.add(5, 0));
		assertEquals(5, arithmetic.add(5, -0));
		assertEquals(-5, arithmetic.add(-2, -3));
		assertEquals(-5, arithmetic.add(-8, 3));
	}

	@Test
	void testSub() {
	}

	@Test
	void testMul() {
	}
	
	static Stream<Arguments> addArgsGenerator(){
		return Stream.of(Arguments.of(1,2,3),Arguments.of(2,3,5),Arguments.of(-1,-1,-2),Arguments.of(-2,5,3));
		
	}
	
	
	@ParameterizedTest(name="Add With Method {0}+{1}={2}")
	@MethodSource(value= {"addArgsGenerator"})
	void testWithMethod(int a, int b,int c) {
		assertEquals(c, arithmetic.add(a, b));
		
	}
	
	@ParameterizedTest(name="Add With CSV File {0}+{1}={2}")
	@CsvFileSource(files= {"add.csv"})
	void testWithCSVFile(int a, int b,int c) {
		assertEquals(c, arithmetic.add(a, b));
		
	}
	
	@ParameterizedTest(name="Add With CSV {0}+{1}={2}")
	@CsvSource(value= {"2,3,5","3,-2,1","-1,-1,-2","5,-2,3"})
	void testWithCSVParams(int a, int b,int c) {
		assertEquals(c, arithmetic.add(a, b));
		
	}
	
	@ParameterizedTest(name = "Add with {0}")
	@ValueSource(strings = {"2,3,5","3,-2,1","-1,-1,-2","5,-2,3"})
	void testAddWithParams(String value) {
		String[] parts=value.split(",");
		List<Integer> values=Arrays.asList(parts).stream().map(i -> Integer.parseInt(i)).collect(Collectors.toList());
		assertEquals(values.get(2), arithmetic.add(values.get(0), values.get(1)));
		
	}
	
	@Test
	void testDivByZero() {
		assertThrows(DivByZeroEx.class, ()->arithmetic.div(5, 0));
	}

	@Test
	void testDiv() {
		assertEquals(5, arithmetic.div(10,2));
		assertEquals(5, arithmetic.div(-10,-2));
		assertEquals(-5, arithmetic.div(-10,2));
		try {
			assertEquals(2, arithmetic.div(4, 0));
			fail("should throw an exception");
		} catch (DivByZeroEx e) {
			// TODO: handle exception
		}
	}

}
