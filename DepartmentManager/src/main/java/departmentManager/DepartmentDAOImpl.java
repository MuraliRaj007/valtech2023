package departmentManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAOImpl implements DepartmentDAO {
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/valtech2023?useSSL=true&requireSSL=true","root","root");
	}
	
	@Override
	public void deleteDepartment(int deptid) throws SQLException {
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("DELETE FROM DEPARTMENT WHERE DEPTID=?");
		ps.setInt(1, deptid);
		ps.execute();
		con.close();
	}

	@Override
	public void updateDepartment(Department dept) throws SQLException {
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("UPDATE DEPARTMENT SET DEPTNAME=?,DEPTLOC=? WHERE DEPTID=?");
		ps.setString(1, dept.getDeptname());
		ps.setString(2, dept.getDeptloc());
		ps.setInt(3,dept.getDeptid());
		ps.executeUpdate();
		con.close();
	}

	@Override
	public void insertDepartment(Department dept) throws SQLException {
		Connection con=getConnection();
		PreparedStatement ps = con.prepareStatement("INSERT INTO DEPARTMENT(deptid,deptname,deptloc) VALUES(?,?,?)");
		ps.setInt(1, dept.getDeptid());
		ps.setString(2, dept.getDeptname());
		ps.setString(3, dept.getDeptloc());
		int rs=ps.executeUpdate();
		System.out.println(rs);
		con.close();
	}

	@Override
	public List<Department> getAllDepartments() throws SQLException {
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("SELECT DEPTID,DEPTNAME,DEPTLOC FROM DEPARTMENT");
		ResultSet rs=ps.executeQuery();
		List<Department> deptlist=new ArrayList<Department>();
		while(rs.next()) {
			Department dept=new Department();
			dept.setDeptid(rs.getInt(1));
			dept.setDeptname(rs.getString(2));
			dept.setDeptloc(rs.getString(3));
			deptlist.add(dept);
		}
		con.close();
		return deptlist;
		
	}

	@Override
	public Department getDepartment(int deptid) throws SQLException {
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("SELECT DEPTID,DEPTNAME,DEPTLOC FROM DEPARTMENT WHERE DEPTID=?");
		ps.setInt(1, deptid);
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			Department dept=new Department();
			dept.setDeptid(rs.getInt(1));
			dept.setDeptname(rs.getString(2));
			dept.setDeptloc(rs.getString(3));
			con.close();
			return dept;
		}else {
			System.out.println("No Dept with id="+deptid);
			return null;
		}
	}

	@Override
	public List<Employee> getAllEmpByDeptId(int deptid) throws SQLException {
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("SELECT ID,NAME,AGE,SALARY,EXPERIENCE,SENOIRITY,DEPTID FROM EMPLOYEE WHERE DEPTID=?");
		ps.setInt(1, deptid);
		ResultSet rs=ps.executeQuery();
		List<Employee> empL=new ArrayList<Employee>();
		while(rs.next()) {
			empL.add(mapRowToEmployee(rs));
			
		}
		con.close();
		return empL;
	}

	private Employee mapRowToEmployee(ResultSet rs) throws SQLException {
		Employee e=new Employee();
		e.setId(rs.getInt(1));
		e.setName(rs.getString(2));
		e.setAge(rs.getInt(3));
		e.setSalary(rs.getInt(4));
		e.setExperience(rs.getInt(5));
		e.setSenoirity(rs.getInt(6));
		e.setDeptid(rs.getInt(7));
		return e;
	}

	public static void main(String[] args) throws SQLException {
		DepartmentDAOImpl dao=new DepartmentDAOImpl();
//		Department dept=new Department(8,"Talent Acquisition","1st floor");
//		dao.insertDepartment(dept);
//		dao.updateDepartment(dept);
//		dao.deleteDepartment(8);
		List<Department> d=dao.getAllDepartments();
		for (Department department : d) {
			System.out.println(department);
		}
		List<Employee> empList=dao.getAllEmpByDeptId(1);
		for (Employee employee : empList) {
			System.out.println(employee);
		}
	}

}
