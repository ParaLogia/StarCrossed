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

import beans.EmployeeOut;

/**
 * Handles creation of the employees list
 * @author Darren Ling
 *
 */
@WebServlet(urlPatterns = { "/currentEmployees" })
public class CurrentEmployees extends HttpServlet{
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
	    String sql = "select * from employeetable";

	    ResultSet rs;
	    try (Connection conn = ConnUtil.getConnection()){
	    	PreparedStatement query = conn.prepareStatement(sql);
    	    rs = query.executeQuery();
    	    
    	    List<EmployeeOut> employees = new ArrayList<EmployeeOut>();
    	    
    	    while (rs.next()) {
				EmployeeOut output = new EmployeeOut();
				output.setRole(rs.getString("Role"));
				output.setStartDate(rs.getDate("StartDate"));
				output.setFirstName(rs.getString("FirstName"));
				output.setLastName(rs.getString("LastName"));
				output.setEmail(rs.getString("Email"));
				output.setTelephone(rs.getString("Telephone"));
				output.setState(rs.getString("State"));
				output.setZipcode(rs.getInt("Zipcode"));
				employees.add(output);
			}
			if(employees.isEmpty()) {
				EmployeeOut output = new EmployeeOut();
				output.setRole("No Employees");
				employees.add(output);
			}
			request.setAttribute("employees", employees);
			
			
			RequestDispatcher view = request.getRequestDispatcher("/currentEmployees.jsp");
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
