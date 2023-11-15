package com.valtech.training.firstspringboot.components;

import java.util.List;

public interface EmployeeDAO {

	void deleteEmployee(int id) ;

	void updateEmployee(Employee emp);

	void createEmployee(Employee emp);

	List<Employee> getAllEmployees();

//	Employee getEmployee(int id);
//	
//	List<Employee> getEmployeesSalaryGT(int salary);
//	
//	List<Employee> getEmployeesSalaryLT(int salary);
//	
//	List<Employee> getEmployeesByAgeBTW(int min, int max);
	
	public long count()  ;

}