

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

import beans.Likes;
import beans.Profile;

/**
 * Servlet implementation class ProfileServlet
 */
@WebServlet(urlPatterns = { "/likes/*" })
public class LikesServlet extends HttpServlet {
	 static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LikesServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String urlStub = "/likes/";
		String requestURI = request.getRequestURI();
		String profileID = requestURI.substring(requestURI.indexOf(urlStub) + urlStub.length());
		
		// Check if owner
		HttpSession session = request.getSession();
		List<String> profiles = (List<String>) session.getAttribute("profiles");
		
		if (session.getAttribute("emp") == null && !profiles.contains(profileID)) {
			response.sendRedirect("/CSE_305/pubprof");
			return;
		}
		List<Likes> likes = new ArrayList<>();
		
		try (Connection conn = ConnUtil.getConnection()) {
			conn.setAutoCommit(false);
			
			String profQuery = 
					"SELECT L.Likee, L.Date_Time " +
					"FROM Likes L " +
					"WHERE L.Liker = ?";
			
			try (PreparedStatement profStmt = conn.prepareStatement(profQuery)) {
				profStmt.setString(1, profileID);
				ResultSet rs = profStmt.executeQuery();

				// Create list of likes beans
				while (rs.next()) {
					String likee = rs.getString("likee");
					Timestamp date_time = rs.getTimestamp("date_time");
					
					Likes like = new Likes(profileID, likee, date_time);
					likes.add(like);
				}
			}
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}

		// Attach likes to request
		request.setAttribute("profile", profileID);
		request.setAttribute("likes", likes);

		// Pass request to jsp
		RequestDispatcher view = request.getRequestDispatcher("/likelist.jsp");
		view.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
