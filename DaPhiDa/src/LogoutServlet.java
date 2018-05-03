import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(urlPatterns = { "/logout/submit" })
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	                        throws ServletException, IOException {
	    HttpSession session = request.getSession();
	    session.removeAttribute("login");
	    session.removeAttribute("emp");
	    session.removeAttribute("profiles");
	    response.sendRedirect("/CSE_305/login.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	                        throws ServletException, IOException {
		doGet(request,response);
	}

}


