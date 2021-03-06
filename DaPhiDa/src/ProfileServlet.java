

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Profile;

/**
 * Servlet implementation class ProfileServlet
 */
@WebServlet(urlPatterns = { "/profiles/*" })
public class ProfileServlet extends HttpServlet {
	 static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO add to login filter
		
		String urlStub = "/profiles/";
		String requestURI = request.getRequestURI();
		String profileID = requestURI.substring(requestURI.indexOf(urlStub) + urlStub.length());
		
		Profile profile = null;
		
		try (Connection conn = ConnUtil.getConnection()) {
			conn.setAutoCommit(false);
			
			String profQuery = 
					"SELECT * " +
					"FROM Profile P " +
					"WHERE P.ProfileID = ? ";
			
			try (PreparedStatement profStmt = conn.prepareStatement(profQuery)) {
				profStmt.setString(1, profileID);
				ResultSet rs = profStmt.executeQuery();
				
				if (rs.next()) {
					// Create profile bean
					String ownerSSN 			= rs.getString("ownerSSN");
					Integer age 				= rs.getInt("age");
					Integer datingAgeRangeStart = rs.getInt("datingAgeRangeStart");
					Integer datingAgeRangeEnd 	= rs.getInt("datingAgeRangeEnd");
					Integer datingGeoRange 		= rs.getInt("datingGeoRange");
					String m_f					= rs.getString("m_f");
					BigDecimal height			= rs.getBigDecimal("height");
					Integer weight				= rs.getInt("weight");
					String hairColor			= rs.getString("hairColor");
					Timestamp creationDate		= rs.getTimestamp("creationDate");
					Timestamp lastModDate		= rs.getTimestamp("lastModDate");
					String hobbies				= rs.getString("hobbies");
					
					profile = new Profile(profileID, ownerSSN, age, 
							datingAgeRangeStart, datingAgeRangeEnd, datingGeoRange, m_f, 
							height, weight, hairColor, hobbies, creationDate, lastModDate);
				}
			}
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}

		// Attach profile and hobbies to request
		request.setAttribute("profile", profile);
		
		// Check if owner
		HttpSession session = request.getSession();
		List<String> profiles = (List<String>) session.getAttribute("profiles");
		
		if (profiles.contains(profileID)) {
			// Reorder profiles
			profiles.remove(profileID);
			profiles.add(0, profileID);
			session.setAttribute("profiles", profiles);
		}
		
		// Check if editing
		String doEdit = (String) request.getParameter("edit");
		String doDate= (String) request.getParameter("date");
		if (doEdit != null && doEdit.equalsIgnoreCase("true")) {
			
			// Employees or profile owners can access
			if (session.getAttribute("emp") != null || profiles.contains(profileID)) {
				
				// Pass request to jsp
				RequestDispatcher view = request.getRequestDispatcher("/editprof.jsp");
				view.forward(request, response);
				return;
			}
		}
		else {
			String doLike= (String) request.getParameter("like");
			if (doLike != null && doLike.equalsIgnoreCase("true")) {
				
				if (!profiles.isEmpty() && !profiles.contains(profileID)) {
					String mainProfile = profiles.get(0);
					Timestamp time = Timestamp.from(Instant.now());
					
					String likeQuery = 
							"INSERT INTO Likes " +
							"VALUES(?, ?, ?)";
					try (Connection conn = ConnUtil.getConnection();
							PreparedStatement stmt = conn.prepareStatement(likeQuery)) {
						conn.setAutoCommit(true);
						
						stmt.setString(1, mainProfile);
						stmt.setString(2, profileID);
						stmt.setTimestamp(3, time);
						
						stmt.executeUpdate();
						
						request.setAttribute("liked", true);
					}
					catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			}
		}
		
		// Pass request to jsp
		RequestDispatcher view = request.getRequestDispatcher("/profile.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
