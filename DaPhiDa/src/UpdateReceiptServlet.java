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

@WebServlet(urlPatterns = {"/employee/editReceipt/receipt"})
public class UpdateReceiptServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String profile1 = request.getParameter("profile1");
		String profile2 = request.getParameter("profile2");
		String custRep = request.getParameter("custRep");
		String dateTime = request.getParameter("dateTime");
		String location = request.getParameter("location");
		String bookingFee = request.getParameter("bookingFee");
		String comments = request.getParameter("comments");
		String user1Rating = request.getParameter("user1Rating");
		String user2Rating = request.getParameter("user2Rating");
		
		
		String update = 
				"UPDATE Date D " +
				"SET custRep = ?, location = ?, bookingfee = ?, "
				+ "comments = ?, user1rating = ?, user2rating = ? " 
				+ "WHERE profile1 = ? AND profile2 = ? AND date_time = ?";
		
		try (Connection conn = ConnUtil.getConnection(); 
				PreparedStatement stmt = conn.prepareStatement(update)) 
		{
			stmt.setString(1, custRep);
			stmt.setString(2, location);
			stmt.setString(3, bookingFee);
			stmt.setString(4, comments);
			stmt.setString(5, user1Rating);
			stmt.setString(6, user2Rating);
			stmt.setString(7, profile1);
			stmt.setString(8, profile2);
			stmt.setString(9, dateTime);
			
			stmt.executeUpdate();
		}
		catch (Exception ex) {
			ex.printStackTrace();
			
			PrintWriter out = response.getWriter();
			out.println("<html>");
	        out.println("<head><title>Could not process</title></head>");
	 
	        out.println("<body>");
	 
	        out.println("<h3>Could not process your request</h3><br>");
	        
	        out.println("<a href = ../recordReceipt.jsp> Return </a>");
	 
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
