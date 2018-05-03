import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.*;

/**
 * checks if you are logged in. If you are there will be an option to logout
 * @author Darren Ling
 *
 */
@WebFilter(urlPatterns = { "/login.jsp"} )
public class LogoutFilter implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws ServletException, IOException {
		
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		
		HttpSession session = request.getSession(false);
		
		if (session != null && session.getAttribute("login") != null) {
			System.out.println("logged in, redirecting to logout");
			response.sendRedirect("/CSE_305/logout.jsp");
		} else {
			System.out.println("proceed to login page");
			chain.doFilter(request, response);
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
}