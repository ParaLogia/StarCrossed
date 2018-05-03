import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/manager/editEmployee/update"})
public class UpdateEditEmployeeServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String ssn = request.getParameter("ssn");
		String role = request.getParameter("role");
		String startDate = request.getParameter("startDate");
		String HourlyRate = request.getParameter("hourlyRate");
		
		String update = 
				"UPDATE Employee output " +
				"SET role = ?, startdate = ?, hourlyrate = ? "
				+ "WHERE ssn = ?";
		
		try (Connection conn = ConnUtil.getConnection(); 
				PreparedStatement stmt = conn.prepareStatement(update)) 
		{
			stmt.setString(1, role);
			stmt.setString(2, startDate);
			stmt.setString(3, HourlyRate);
			stmt.setString(4, ssn);

			stmt.executeUpdate();
		}
		catch (Exception ex) {
			ex.printStackTrace();
			
			PrintWriter out = response.getWriter();
			out.println("<html>");
	        out.println("<head><title>Could not process</title></head>");
	 
	        out.println("<body>");
	 
	        out.println("<h3>Could not process your request</h3><br>");
	        
	        out.println("<a href = ../allEmployees> Return </a>");
	 
	        out.println("</body>");
	        out.println("<html>");
	        return;
		}
		
		response.sendRedirect("../../success.jsp");
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
