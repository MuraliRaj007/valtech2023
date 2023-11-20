package com.valtech.springemployeemanagement.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String location;
	@OneToMany(targetEntity = Employee.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "department")
	private Set<Employee> employees;

	public void addEmployees(Employee employee) {
		if (getEmployees()==null) {
			setEmployees(new HashSet<Employee>());
		}
		getEmployees().add(employee);
		employee.setDepartment(this);
	}

	
	public Department() {
		super();
	}

	public Department(String name, String location) {
		super();
		this.name = name;
		this.location = location;
	}

	public Department(int id, String name, String location) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
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

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

}
