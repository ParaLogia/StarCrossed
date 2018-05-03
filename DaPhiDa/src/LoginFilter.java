import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.*;

/**
 * Filter to make sure the user is logged when accessing certain pages
 * 
 * Simply checks if login attribute is empty or not.
 * @author Darren Ling
 *
 */
@WebFilter(urlPatterns = { "/editprof", "/pubprof", "/search.jsp",
		"/profiles/*", "/likes/*", "/dates/*"})
public class LoginFilter implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws ServletException, IOException {
		
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		
		HttpSession session = request.getSession(false);
		
		if (session == null || session.getAttribute("login") == null) {
			System.out.println("invalid session");
			response.sendRedirect("/CSE_305/login.jsp");
		} else {
//			System.out.println("continue");
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

	// ...
}