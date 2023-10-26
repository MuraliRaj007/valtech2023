package employeeManager;

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
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/valtech2023?useSSL=false","root","root");
	}
	
	@Override
	public void deleteEmployee(int id) throws SQLException {
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("DELETE FROM EMPLOYEE WHERE ID=?");
		ps.setInt(1,id);
		int rs=ps.executeUpdate();
		System.out.println(rs);
		con.close();
		
	}
	
	@Override
	public void updateEmployee(Employee emp) throws SQLException {
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("UPDATE EMPLOYEE SET ID=?,NAME=?,AGE=?,SALARY=?,EXPERIENCE=?,SENOIRITY=?,DEPTID=? WHERE ID=?");
		populatePreparedStmtFromEmployee(emp, ps);
		ps.setInt(8,emp.getId());
		int rs=ps.executeUpdate();
		System.out.println(rs);
		con.close();
		
	}
	
	@Override
	public void insertEmployee(Employee emp) throws SQLException {
		Connection con=getConnection();
		PreparedStatement ps = con.prepareStatement("INSERT INTO EMPLOYEE(id,name,age,salary,experience,senoirity,deptid) VALUES(?,?,?,?,?,?,?)");
		populatePreparedStmtFromEmployee(emp, ps);
		int rs=ps.executeUpdate();
		System.out.println(rs);
		con.close();
	}

	private void populatePreparedStmtFromEmployee(Employee emp, PreparedStatement ps) throws SQLException {
		ps.setInt(1, emp.getId());
		ps.setString(2, emp.getName());
		ps.setInt(3, emp.getAge());
		ps.setInt(4, emp.getSalary());
		ps.setInt(5, emp.getExperience());
		ps.setInt(6, emp.getSenoirity());
		ps.setInt(7, emp.getDeptid());
	}
	
	@Override
	public List<Employee> getAllEmployees() throws SQLException{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("SELECT ID,NAME,AGE,SALARY,EXPERIENCE,SENOIRITY,DEPTID FROM EMPLOYEE");
		ResultSet rs=ps.executeQuery();
		List<Employee> empL=new ArrayList<Employee>();
		while(rs.next()) {
			empL.add(mapRowToEmployee(rs));
		}
		con.close();
		return empL;
		
	}
	@Override
	public Employee getEmployee(int id) throws SQLException {
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("SELECT ID,NAME,AGE,SALARY,EXPERIENCE,SENOIRITY,DEPTID FROM EMPLOYEE WHERE ID=?");
		ps.setInt(1, id);
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			Employee e = mapRowToEmployee(rs);
			con.close();
			return e;
		}else {
			System.out.println("No Row with id="+id);
			return null;
		}
		
		
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

	@Override
	public long count() throws SQLException {
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("SELECT COUNT(*) FROM EMPLOYEE");
		ResultSet rs=ps.executeQuery();
		rs.next();
		long c=rs.getLong(1);
		System.out.println(c);
		con.close();
		return c;
	}

	@Override
	public List<Employee> getEmployeesSalaryGT(int salary) throws SQLException {
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("SELECT ID,NAME,AGE,SALARY,EXPERIENCE,SENOIRITY,DEPTID FROM EMPLOYEE WHERE SALARY>=?");
		ps.setInt(1, salary);
		ResultSet rs=ps.executeQuery();
		List<Employee> empL=new ArrayList<Employee>();
		while(rs.next()) {
			empL.add(mapRowToEmployee(rs));
		}
		con.close();
		return empL;
	}

	@Override
	public List<Employee> getEmployeesSalaryLT(int salary) throws SQLException {
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("SELECT ID,NAME,AGE,SALARY,EXPERIENCE,SENOIRITY,DEPTID FROM EMPLOYEE WHERE SALARY<=?");
		ps.setInt(1, salary);
		ResultSet rs=ps.executeQuery();
		List<Employee> empL=new ArrayList<Employee>();
		while(rs.next()) {
			empL.add(mapRowToEmployee(rs));
		}
		con.close();
		return empL;
	}

	@Override
	public List<Employee> getEmployeesByAgeBTW(int min, int max) throws SQLException {
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("SELECT ID,NAME,AGE,SALARY,EXPERIENCE,SENOIRITY,DEPTID FROM EMPLOYEE WHERE AGE BETWEEN ? AND ?");
		ps.setInt(1, min);
		ps.setInt(2, max);
		ResultSet rs=ps.executeQuery();
		List<Employee> empL=new ArrayList<Employee>();
		while(rs.next()) {
			empL.add(mapRowToEmployee(rs));
		}
		con.close();
		return empL;
	}
	
	@Override
	public int firstId() throws SQLException {
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("SELECT MIN(ID) FROM EMPLOYEE");
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			int id=rs.getInt(1);
			con.close();
			return id;
		}
		return 0;
	}

	@Override
	public int lastId() throws SQLException {
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("SELECT MAX(ID) FROM EMPLOYEE");
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			int id=rs.getInt(1);
			con.close();
			return id;
		}
		return 0;
	}

	@Override
	public int previousID(int id) throws SQLException {
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("SELECT MAX(ID) FROM EMPLOYEE WHERE ID < ?");
		ps.setInt(1, id);
		ResultSet rs=ps.executeQuery();
		int pid = 0;
		if(rs.next()) {
			pid=rs.getInt(1);
			con.close();
		}
		con.close();
		return pid==0 ? lastId(): pid;
	}

	@Override
	public int nextID(int id) throws SQLException {
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("SELECT MIN(ID) FROM EMPLOYEE WHERE ID > ?");
		ps.setInt(1, id);
		ResultSet rs=ps.executeQuery();
		int nid=0;
		if(rs.next()) {
			nid=rs.getInt(1);
			con.close();
		}
		con.close();
		return nid == 0 ? firstId() : nid;
	}
	
	public static void main(String[] args) throws Exception {
		EmployeeDAO dao=new EmployeeDAOImpl();
//		dao.deleteEmployee(14);
//		dao.updateEmployee(new Employee(14,"vijay",31,43000,8,4,1));
//		dao.insertEmployee(new Employee(14,"vijay",31,42000,8,4,1));
//		System.out.println(dao.getEmployee(1));
		List<Employee> emplist = dao.getAllEmployees();
		for (Employee e : emplist) {
			System.out.println(e);
		}
		
		
//		dao.count();
//		dao.getEmployeesSalaryGT(30000);
//		dao.getEmployeesSalaryLT(10000);
		
	}

}
