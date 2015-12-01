package com.metasocio.authentication;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogOut
 */
@WebServlet("/LogOut")
public class LogOut extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogOut() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		if(session!=null){
			
			 response.setHeader("Cache-Control","no-cache");
			 response.setHeader("Cache-Control","no-store"); //Directs caches not to store the page under any circumstance
		      response.setDateHeader("Expires", 0);
		        response.setHeader("Pragma","no-cache"); 
		        session.invalidate();
		        //response.sendRedirect("home.jsp");
		//request.getRequestDispatcher("https://mail.google.com/mail/u/0/?logout&hl=en");
		/*request.getRequestDispatcher("index.jsp").forward(request, response);*/
		       /* response.sendRedirect("https://mail.google.com/mail/u/0/?logout&hl=en");*/
		        String message = "You have successfully logged out!";
				/*response.sendRedirect("./view/Vehicle.jsp?message="
						+ URLEncoder.encode(message, "UTF-8"));*/
		        response.sendRedirect("https://www.google.com/accounts/Logout?continue=https://appengine.google.com/_ah/logout?continue=http://localhost:8080/MetaSocio/&message="
		        		+URLEncoder.encode(message, "UTF-8"));
		       // request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
