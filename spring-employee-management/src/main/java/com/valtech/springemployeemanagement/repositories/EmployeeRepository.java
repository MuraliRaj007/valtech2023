package com.valtech.springemployeemanagement.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.valtech.springemployeemanagement.entities.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	@Query(value = "SELECT e FROM Employee e WHERE e.department.id= ?1")
	List<Employee> findEmployeeByDepartmentId(int id);
}
