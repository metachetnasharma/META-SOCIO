package com.metasocio.controller.postmanagement;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.metasocio.exception.MetaSocioSystemException;
import com.metasocio.model.postmanagement.Post;
import com.metasocio.model.usermanagement.User;
import com.metasocio.service.MetaSocioService;
import com.metasocio.service.postmanagement.PostService;

/**
 * Servlet implementation class AddPost
 */
@WebServlet("/AddPost")
/**
 * Name:AddPost
 * @author Anurag,2015
 * Since:28 November
 * Description: Adds The post to the Home Page
 */
public class AddPost extends HttpServlet
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPost() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * Name: doGet
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * Description: Gets the request
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
	}

	/**
	 * Name: doPost
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * Description: Post the Data and Calls the Next servlet
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// Gets the Paramete From post 
		String post=request.getParameter("post");
		// INstance of user is created
		User user=new User();
		try 
		{
			// fetching the Details saved in the session of the Object
			HttpSession session =request.getSession(false);
			// getting the session
			user=(User) session.getAttribute("userObject");
			// Calling the service layer
			PostService iPostService=new PostService();
			Post newPost=new Post();
			//getting the userid from the session
			int userId = user.getUserId();
			
			
			
			/*Date date= new java.util.Date();*/
			
			
			
			// setting the date
			
			
			
			
			
			
			/*newPost.setDatePosted(date);*/
			
			
			
			// sets the user
			newPost.setUser(user);
			// sets post details
			newPost.setPostDetails(post);
			// sets likes
			
			
			/*newPost.setLikes(0);*/
			
			
			// gets the user details and share with  the created by and updated by
		
			
			
			/*String userName=user.getName();
			newPost.setCreatedBy(userName);
			newPost.setUpdatedBy(userName);*/
			
			
			// calling the function share post of the service layer
			iPostService.savePost(newPost);
			// redirect to the home psage
			response.sendRedirect("HomePage");
		} 
		catch (MetaSocioSystemException e) 
		{
			request.setAttribute("message","Can't share the post");
			request.getRequestDispatcher("./exception/error.jsp").forward(request, response);
		}
	}
}
