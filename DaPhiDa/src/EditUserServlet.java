import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.User;

@WebServlet(urlPatterns = {"*.editUserCheck"})
public class EditUserServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		String[] tokens = requestURI.split(":",3);
		String ssn = tokens[1];
		
		User output = new User();
		try (Connection conn = ConnUtil.getConnection()) {			
			String profQuery = 
					"SELECT * " +
					"FROM User x " +
					"WHERE x.ssn = ?";
			
			try (PreparedStatement profStmt = conn.prepareStatement(profQuery)) {
				profStmt.setString(1, ssn);
				ResultSet rs = profStmt.executeQuery();
				
				if (rs.next()) {
					//only 1 element
					output.setSsn(rs.getString("SSN"));
					output.setPpp(rs.getString("PPP"));
					output.setRating(rs.getInt("Rating"));
					output.setDateOfLastAct(rs.getTimestamp("DateOfLastAct"));
				}
			}
			catch (Exception ex) {
				System.out.println("Error1");
				ex.printStackTrace();
			}
		}
		catch (Exception ex) {
			System.out.println("Error2");
			ex.printStackTrace();
		}
		request.setAttribute("users", output);
		
		RequestDispatcher view = request.getRequestDispatcher("/editUsers.jsp");
		view.forward(request, response);
		
	}

}
