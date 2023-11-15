package com.valtech.training.spring.dao;

import java.util.List;

import com.valtech.training.hibernate.Employee;

public interface EmployeeDAO {

	void deleteEmployee(Employee employee);

	Employee saveEmployee(Employee employee);

	Employee loadEmployee(int employeeId);

	Employee updateEmployee(Employee employee);

	List<Employee> getAllEmployees();

}