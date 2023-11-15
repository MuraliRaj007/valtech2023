package AssignmentWeb;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("username");
		String pass=request.getParameter("password");
		if(name.length()<= 4) {
			request.setAttribute("namemessage", "Username should be morethan 4 characters");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else if(pass.length()<= 8) {
			request.setAttribute("passmessage", "Password should be morethan 8 characters");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else if (name.length()>4  && pass.length()>8) {
			if("murali".equals(name) && "123456789".equals(pass)) {
				request.setAttribute("invalidmessage", "Hi murali ... how  r u");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}else {
				request.setAttribute("invalidmessage", "not a valid user");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}
	}

}
