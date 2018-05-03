

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.Instant;
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
@WebServlet(urlPatterns = { "/profiles/create" })
public class CreateProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateProfileServlet() {
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

		String profileID			= request.getParameter("profileID");
		Integer age 				= Integer.valueOf(request.getParameter("age"));
		Integer datingAgeRangeStart = Integer.valueOf(request.getParameter("datingAgeRangeStart"));
		Integer datingAgeRangeEnd 	= Integer.valueOf(request.getParameter("datingAgeRangeEnd"));
		Integer datingGeoRange 		= Integer.valueOf(request.getParameter("datingGeoRange"));
		String m_f					= request.getParameter("m_f");
		BigDecimal height			= new BigDecimal(request.getParameter("height"));
		Integer weight				= Integer.valueOf(request.getParameter("weight"));
		String hairColor			= request.getParameter("hairColor");
		String hobbies				= request.getParameter("hobbies");
		
		try (Connection conn = ConnUtil.getConnection()) {
			conn.setAutoCommit(false);
			String ssnQuery = 
				"SELECT P.SSN " + 
				"FROM Person P " +
				"WHERE P.Email = ?";
			
			String email = (String) request.getSession().getAttribute("login");
			
			String ownerSSN;
			try (PreparedStatement stmt = conn.prepareStatement(ssnQuery)) {
				stmt.setString(1, email);
				ResultSet rs = stmt.executeQuery();
				
				rs.next();
				ownerSSN = rs.getString(1);	
			}
			
			String userQuery =
					"SELECT * " +
					"FROM User U " +
					"WHERE U.SSN = ?";
			try (PreparedStatement stmt = conn.prepareStatement(ssnQuery)) {
				stmt.setString(1, email);
				ResultSet rs = stmt.executeQuery();
				
				// Need to create user
				if (!rs.next()) {
					String PPP = request.getParameter("PPP");
					
					String insertUser = 
							"INSERT INTO User " +
						    		"VALUES(?, ?, NULL, NULL)";
					
					try (PreparedStatement insertStmt = conn.prepareStatement(insertUser)) {
						
						insertStmt.setString(1, ownerSSN);
						insertStmt.setString(2, PPP);
						
						if (insertStmt.executeUpdate() < 1) {
							throw new Exception("Did not create row");
						}
					}
				}
			}
			
			String insertProf = 
					"INSERT INTO Profile " +
				    		"VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			Timestamp creationDate		= Timestamp.from(Instant.now());
			Timestamp lastModDate		= Timestamp.from(Instant.now());
			
			try (PreparedStatement stmt = conn.prepareStatement(insertProf)) {
				
				stmt.setString(1, profileID);
				stmt.setString(2, ownerSSN);
				stmt.setInt(3, age);
				stmt.setInt(4, datingAgeRangeStart);
				stmt.setInt(5, datingAgeRangeEnd);
				stmt.setInt(6, datingGeoRange);
				stmt.setString(7, m_f);
				stmt.setBigDecimal(8, height);
				stmt.setInt(9, weight);
				stmt.setString(10, hairColor);
				stmt.setString(11, hobbies);
				stmt.setTimestamp(12, creationDate);
				stmt.setTimestamp(13, lastModDate);
				
				if (stmt.executeUpdate() < 1) {
					throw new Exception("Did not create row");
				}
			}
			conn.commit();
			
			HttpSession session = request.getSession(false);
			List<String> profiles = (List<String>) session.getAttribute("profiles");
			profiles.add(profileID);
			session.setAttribute("profiles", profiles);
			
			response.sendRedirect("/CSE_305/pubprof");
		}
		catch (Exception e) {
			e.printStackTrace();
			
			System.out.println("Failed to create profile");
		}
	}

}
