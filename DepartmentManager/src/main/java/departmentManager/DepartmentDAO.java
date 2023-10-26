package departmentManager;

import java.sql.SQLException;
import java.util.List;

public interface DepartmentDAO {
	
	void deleteDepartment(int deptid) throws SQLException;
	
	void updateDepartment(Department dept) throws SQLException;
	
	void insertDepartment(Department dept) throws SQLException;
	
	List<Department> getAllDepartments() throws SQLException;
	
	Department getDepartment(int deptid) throws SQLException;
	
	List<Employee> getAllEmpByDeptId(int deptid) throws SQLException;
	
	
	

}
