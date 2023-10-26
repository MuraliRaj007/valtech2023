package departmentManager;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DepartmentServlet
 */
@WebServlet("/")
public class DepartmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       private DepartmentDAO deptDao=new DepartmentDAOImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepartmentServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action=request.getServletPath();
		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/insert":
				insertEmp(request, response);
				break;
			case "/delete":
				deleteEmp(request, response);
				break;
			case "/update":
				updateEmp(request, response);
				break;
			case "/view":
				viewDept(request, response);
				break;
			default:
				listOfDept(request, response);
				break;
			}
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void listOfDept(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {

		List<Department> deptList=deptDao.getAllDepartments();
		request.setAttribute("deptList", deptList);
		request.getRequestDispatcher("departmentList.jsp").forward(request, response);
	}

	private void viewDept(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {

		int deptId=Integer.parseInt(request.getParameter("deptid"));
		Department dept=deptDao.getDepartment(deptId);
		List<Employee> empListbyDept=deptDao.getAllEmpByDeptId(deptId);
		request.setAttribute("empListbyDept", empListbyDept);
		request.setAttribute("dept", dept);
		request.getRequestDispatcher("department.jsp").forward(request, response);
	}

	private void updateEmp(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {

		int deptId=Integer.parseInt(request.getParameter("deptid"));
		String deptName=request.getParameter("deptname");
		String deptLoc=request.getParameter("deptloc");
		
		Department dept=new Department(deptId, deptName, deptLoc);
		deptDao.updateDepartment(dept);
		
		response.sendRedirect("list");
	}

	private void deleteEmp(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {

		int deptid=Integer.parseInt(request.getParameter("deptid"));
		deptDao.deleteDepartment(deptid);
		
		response.sendRedirect("list");
	}

	private void insertEmp(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {

		int deptId=Integer.parseInt(request.getParameter("deptid"));
		String deptName=request.getParameter("deptname");
		String deptLoc=request.getParameter("deptloc");
		
		Department dept=new Department(deptId, deptName, deptLoc);
		deptDao.insertDepartment(dept);
		
		response.sendRedirect("list");
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {

		int deptid=Integer.parseInt(request.getParameter("deptid"));
		Department dept=deptDao.getDepartment(deptid);
		request.setAttribute("department", dept);
		request.getRequestDispatcher("deptForm.jsp").forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("deptForm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
