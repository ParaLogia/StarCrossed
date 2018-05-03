import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Date;
import beans.Profile;


@WebServlet(urlPatterns = {"/employee/editReceipt/*"})
public class EditReceiptServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO add to login filter
		

		String requestURI = request.getRequestURI();
		String[] tokens = requestURI.split(":");
		String profile1 = tokens[1];
		String profile2 = tokens[2];
		String date_time = tokens[3];
		
		Date d = new Date();
		try (Connection conn = ConnUtil.getConnection()) {
			conn.setAutoCommit(false);
			
			String profQuery = 
					"SELECT * " +
					"FROM Date d " +
					"WHERE d.profile1 = ? AND d.profile2 = ? AND d.date_time = ?";
			
			try (PreparedStatement profStmt = conn.prepareStatement(profQuery)) {
				profStmt.setString(1, profile1);
				profStmt.setString(2, profile2);
				profStmt.setString(3, date_time);
				ResultSet rs = profStmt.executeQuery();
				
				if (rs.next()) {
					//only 1 element
					d.setBookingFee(rs.getBigDecimal("BookingFee"));
					d.setComments(rs.getString("Comments"));
					d.setCustRep(rs.getString("CustRep"));
					d.setDateTime(rs.getTimestamp("Date_Time"));
					d.setLocation(rs.getString("Location"));
					d.setProfile1(rs.getString("Profile1"));
					d.setProfile2(rs.getString("Profile2"));
					d.setUser1Rating(rs.getInt("User1Rating"));
					d.setUser2Rating(rs.getInt("User2Rating"));
				}
			}
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		request.setAttribute("date1", d);
		
		RequestDispatcher view = request.getRequestDispatcher("/editReceipt.jsp");
		view.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
