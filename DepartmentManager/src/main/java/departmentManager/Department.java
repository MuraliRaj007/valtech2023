package departmentManager;

public class Department {
	
	private int deptid;
	private String deptname;
	private String deptloc;
	
	
	public int getDeptid() {
		return deptid;
	}
	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}
	public String getDeptname() {
		return deptname;
	}
	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
	public String getDeptloc() {
		return deptloc;
	}
	public void setDeptloc(String deptloc) {
		this.deptloc = deptloc;
	}
	
	public Department(int deptid, String deptname, String deptloc) {

		this.deptid = deptid;
		this.deptname = deptname;
		this.deptloc = deptloc;
	}
	
	public Department(String deptname, String deptloc) {
		this.deptname = deptname;
		this.deptloc = deptloc;
	}
	public Department() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Department [deptid=" + deptid + ", deptname=" + deptname + ", deptloc=" + deptloc + "]";
	}
	
	
	
	
	
	
	
	

}
