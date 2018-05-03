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

import beans.Date;

@WebServlet(urlPatterns = { "/employee/recordReceipt" })
public class RecordReceiptListServlet extends HttpServlet {
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
			
		    String sql = "select * from date";

		    ResultSet rs;
		    try (Connection conn = ConnUtil.getConnection()){
		    	PreparedStatement query = conn.prepareStatement(sql);
	    	    rs = query.executeQuery();
	    	    
	    	    List<Date> dates = new ArrayList<Date>();
	    	    
	    	    while (rs.next()) {
					Date output = new Date();
					output.setProfile1(rs.getString("Profile1"));
					output.setProfile2(rs.getString("Profile2"));
					output.setCustRep(rs.getString("CustRep"));
					output.setDateTime(rs.getTimestamp("Date_Time"));
					output.setLocation(rs.getString("Location"));
					output.setBookingFee(rs.getBigDecimal("BookingFee"));
					output.setComments(rs.getString("Comments"));
					output.setUser1Rating(rs.getInt("User1Rating"));
					output.setUser2Rating(rs.getInt("User2Rating"));
					dates.add(output);
				}
				if(dates.isEmpty()) {
					Date output = new Date();
					output.setProfile1("No dates advalible");
					dates.add(output);
				}
				request.setAttribute("dates", dates);
				
				
				RequestDispatcher view = request.getRequestDispatcher("/recordReceipt.jsp");
				view.forward(request, response);
				ConnUtil.closeQuietly(conn);
	    	    
		    } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
        }

}
