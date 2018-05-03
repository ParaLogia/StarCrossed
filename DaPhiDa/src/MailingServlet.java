import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Person;

/**
 * Handles creation of the employees list
 * @author Darren Ling
 *
 */
@WebServlet(urlPatterns = { "/mailingList" })
public class MailingServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	                        throws ServletException, IOException {	    
	  //start query here
	    String sql = "SELECT P.FirstName, P.LastName, P.Email\r\n" + 
	    		"FROM Person P, User U\r\n" + 
	    		"WHERE P.SSN = U.SSN";

	    ResultSet rs;
	    try (Connection conn = ConnUtil.getConnection()){
	    	PreparedStatement query = conn.prepareStatement(sql);
    	    rs = query.executeQuery();
    	    
    	    List<String> emails = new ArrayList<String>();
    	    
    	    while (rs.next()) {
				String output = rs.getString("Email");
				emails.add(output);
			}
			if(emails.isEmpty()) {
				String output = "No People to email";
				emails.add(output);
			}
			request.setAttribute("emails", emails);
			
			
			RequestDispatcher view = request.getRequestDispatcher("/mailingList.jsp");
			view.forward(request, response);
			ConnUtil.closeQuietly(conn);
    	    
	    } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	    
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	                        throws ServletException, IOException {
		doGet(request,response);        
	}
}
