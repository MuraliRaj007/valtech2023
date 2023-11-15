package firstWeb;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EmployeeServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EmployeeDAO dao=new EmployeeDAOImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HttpSession ses=req.getSession(true);
			ses.setAttribute("current", dao.firstId());
			ses.setAttribute("emp", dao.getEmployee(dao.firstId()));
			req.getRequestDispatcher("employee.jsp").forward(req, resp);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String action = req.getServletPath();
		System.out.println("URL : "+action);
		HttpSession ses=req.getSession();
		int current=(Integer) ses.getAttribute("current");
		String submit=req.getParameter("submit");
		try {
		if("First".equals(submit)) {
			current=dao.firstId();
		}else if("Last".equals(submit)) {
			current=dao.lastId();
		}else if ("Previous".equals(submit)) {
			current=dao.previousID(current);
		}else if ("Next".equals(submit)) {
			current=dao.nextID(current);
		}
		ses.setAttribute("current", current);
		ses.setAttribute("emp", dao.getEmployee(current));
//		req.setAttribute("emp", dao.getEmployee(current));
//		req.getRequestDispatcher("employee.jsp").forward(req, resp);
		resp.sendRedirect("employee.jsp");
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}

}
