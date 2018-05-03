import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
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
@WebServlet(urlPatterns = { "/profiles/edit/submit" })
public class EditProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	                        throws ServletException, IOException {
	    HttpSession session = request.getSession();
	    String login = (String)session.getAttribute("login");
	    
	    if (login == null) {
	        response.sendRedirect("/CSE_305/login.jsp");
	    }
	    else {
	        response.sendRedirect("/CSE_305/pubprof");
	    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	                        throws ServletException, IOException {
		String profileID = request.getParameter("profileID");
		
		Integer age = Integer.valueOf(request.getParameter("age"));
		Integer datingAgeRangeStart = Integer.valueOf(request.getParameter("datingAgeRangeStart"));
		Integer datingAgeRangeEnd = Integer.valueOf(request.getParameter("datingAgeRangeEnd"));
		Integer datingGeoRange = Integer.valueOf(request.getParameter("datingGeoRange"));
		String m_f = request.getParameter("m_f");
		BigDecimal height = new BigDecimal(request.getParameter("height"));
		Integer weight = Integer.valueOf(request.getParameter("weight"));
		String hairColor = request.getParameter("hairColor");
		String hobbies = request.getParameter("hobbies");
		
		String update = 
				"UPDATE Profile P " +
				"SET age = ?, datingAgeRangeStart = ?, datingAgeRangeEnd = ?, "
						+ "datingGeoRange = ?, m_f = ?, height = ?, "
						+ "weight = ?, hairColor = ?, hobbies = ? " +
				"WHERE profileID = ?";
		
		try (Connection conn = ConnUtil.getConnection(); 
				PreparedStatement stmt = conn.prepareStatement(update)) 
		{
			stmt.setInt(1, age);
			stmt.setInt(2, datingAgeRangeStart);
			stmt.setInt(3, datingAgeRangeEnd);
			stmt.setInt(4, datingGeoRange);
			stmt.setString(5, m_f);
			stmt.setBigDecimal(6, height);
			stmt.setInt(7, weight);
			stmt.setString(8, hairColor);
			stmt.setString(9, hobbies);
			stmt.setString(10, profileID);
			
			stmt.executeUpdate();
		}
		catch (Exception ex) {
			ex.printStackTrace();
			
			PrintWriter out = response.getWriter();
			out.println("<html>");
	        out.println("<head><title>Could not process</title></head>");
	 
	        out.println("<body>");
	 
	        out.println("<h3>Could not process your request</h3><br>");
	        
	        out.println("<a href = ../" + profileID + "> Return </a>");
	 
	        out.println("</body>");
	        out.println("<html>");
	        return;
		}
		
		response.sendRedirect("../" + profileID);
	}
}
