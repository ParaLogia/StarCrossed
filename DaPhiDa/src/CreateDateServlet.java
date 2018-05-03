

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CreateProfileServlet
 * 
 * @author Phillip Huang
 */
@WebServlet(urlPatterns = { "/date/submit" })
public class CreateDateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateDateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String profile1			= request.getParameter("profile1");
		String profile2			= request.getParameter("profile2");
		String custRep			= request.getParameter("custRep");
		String dateTimeLocal	= request.getParameter("dateTime");
		dateTimeLocal = dateTimeLocal.replaceAll("T", " ");
		dateTimeLocal += ":00";
		System.out.println(dateTimeLocal);
		Timestamp dateTime		= Timestamp.valueOf(dateTimeLocal);
		String location			= request.getParameter("location");
		BigDecimal bookingFee		= new BigDecimal(request.getParameter("bookingFee"));
		
		try (Connection conn = ConnUtil.getConnection()) {
			conn.setAutoCommit(false);
						
			String insertDate = 
					"INSERT INTO Date " +
				    		"VALUES(?, ?, ?, ?, ?, ?, null, null, null)";
			
			try (PreparedStatement stmt = conn.prepareStatement(insertDate)) {
				
				stmt.setString(1, profile1);
				stmt.setString(2, profile2);
				stmt.setString(3, custRep);
				stmt.setTimestamp(4, dateTime);
				stmt.setString(5, location);
				stmt.setBigDecimal(6, bookingFee);
				
				if (stmt.executeUpdate() < 1) {
					throw new Exception("Did not create row");
				}
			}
			conn.commit();
			
			response.sendRedirect("/CSE_305/dates/" + profile2);
		}
		catch (Exception e) {
			e.printStackTrace();
			
			System.out.println("Failed to create profile");
		}
	}

}
