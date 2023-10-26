package employeeManager;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDAO {
	
	int firstId() throws SQLException;
	
	int lastId() throws SQLException;
	
	int previousID(int id) throws SQLException;
	
	int nextID(int id) throws SQLException;
	
	void deleteEmployee(int id) throws SQLException;

	void updateEmployee(Employee emp) throws SQLException;

	void insertEmployee(Employee emp) throws SQLException;

	List<Employee> getAllEmployees() throws SQLException;

	Employee getEmployee(int id) throws SQLException;
	
	List<Employee> getEmployeesSalaryGT(int salary) throws SQLException;
	
	List<Employee> getEmployeesSalaryLT(int salary) throws SQLException;
	
	List<Employee> getEmployeesByAgeBTW(int min, int max) throws SQLException;
	
	long count() throws SQLException ;

}