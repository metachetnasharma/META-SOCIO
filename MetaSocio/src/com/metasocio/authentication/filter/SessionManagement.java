package com.metasocio.authentication.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * Servlet Filter implementation class SessionManagement
 */
@WebFilter("/*")
public class SessionManagement implements Filter {
	private ServletContext context;

    /**
     * Default constructor. 
     */
    public SessionManagement() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("filter 1");
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		String uri = req.getRequestURI();
		
		this.context.log("Requested Resource::" + uri);
		HttpSession session = req.getSession(false);
		// System.out.println(session);
		if (session == null && (uri.endsWith("AddComment")
						|| uri.endsWith("AddFriend")
						|| uri.endsWith("LogOut")
						|| uri.endsWith("LikeManager")
						|| uri.endsWith("AddPost")
						|| uri.endsWith("HomePage")
						|| uri.endsWith("CreateUserProfile") 
						|| uri.endsWith("home.jsp")
						|| uri.endsWith("profile.jsp"))){
			this.context.log("Unauthorized access request");
			String message = "Unauthorized access request,Please Login first";
			request.setAttribute("message", message);
			
			request.getRequestDispatcher("index.jsp").forward(req, res);
		}  else {
			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		this.context = fConfig.getServletContext();
		this.context.log("AuthenticationFilter initialized");
	}

}
