import java.io.IOException;
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

import beans.SearchOut;

/**
 * Handles search function
 * @author Darren Ling
 *
 */
@WebServlet(urlPatterns = { "/search/submit" })
public class SearchServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	                        throws ServletException, IOException {
	    String searchType = request.getParameter("searchType");
	    String searchTerm = request.getParameter("searchTerm");
	    
	  //start queries here
	    String sql = "select ProfileID, Rating, DateOfLastAct, City, State, Height, Weight, HairColor "
	    		+ "from search "
	    		+ "where ";
	    		
	    //yeah this is a bit weird, but it's flexible
	    switch(searchType) {
	    	case "DateOfLastAct":
	    		//like search
	    		sql = sql + searchType + " like '%" + searchTerm + "%'";
	    		break;
	    		
	    	case "Rating":
	    		//we get exact
	    		sql = sql + searchType + " = " + searchTerm;
	    		break;
	    		
	    	case "City": case "State":
	    		//we can get this from person, like
	    		sql = sql + searchType + " like '%" + searchTerm + "%'";
	    		break;
	    		
	    	case "Height":  
	    		//we can get this from profile, range
	    		try {
	    			BigDecimal comp = new BigDecimal(searchTerm);
		    		BigDecimal comp2 = new BigDecimal("0.3");
		    		sql = sql + searchType + " between " + (comp.subtract(comp2)) + " and " + (comp.add(comp2));
	    		} catch (NumberFormatException e) {
	    			//type checking
	    			sql = sql + "false";
	    		}
	    		break;
	    		
	    	case "Weight":
	    		//we can get this from profile, different range
	    		try {
	    			Integer comp1 = Integer.parseInt(searchTerm);
		    		sql = sql + searchType + " between " + (comp1-20) + " and " + (comp1+20);
	    		} catch (NumberFormatException e) {
	    			//type checking
	    			sql = sql + "false";
	    		}
		    		
	    		break;
	    		
	    	case "HairColor":
	    		//we can get this from profile, exact
	    		sql = sql + searchType + " = '" + searchTerm + "'";
	    		break;
	    		
	    	case "ProfileID": default:
	    		//we can get this from profile, like
	    		sql = sql + searchType + " like '%" + searchTerm + "%'";
	    }
	    System.out.println(sql);
	    
	    ResultSet rs;
	    try (Connection conn = ConnUtil.getConnection()){
	    	PreparedStatement query = conn.prepareStatement(sql);
    	    rs = query.executeQuery();
    	    
    	    List<SearchOut> outputs = new ArrayList<SearchOut>();
    	    
    	    while (rs.next()) {
				SearchOut output = new SearchOut();
				output.setProfileId(rs.getString("ProfileID"));
				output.setRating(rs.getInt("Rating"));
				output.setDateOfLastAct(rs.getTimestamp("DateOfLastAct"));
				output.setCity(rs.getString("City"));
				output.setHairColor(rs.getString("HairColor"));
				output.setState(rs.getString("State"));
				output.setWeight(rs.getInt("Weight"));
				output.setHeight(rs.getBigDecimal("Height"));
				outputs.add(output);
			}
			if(outputs.isEmpty()) {
				SearchOut output = new SearchOut();
				output.setProfileId("No Profiles Currently Found, try a different search");
				outputs.add(output);
			}
			request.setAttribute("outputs", outputs);
			
			RequestDispatcher view = request.getRequestDispatcher("../searchResult.jsp");
			view.forward(request, response);
			ConnUtil.closeQuietly(conn);
    	    
	    } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	    
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	                        throws ServletException, IOException {
		doGet(request,response);        
	}
}
