package com.valtech.training.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.valtech.training.hibernate.Employee;

@Repository // All dao classes will be defined using @repository
// @service is used for all service classes, they need transaction support
// @controller for all presentation logic classes
// @component for all general classes and register with bean factory

public class EmployeeDAOImpl implements EmployeeDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void deleteEmployee(Employee employee) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(employee);

	}

	@Override
	public Employee saveEmployee(Employee employee) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(employee);
		return employee;
	}

	@Override
	public Employee loadEmployee(int employeeId) {
		Session session = sessionFactory.getCurrentSession();
		Employee employee = (Employee) session.load(Employee.class, employeeId);
		return employee;
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		Session session = sessionFactory.getCurrentSession();
		Employee employee1 = (Employee) session.merge(employee);
		return employee1;

	}

	@Override
	public List<Employee> getAllEmployees() {
		Session session = sessionFactory.getCurrentSession();
		List<Employee> employees = session.createQuery("from Employee e").list();
		return employees;
	}

}
