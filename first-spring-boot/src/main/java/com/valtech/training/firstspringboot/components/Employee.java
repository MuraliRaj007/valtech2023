package com.valtech.training.firstspringboot.components;

public class Employee {
	
	private int id;
	private String name;
	private int age;
	private int salary;
	private int experience;
	private int senoirity;
	private int deptid;
	
	public Employee(int id, String name, int age, int salary, int experience, int senoirity, int deptid) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.experience = experience;
		this.senoirity = senoirity;
		this.deptid = deptid;
	}

	public Employee(String name, int age, int salary, int experience, int senoirity, int deptid) {
		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.experience = experience;
		this.senoirity = senoirity;
		this.deptid = deptid;
	}

	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", salary=" + salary + ", experience="
				+ experience + ", senoirity=" + senoirity + ", deptid=" + deptid + "]";
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public int getSenoirity() {
		return senoirity;
	}
	public void setSenoirity(int seniority) {
		this.senoirity = seniority;
	}
	public int getDeptid() {
		return deptid;
	}
	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}

}
