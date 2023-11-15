package com.valtech.training.spring.service;

import com.valtech.training.hibernate.Employee;

public interface EmployeeService {

	Employee createEmployee(Employee employee);

	Employee makeActive(Employee employee);

	Employee makeInactive(Employee employee);

	Employee incrementSalary(Employee employee, float increment);

	void incrementSalaryForAll(float increment);

}