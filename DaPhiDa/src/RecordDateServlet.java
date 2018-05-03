import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/employee/recordDate" })
public class RecordDateServlet extends HttpServlet{
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
		String profile1 = request.getParameter("profile1");
		String profile2 = request.getParameter("profile2");
		String custRep = request.getParameter("custRep");
		String date_time = request.getParameter("date_Time");
		String location = request.getParameter("location");
		String bookingFee = request.getParameter("bookingFee");
		
		String update = 
				"INSERT INTO Date(Profile1,Profile2,CustRep,Date_Time,Location,BookingFee,Comments,User1Rating,User2Rating) " +
				"VALUES(?,?,?,?,?,?,?,?,?)";
		
		try (Connection conn = ConnUtil.getConnection(); 
				PreparedStatement stmt = conn.prepareStatement(update)) 
		{
			stmt.setString(1, profile1);
			stmt.setString(2, profile2);
			stmt.setString(3, custRep);
			stmt.setString(4, date_time);
			stmt.setString(5, location);
			stmt.setString(6, bookingFee);
			stmt.setString(7, null);
			stmt.setString(8, null);
			stmt.setString(9, null);
			
			stmt.executeUpdate();
		}
		catch (Exception ex) {
			ex.printStackTrace();
			
			PrintWriter out = response.getWriter();
			out.println("<html>");
	        out.println("<head><title>Could not process</title></head>");
	 
	        out.println("<body>");
	 
	        out.println("<h3>Could not process your request</h3><br>");
	        
	        out.println("<a href = ../recordDate.jsp> Return </a>");
	 
	        out.println("</body>");
	        out.println("<html>");
	        return;
		}
		response.sendRedirect("../success.jsp");
	}
	
}
