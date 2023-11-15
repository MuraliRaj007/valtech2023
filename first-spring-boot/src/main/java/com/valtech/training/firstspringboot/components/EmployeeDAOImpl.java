package com.valtech.training.firstspringboot.components;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;


@Component
public class EmployeeDAOImpl implements EmployeeDAO {

	public class EmployeeRowMapper implements RowMapper<Employee> {

		@Override
		public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
			Employee employee=new Employee();
			employee.setId(rs.getInt(1));
			employee.setName(rs.getString(2));
			employee.setAge(rs.getInt(3));
			employee.setSalary(rs.getInt(4));
			employee.setExperience(rs.getInt(5));
			employee.setSenoirity(rs.getInt(6));
			employee.setDeptid(rs.getInt(7));
			return employee;
		}

	}

	@Autowired
	private DataSource dataSource;


	@Override
	public void deleteEmployee(int id) {

		String deleteQuery = "DELETE FROM EMPLOYEE WHERE ID=?";
		new JdbcTemplate(dataSource).update(deleteQuery, id);
	}

	@Override
	public void updateEmployee(Employee emp) {

		String updateQuery = "UPDATE EMPLOYEE SET NAME=?,AGE=?,SALARY=?,EXPERIENCE=?,SENOIRITY=? DEPTID=? WHERE ID=?";
		new JdbcTemplate(dataSource).update(updateQuery, emp.getName(), emp.getAge(), emp.getSalary(),
				emp.getExperience(), emp.getSenoirity(), emp.getDeptid());
	}

	@Override
	public void createEmployee(Employee emp) {

		String createQuery = "INSERT INTO EMPLOYEE(name,age,salary,experience,senoirity,deptid) VALUES(?,?,?,?,?,?)";
		new JdbcTemplate(dataSource).update(createQuery, emp.getName(), emp.getAge(), emp.getSalary(),
				emp.getExperience(), emp.getSenoirity(), emp.getDeptid());
	}

	@Override
	public List<Employee> getAllEmployees() {

		String getAllEmployeesQuery = "SELECT ID,NAME,AGE,SALARY,EXPERIENCE,SENOIRITY,DEPTID FROM EMPLOYEE";
		return new JdbcTemplate(dataSource).query(getAllEmployeesQuery, new EmployeeRowMapper());
	}

//	@Override
//	public Employee getEmployee(int id) throws SQLException {
//		Connection con = getConnection();
//		PreparedStatement ps = con
//				.prepareStatement("SELECT ID,NAME,AGE,SALARY,EXPERIENCE,SENOIRITY,DEPTID FROM EMPLOYEE WHERE ID=?");
//		ps.setInt(1, id);
//		ResultSet rs = ps.executeQuery();
//		if (rs.next()) {
//			Employee e = mapRowToEmployee(rs);
//			con.close();
//			return e;
//		} else {
//			System.out.println("No Row with id=" + id);
//			return null;
//		}
//
//	}

	@Override
	public long count() {

		String countQuery = "SELECT COUNT(*) FROM EMPLOYEE";
		return new JdbcTemplate(dataSource).queryForObject(countQuery, Long.class);
	}


	

	public static void main(String[] args) throws Exception {
		EmployeeDAO dao = new EmployeeDAOImpl();
//		System.out.println(dao.getEmployee(1));
//		System.out.println(dao.getEmployee(2));
//		System.out.println(dao.getAllEmployee());
//		dao.createEmployee(new Employee("sujay",23,15000,5,2));
//		dao.createEmployee(new Employee("mahi",26,25000,7,3));
//		dao.createEmployee(new Employee("jeevan",29,34000,9,4));
//		dao.createEmployee(new Employee("pradeep",34,54000,12,5));
//		dao.createEmployee(new Employee("praveen",24,52000,2,2));
//		dao.createEmployee(new Employee("kruthik",35,62000,13,5));
//		Employee e=dao.getEmployee(1);
//		System.out.println(e);
//		e.setDeptid(1);
//		Employee e=new Employee();
//		e.setSalary(20000);
//		dao.updateEmployee(e);
//		e1.setSalary(30000);
//		e.setSenoirity(3);
//		dao.deleteEmployee(5);
//		dao.count();
//		dao.getEmployeesSalaryGT(30000);
//		dao.getEmployeesSalaryLT(10000);
//		dao.updateEmployee(new Employee());
		List<Employee> emplist = dao.getAllEmployees();
		for (Employee e11 : emplist) {
			System.out.println(e11);
		}

	}

}
