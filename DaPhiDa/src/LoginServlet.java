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
 * A servlet that handles login attempts
 * 
 * @author Phillip Huang
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	                        throws ServletException, IOException {
	    HttpSession session = request.getSession();
	    String login = (String)session.getAttribute("login");
	    
	    if (login == null) {
	        response.sendRedirect("../login.html");
	    }
	    else {
	        response.sendRedirect("../index.html");
	    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	                        throws ServletException, IOException {
	    // TODO logout still needs to be implemented
//	    if((request.getParameter("action")!=null) 
//	            && (request.getParameter("action").trim().equals("logout"))) {
//	        HttpSession session=request.getSession();  
//            session.removeAttribute("login");
//            response.sendRedirect("/");
//            return;
//	        System.err.println("action: " + request.getParameter("action"));
//        }
//        
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        
        HttpSession session = request.getSession();
        
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
	    String queryString = "SELECT * FROM person WHERE Email = ? AND Password = ?";
	    try (PreparedStatement query = conn.prepareStatement(queryString)) {
    	    query.setString(1, email);
            query.setString(2, password);
    	    
    	    ResultSet rs = query.executeQuery();
    	    
    	    return rs.next();
	    }
	}

}
