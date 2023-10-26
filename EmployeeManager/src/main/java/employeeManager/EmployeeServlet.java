package employeeManager;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet("/")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private EmployeeDAO dao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmployeeServlet() {
		super();
		this.dao = new EmployeeDAOImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();
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
				viewEmp(request, response);
				break;
			default:
				listOfEmp(request, response);
				break;
			}
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void viewEmp(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {

		int id=Integer.parseInt(request.getParameter("id"));
		Employee emp=dao.getEmployee(id);
		request.setAttribute("emp", emp);
		request.getRequestDispatcher("employee.jsp").forward(request, response);
	}

	private void listOfEmp(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		List<Employee> empList = dao.getAllEmployees();
		request.setAttribute("empList", empList);
		request.getRequestDispatcher("employeeList.jsp").forward(request, response);

	}

	private void updateEmp(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {

		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		int salary = Integer.parseInt(request.getParameter("salary"));
		int experience = Integer.parseInt(request.getParameter("experience"));
		int senoirity = Integer.parseInt(request.getParameter("senoirity"));
		int deptid = Integer.parseInt(request.getParameter("deptid"));

		Employee emp = new Employee(id, name, age, salary, experience, senoirity, deptid);
		dao.updateEmployee(emp);

		response.sendRedirect("list");
	}

	private void deleteEmp(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		dao.deleteEmployee(id);
		response.sendRedirect("list");
	}

	private void insertEmp(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		
		int id=Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		int salary = Integer.parseInt(request.getParameter("salary"));
		int experience = Integer.parseInt(request.getParameter("experience"));
		int senoirity = Integer.parseInt(request.getParameter("senoirity"));
		int deptid = Integer.parseInt(request.getParameter("deptid"));

		Employee emp =new Employee(id, name, age, salary, experience, senoirity, deptid);
		dao.insertEmployee(emp);

		response.sendRedirect("list");
	}
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {

		int id=Integer.parseInt(request.getParameter("id"));
		Employee emp=dao.getEmployee(id);
		request.setAttribute("employee", emp);
		request.getRequestDispatcher("empForm.jsp").forward(request, response);
		
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("empForm.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
