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

@WebServlet(urlPatterns = {"/manager/editUser/update"})
public class UpdateEditUserServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String ssn = request.getParameter("ssn");
		String ppp = request.getParameter("ppp");
		String rating = request.getParameter("rating");
		String dateOfLastAct = request.getParameter("dateOfLastAct");
		
		String update = 
				"UPDATE User output " +
				"SET ppp = ?, rating = ?, dateOfLastAct = ? "
				+ "WHERE ssn = ?";
		
		try (Connection conn = ConnUtil.getConnection(); 
				PreparedStatement stmt = conn.prepareStatement(update)) 
		{
			stmt.setString(1, ppp);
			stmt.setString(2, rating);
			stmt.setString(3, dateOfLastAct);
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
	        
	        out.println("<a href = ../allUsers> Return </a>");
	 
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
