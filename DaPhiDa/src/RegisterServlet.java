import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Integer;
import beans.String;

/**
 * Servlet implementation class RegisterServlet
 * 
 * @author David Song
 */
@WebServlet("/RegisterServlet")
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
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
	    String ssn = (String)session.getAttribute("ssn");
	    String password = (String)session.getAttribute("password");
	    String passwordRepeat = (String)session.getAttribute("passwordRepeat");
	    String firstName = (String)session.getAttribute("firstName");
	    String lastName = (String)session.getAttribute("lastName");
	    String street= (String)session.getAttribute("street");
	    String city = (String)session.getAttribute("city");
	    String state = (String)session.getAttribute("state");
	    int zipcode= (String)session.getAttribute("zipcode");
	    String email = (String)session.getAttribute("email");
	    String telephone= (String)session.getAttribute("telephone");
	    
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

            conn.setAutoCommit(false);
            
            if ( !registerAccount(ssn, password, firstName, lastName, street, city, state, 
														zipcode, email, telephone, conn) ) {
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
	
	private boolean registerAccount(String ssn, String password, String firstName, String lastName, String street, String city, String state, 
													Integer zipcode, String email, String telephone, Connection conn) throws SQLException {
	    String queryString = "INSERT INTO person "
	    		+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	    
	    try (PreparedStatement query = conn.prepareStatement(queryString)) {
	    	
    	    query.setString(1, ssn);
            query.setString(2, password);
            query.setString(3, firstName);
            query.setString(4, lastName);
            query.setString(5, street);
            query.setString(6, city);
            query.setString(7, state);
            query.setString(8, zipcode);
            query.setString(9, email);
            query.setString(10, telephone);
    	    query.executeUpdate();
	    }
	    return true;
	}

}
