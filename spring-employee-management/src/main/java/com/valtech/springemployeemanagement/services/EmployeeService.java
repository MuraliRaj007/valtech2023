package com.valtech.springemployeemanagement.services;

import java.util.List;

import com.valtech.springemployeemanagement.entities.Department;
import com.valtech.springemployeemanagement.entities.Employee;

public interface EmployeeService {

	Employee createEmployee(Employee employee);

	Employee updateEmployee(Employee employee);

	void deleteEmployee(int id);

	Employee getEmployeeById(int id);

	List<Employee> getAllEmployees();

	Department createDepartment(Department department);

	Department updateDepartment(Department department);

	void deleteDepartment(int id);

	Department getDepartmentById(int id);

	List<Department> getAllDepartments();

	int getFirstId();

	int getLastId();

	int getPreviousId(int id);

	int getNextId(int id);

	List<Employee> getAllEmployeesByDepartment(int id);

}