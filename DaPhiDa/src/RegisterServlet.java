import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RegisterServlet
 * 
 * @author David Song
 */
@WebServlet(urlPatterns = { "/register/submit" })
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
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
	    String ssn = request.getParameter("ssn");
	    String password = request.getParameter("password");
	    String passwordRepeat = request.getParameter("passwordRepeat");
	    String firstName = request.getParameter("firstName");
	    String lastName = request.getParameter("lastName");
	    String street= request.getParameter("street");
	    String city = request.getParameter("city");
	    String state = request.getParameter("state");
	    Integer zipcode = Integer.valueOf(request.getParameter("zipcode"));
	    String email = request.getParameter("email");
	    String telephone= request.getParameter("telephone");
	    
	    if (email.trim().equals("") || password.trim().equals("") || ssn.trim().equals("") ) {
	    	System.err.println("No spaces in fields");
	    	response.sendRedirect("../Register.jsp");
            return;
        }
	    if (!password.equals(passwordRepeat)) {
	    	System.err.println("Passwords not equal to each other");
	    	response.sendRedirect("../Register.jsp");
	    	return;
	    }
        try (Connection conn = ConnUtil.getConnection()) {
            System.err.println("Connected successfully to database");

//            conn.setAutoCommit(false);
            
            try {
            	registerAccount(ssn, password, firstName, lastName, street, city, state, 
						zipcode, email, telephone, conn);
            }
            catch (SQLException e) {
            	e.printStackTrace();
            	System.err.println("Account not added to database");
            }
            
            ConnUtil.closeQuietly(conn);
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        System.err.println("Register account success");
    	response.sendRedirect("../login.jsp");
	}
	
	private void registerAccount(String ssn, String password, String firstName, String lastName, String street, String city, String state, 
													Integer zipcode, String email, String telephone, Connection conn) throws SQLException {
	    String queryString = 
	    		"INSERT INTO person " +
	    		"VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	    
	    try (PreparedStatement query = conn.prepareStatement(queryString)) {
	    	
//	    	String countQuery = "SELECT COUNT(*) FROM person";
//	    	
//	    	Statement stmt = conn.createStatement();
//	    	ResultSet rs = stmt.executeQuery(countQuery);
//	    	if (rs.next()) {
//	    		System.out.println("COUNT before = " + rs.getInt(1));
//	    	}
//	    	stmt.close();
	    	
    	    query.setString(1, ssn);
            query.setString(2, password);
            query.setString(3, firstName);
            query.setString(4, lastName);
            query.setString(5, street);
            query.setString(6, city);
            query.setString(7, state);
            query	.setInt(8, zipcode);
            query.setString(9, email);
            query.setString(10, telephone);
            
            query.executeUpdate();
	    }
	}

}
