package com.valtech.springemployeemanagement.models;

import java.util.List;

import com.valtech.springemployeemanagement.entities.Department;
import com.valtech.springemployeemanagement.entities.Employee;

public class DepartmentModel {
	
	private int id;
	private String name;
	private String location;
	private List<Employee> employees;
	
	
	public DepartmentModel() {
		super();
	}
	
	
	public DepartmentModel(Department department) {
		this.id = department.getId();
		this.name = department.getName();
		this.location = department.getLocation();
	}
	
	public Department getDepartment() {
		return new Department(id, name, location);
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	

}
