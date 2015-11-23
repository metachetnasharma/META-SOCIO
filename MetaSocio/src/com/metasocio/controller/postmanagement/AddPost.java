package com.metasocio.controller.postmanagement;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.metasocio.exception.MetaSocioSystemException;
import com.metasocio.model.postmanagement.PostManagement;
import com.metasocio.model.usermanagement.User;
import com.metasocio.service.MetaSocioService;

/**
 * Servlet implementation class AddPost
 */
@WebServlet("/AddPost")
public class AddPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPost() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in post******************************");
		String post=request.getParameter("post");
		User user=new User();
		
		
		System.out.println("*********************************in home");
		try {
			HttpSession session =request.getSession(false);
			user=(User) session.getAttribute("userObject");
			//CRUD crud=new CRUD();
			MetaSocioService iService=new MetaSocioService();
			//isService.setUserInfo(user);
			PostManagement newPost=new PostManagement();
			int userId = user.getUser_id();
			
			newPost.setUserId(userId);
			newPost.setPostDetails(post);
			newPost.setGroupId(2);
			java.util.Date date= new java.util.Date();
			newPost.setDatePosted(date);
			newPost.setLikes(0);
			newPost.setCreated_at(date);
			String userName=user.getName();
			newPost.setCreated_by(userName);
			newPost.setUpdated_by(userName);
			
			iService.sharePost(newPost);
			
			response.sendRedirect("HomePage");
			//request.getRequestDispatcher("./view/PostManagement/home.jsp").forward(request, response);
		} catch (MetaSocioSystemException e) {
			// TODO Auto-generated catch block
			System.out.println("["+e.getMessage()+"]");;
			request.setAttribute("message","["+e.getMessage()+"]");
			request.getRequestDispatcher("./exception/error.jsp").forward(request, response);
		}
			
		
	}

}
