import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.User;

@WebServlet(urlPatterns = {"*.deleteEmployeeCheck"})
public class DeleteEmployeeServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		String[] tokens = requestURI.split(":",3);
		String ssn = tokens[1];
		
		String delete = "DELETE FROM Employee WHERE ssn = ?";
		
		try (Connection conn = ConnUtil.getConnection(); 
				PreparedStatement stmt = conn.prepareStatement(delete)) 
		{
			stmt.setString(1, ssn);
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
}
