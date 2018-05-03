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

import beans.Employee;

@WebServlet(urlPatterns = { "/manager/editEmployee" })
public class EmployeeListServlet extends HttpServlet {
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
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	                        throws ServletException, IOException {
			String sql = "select * from Employee";
	
		    ResultSet rs;
		    try (Connection conn = ConnUtil.getConnection()){
		    	PreparedStatement query = conn.prepareStatement(sql);
	    	    rs = query.executeQuery();
	    	    
	    	    List<Employee> outputs = new ArrayList<Employee>();
	    	    
	    	    while (rs.next()) {
	    	    	Employee output = new Employee();
					output.setSsn(rs.getString("SSN"));
					output.setRole(rs.getString("Role"));
					output.setStartDate(rs.getDate("StartDate"));
					output.setHourlyRate(rs.getInt("HourlyRate"));
					outputs.add(output);
				}
				if(outputs.isEmpty()) {
					Employee output = new Employee();
					output.setSsn("No employees advalible");
					outputs.add(output);
				}
				request.setAttribute("outputs", outputs);
				
				
				RequestDispatcher view = request.getRequestDispatcher("/allEmployees.jsp");
				view.forward(request, response);
				ConnUtil.closeQuietly(conn);
	    	    
		    } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
        }

}
