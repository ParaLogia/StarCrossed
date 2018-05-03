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

import beans.User;

@WebServlet(urlPatterns = { "/manager/allUsers" })
public class UserListServlet extends HttpServlet {
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
			String sql = "select * from User";
	
		    ResultSet rs;
		    try (Connection conn = ConnUtil.getConnection()){
		    	PreparedStatement query = conn.prepareStatement(sql);
	    	    rs = query.executeQuery();
	    	    
	    	    List<User> outputs = new ArrayList<User>();
	    	    
	    	    
	    	    
	    	    while (rs.next()) {
	    	    	User output = new User();
					output.setSsn(rs.getString("SSN"));
					output.setPpp(rs.getString("PPP"));
					output.setRating(rs.getInt("Rating"));
					output.setDateOfLastAct(rs.getTimestamp("DateOfLastAct"));
					outputs.add(output);
				}
				if(outputs.isEmpty()) {
					User output = new User();
					output.setSsn("No users advalible");
					outputs.add(output);
				}
				request.setAttribute("outputs", outputs);
				
				
				RequestDispatcher view = request.getRequestDispatcher("/allUsers.jsp");
				view.forward(request, response);
				ConnUtil.closeQuietly(conn);
	    	    
		    } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
        }

}
