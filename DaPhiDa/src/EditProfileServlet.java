import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Profile;

/**
 * this sets up the jsp file for editprof
 * @author Darren Ling
 *
 */
@WebServlet(urlPatterns = { "/editprof" })
public class EditProfileServlet extends HttpServlet {
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
	    HttpSession session = request.getSession();
	    
	    String email = (String) session.getAttribute("login");
	    //assume it won't be null since we run through a filter to get to this page
	    String sql = "Select prof.ProfileID " 
	    		+ "from profile prof, person per "
	    		+ "where per.Email = ? AND per.SSN = prof.OwnerSSN";
	    ResultSet s;
	    try (Connection conn = ConnUtil.getConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			s = ps.executeQuery();
			List<Profile> profiles = new ArrayList<Profile>();
			while (s.next()) {
				Profile profile = new Profile();
				profile.setProfileID(s.getString("ProfileID"));
				profiles.add(profile);
			}
			if(profiles.isEmpty()) {
				Profile profile = new Profile();
				profile.setProfileID("No Profiles Currently Found, Go make one!");
				profiles.add(profile);
			}
			session.setAttribute("profiles", profiles);
			RequestDispatcher view = request.getRequestDispatcher("editprof.jsp");
			view.forward(request, response);
			ConnUtil.closeQuietly(conn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	                        throws ServletException, IOException {
		doGet(request,response);
	}
}
