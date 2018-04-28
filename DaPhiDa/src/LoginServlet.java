import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.*;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(urlPatterns = { "/login/submit" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    if((request.getParameter("action")!=null) && (request.getParameter("action").trim().equals("logout")))
        {
	        HttpSession session=request.getSession();  
//            session.putValue("login","");
            session.setAttribute("login", "");
            response.sendRedirect("/");
            return;
        }
        
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        
        HttpSession session = request.getSession();
//        session.putValue("login","");
        session.setAttribute("login", "");
        if ((email != null) && (password != null)) {
            if (email.trim().equals("") || password.trim().equals("")) {
                response.sendRedirect("../login.html");
                return;
            }
            
            try (Connection conn = ConnUtil.getConnection()) {
                System.err.println("Connected successfully to database");
    
                conn.setAutoCommit(false);
                
                if (validLogin(email, password, conn)) {
                    // TODO
                    System.err.println("Successfully logged in");
                    session.setAttribute("login", email);
                    
                    response.sendRedirect("../index.html");
                }
                else {
                    // TODO
                    System.err.println("Incorrect login");
                    response.sendRedirect("../login.html");
                }
            } 
            catch (Exception e) {
                e.printStackTrace();
            }
        }
	}
	
	public boolean validLogin(String email, String password, Connection conn) throws SQLException {
	    // TODO
	    Statement stmt1 = conn.createStatement();
	    
	    ResultSet rs = stmt1.executeQuery(" select * from person where Email='" + email
                                          + "' and Password='"+ password +"'");
	    
	    return rs.next();
	}

}
