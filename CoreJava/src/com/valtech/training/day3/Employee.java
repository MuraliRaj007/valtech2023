package com.valtech.training.day3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Employee implements Comparable<Employee>{
	
	String name;
	int age;
    double salary;
    int experience;
	
	public Employee(String name,int age,double salary,int experience) {
		this.name=name;
		this.age=age;
		this.salary=salary;
		this.experience=experience;
	}
	
	@Override
	public int compareTo(Employee o) {
		
		if(this.experience-(o.experience)!=0) {
			return this.experience-o.experience;
		}
		
		if(this.name.compareTo(o.name)!=0) {
			return this.name.compareTo(o.name);
		}
		
		return this.age-(o.age);
	}
	
	@Override
		public String toString() {
			return "Name="+name+"  Age="+age+" Salary="+salary+"  Experience="+experience;
		}	
	

	public static void main(String[] args) {
		List<Employee> employee=new ArrayList<Employee>();
		
		employee.add(new Employee("murali",22,50000,1));
		employee.add(new Employee("praveen",23,60000,2));
		employee.add(new Employee("kartik",24,70000,4));
		employee.add(new Employee("pradeep",25,80000,1));
		 
		Collections.sort(employee);
		
		for (Employee e : employee) {
			System.out.println(e);	
		}
	
	}

}



