import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Date;
import beans.Profile;

/**
 * Servlet implementation class ProfileServlet
 */
@WebServlet(urlPatterns = { "/dates/*" })
public class DateListServlet extends HttpServlet {
	 static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DateListServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO add to login filter
		
		String urlStub = "/dates/";
		String requestURI = request.getRequestURI();
		String profileID = requestURI.substring(requestURI.indexOf(urlStub) + urlStub.length());

		// Check if owner
		HttpSession session = request.getSession();
		List<String> profiles = (List<String>) session.getAttribute("profiles");
		
		if (session.getAttribute("emp") == null && !profiles.contains(profileID)) {
			response.sendRedirect("/CSE_305/");
			return;
		}
		ArrayList<Date> dates = new ArrayList<Date>();
		
		String profQuery = 
				"SELECT * " +
				"FROM Date D " +
				"WHERE D.profile1 = ? OR D.profile2 = ?";
		
		try (Connection conn = ConnUtil.getConnection();
				PreparedStatement profStmt = conn.prepareStatement(profQuery)) {
			conn.setAutoCommit(false);
			
			profStmt.setString(1, profileID);
			profStmt.setString(2, profileID);
			ResultSet rs = profStmt.executeQuery();
			
			while ( rs.next() ) {
				//create a list of dates
				String profile1			= rs.getString("profile1");
				String profile2			= rs.getString("profile2");
				String custRep			= rs.getString("custRep");
				Timestamp dateTime		= rs.getTimestamp("date_Time");
				String location			= rs.getString("location");
				BigDecimal bookingFee	= rs.getBigDecimal("bookingFee");
				String comments			= rs.getString("comments");
				Integer user1Rating		= rs.getInt("user1Rating");
				Integer user2Rating		= rs.getInt("user2Rating");

				dates.add( new Date(profile1, profile2, custRep, dateTime, location, bookingFee, comments, user1Rating, user2Rating) );
			}
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}

		// Attach beamn to request
		request.setAttribute("dates", dates);
		request.setAttribute("profile", profileID);
		
		// Pass request to jsp
		RequestDispatcher view = request.getRequestDispatcher("/datelist.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
