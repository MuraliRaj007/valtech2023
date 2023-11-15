package com.valtech.training.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.hibernate.Employee;
import com.valtech.training.spring.dao.EmployeeDAO;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO;

	@Override
	public Employee createEmployee(Employee employee) {
		employeeDAO.saveEmployee(employee);
		return employee;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Employee makeActive(Employee employee) {
		employee.setActive(true);
		employeeDAO.updateEmployee(employee);
		return employee;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Employee makeInactive(Employee employee) {
		employee.setActive(false);
		employeeDAO.updateEmployee(employee);
		return employee;
	}

	@Override
	public Employee incrementSalary(Employee employee, float increment) {
		employee.setSalary(employee.getSalary()+increment);
		employeeDAO.updateEmployee(employee);
		return employee;
	}

	@Override
	public void incrementSalaryForAll(float increment) {
		employeeDAO.getAllEmployees().forEach(employee -> employee.setSalary(employee.getSalary()+increment));
	}

	public void setEmployeeDAO(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

}
