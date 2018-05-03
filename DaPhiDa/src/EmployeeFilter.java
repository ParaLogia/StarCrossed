import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Does the opposite of EmployeeHomeFilter, letting employees through while non employees get routed
 * @author Darren Ling
 *
 */
@WebFilter(urlPatterns = { "/employee.jsp", "/employee/*"})
public class EmployeeFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		
		HttpSession session = request.getSession(false);
		
		if (session == null && session.getAttribute("emp") == null) {
			System.out.println("not employee");
			response.sendRedirect("/CSE_305/index.jsp");
		} else {
//			System.out.println("continue");
			arg2.doFilter(request, response);
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
