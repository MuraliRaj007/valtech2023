package com.valtech.springemployeemanagement.services;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.springemployeemanagement.entities.Department;
import com.valtech.springemployeemanagement.entities.Employee;
import com.valtech.springemployeemanagement.repositories.DepartmentRepository;
import com.valtech.springemployeemanagement.repositories.EmployeeRepository;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	DepartmentRepository departmentRepository;

	@PostConstruct
	public void populateEmployeesAndDepartments() {

		Department department = new Department("HR", "Bangalore");
		Department department1 = new Department("Manager", "Bangalore");
		Department department2 = new Department("Sales", "Bangalore");
		Department department3 = new Department("ForntEnd", "Bangalore");
		Department department4 = new Department("BackEnd", "Bangalore");

		Employee employee = new Employee("Murali", 20, 1, 1, 45000, department);
		Employee employee1 = new Employee("Akhil", 22, 1, 1, 45000, department1);
		Employee employee2 = new Employee("Dhanush", 21, 1, 1, 45000, department2);
		Employee employee3 = new Employee("Puneeth", 20, 1, 1, 45000, department3);
		Employee employee4 = new Employee("Kruthik", 22, 1, 1, 45000, department4);

		employeeRepository.save(employee);
		employeeRepository.save(employee1);
		employeeRepository.save(employee2);
		employeeRepository.save(employee3);
		employeeRepository.save(employee4);

		departmentRepository.save(department);
		departmentRepository.save(department1);
		departmentRepository.save(department2);
		departmentRepository.save(department3);
		departmentRepository.save(department4);
	}

	@Override
	public Employee createEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public void deleteEmployee(int id) {
		employeeRepository.deleteById(id);
	}

	@Override
	public Employee getEmployeeById(int id) {
		return employeeRepository.getReferenceById(id);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Department createDepartment(Department department) {
		return departmentRepository.save(department);
	}

	@Override
	public Department updateDepartment(Department department) {
		return departmentRepository.save(department);
	}

	@Override
	public void deleteDepartment(int id) {
		departmentRepository.deleteById(id);
	}

	@Override
	public Department getDepartmentById(int id) {
		return departmentRepository.getReferenceById(id);
	}

	@Override
	public List<Department> getAllDepartments() {
		return departmentRepository.findAll();
	}

	@Override
	public int getFirstId() {
		return departmentRepository.findMinId();
	}

	@Override
	public int getLastId() {
		return departmentRepository.findMaxId();
	}

	@Override
	public int getPreviousId(int id) {
		int previousId = departmentRepository.findPreviousId(id);
		return (previousId == 0) ? getLastId() : previousId;
	}

	@Override
	public int getNextId(int id) {
		int nextId = departmentRepository.findNextId(id);
		return (nextId == 0) ? getFirstId() : nextId;
	}

	@Override
	public List<Employee> getAllEmployeesByDepartment(int id) {
		return employeeRepository.findEmployeeByDepartmentId(id);
	}
}
