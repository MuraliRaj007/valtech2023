package com.valtech.training.spring.test;

import static org.junit.jupiter.api.Assertions.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.valtech.training.hibernate.Employee;
import com.valtech.training.spring.service.EmployeeService;

class EmployeeServiceTest {
	
	private ClassPathXmlApplicationContext applicationContext;
	private DateFormat dateFormat;
	@BeforeEach
	void setUp() {
		applicationContext=new ClassPathXmlApplicationContext("tx.xml");
		dateFormat=new SimpleDateFormat("dd-mm-yyyy");
	}
	
	@AfterEach
	void tearDown() {
		applicationContext.close();
	}

	@Test
	void test() throws Exception  {

		Employee employee=new Employee("Murali", dateFormat.parse("25-01-2002"), 1000000, 'M', true);
		EmployeeService employeeService=(EmployeeService) applicationContext.getBean("employeeService");
		employee=employeeService.createEmployee(employee);
		System.out.println(employee);
		employee=employeeService.incrementSalary(employee, 1000000);
		System.out.println(employee);
	}

}
