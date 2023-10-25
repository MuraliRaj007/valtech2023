package com.valtech.training.day4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/valtech2023", "root", "root");
	}

	@Override
	public void deleteEmployee(int id) throws SQLException {
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement("DELETE FROM EMPLOYEE WHERE ID=?");
		ps.setInt(1, id);
		int rs = ps.executeUpdate();
		System.out.println(rs);
		con.close();

	}

	@Override
	public void updateEmployee(Employee emp) throws SQLException {

		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement(
				"UPDATE EMPLOYEE SET NAME=?,AGE=?,SALARY=?,EXPERIENCE=?,SENOIRITY=? DEPTID=? WHERE ID=?");
		populatePreparedStmtFromEmployee(emp, ps);
		ps.setInt(6, emp.getId());
		int rs = ps.executeUpdate();
		System.out.println(rs);
		con.close();

	}

	@Override
	public void createEmployee(Employee emp) throws SQLException {
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement(
				"INSERT INTO EMPLOYEE(name,age,salary,experience,senoirity,deptid) VALUES(?,?,?,?,?,?)");
		populatePreparedStmtFromEmployee(emp, ps);
		int rs = ps.executeUpdate();
		System.out.println(rs);
		con.close();
	}

	private void populatePreparedStmtFromEmployee(Employee emp, PreparedStatement ps) throws SQLException {
		ps.setString(1, emp.getName());
		ps.setInt(2, emp.getAge());
		ps.setInt(3, emp.getSalary());
		ps.setInt(4, emp.getExperience());
		ps.setInt(5, emp.getSenoirity());
		ps.setInt(6, emp.getDeptid());
	}

	@Override
	public List<Employee> getAllEmployees() throws SQLException {
		Connection con = getConnection();
		PreparedStatement ps = con
				.prepareStatement("SELECT ID,NAME,AGE,SALARY,EXPERIENCE,SENOIRITY,DEPTID FROM EMPLOYEE");
		ResultSet rs = ps.executeQuery();
		List<Employee> empL = new ArrayList<Employee>();
		while (rs.next()) {
			empL.add(mapRowToEmployee(rs));
		}
		con.close();
		return empL;

	}

	@Override
	public Employee getEmployee(int id) throws SQLException {
		Connection con = getConnection();
		PreparedStatement ps = con
				.prepareStatement("SELECT ID,NAME,AGE,SALARY,EXPERIENCE,SENOIRITY,DEPTID FROM EMPLOYEE WHERE ID=?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			Employee e = mapRowToEmployee(rs);
			con.close();
			return e;
		} else {
			System.out.println("No Row with id=" + id);
			return null;
		}

	}

	private Employee mapRowToEmployee(ResultSet rs) throws SQLException {
		Employee e = new Employee();
		e.setId(rs.getInt(1));
		e.setName(rs.getString(2));
		e.setAge(rs.getInt(3));
		e.setSalary(rs.getInt(4));
		e.setExperience(rs.getInt(5));
		e.setSenoirity(rs.getInt(6));
		e.setDeptid(rs.getInt(7));
		return e;
	}

	@Override
	public long count() throws SQLException {
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement("SELECT COUNT(*) FROM EMPLOYEE");
		ResultSet rs = ps.executeQuery();
		rs.next();
		long c = rs.getLong(1);
		System.out.println(c);
		con.close();
		return c;
	}

	@Override
	public List<Employee> getEmployeesSalaryGT(int salary) throws SQLException {
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement(
				"SELECT ID,NAME,AGE,SALARY,EXPERIENCE,SENOIRITY,DEPTID FROM EMPLOYEE WHERE SALARY>=?");
		ps.setInt(1, salary);
		ResultSet rs = ps.executeQuery();
		List<Employee> empL = new ArrayList<Employee>();
		while (rs.next()) {
			empL.add(mapRowToEmployee(rs));
		}
		con.close();
		return empL;
	}

	@Override
	public List<Employee> getEmployeesSalaryLT(int salary) throws SQLException {
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement(
				"SELECT ID,NAME,AGE,SALARY,EXPERIENCE,SENOIRITY,DEPTID FROM EMPLOYEE WHERE SALARY<=?");
		ps.setInt(1, salary);
		ResultSet rs = ps.executeQuery();
		List<Employee> empL = new ArrayList<Employee>();
		while (rs.next()) {
			empL.add(mapRowToEmployee(rs));
		}
		con.close();
		return empL;
	}

	@Override
	public List<Employee> getEmployeesByAgeBTW(int min, int max) throws SQLException {
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement(
				"SELECT ID,NAME,AGE,SALARY,EXPERIENCE,SENOIRITY,DEPTID FROM EMPLOYEE WHERE AGE BETWEEN ? AND ?");
		ps.setInt(1, min);
		ps.setInt(2, max);
		ResultSet rs = ps.executeQuery();
		List<Employee> empL = new ArrayList<Employee>();
		while (rs.next()) {
			empL.add(mapRowToEmployee(rs));
		}
		con.close();
		return empL;
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
