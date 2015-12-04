package com.metasocio.controller.followermanagement;

import java.io.IOException;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.metasocio.exception.MetaSocioSystemException;
import com.metasocio.model.usermanagement.User;
import com.metasocio.service.followermanagement.FollowerService;
import com.metasocio.service.usermanagement.UserService;

/**
 * Servlet implementation class Unfollow
 */
@WebServlet("/Unfollow")
public class Unfollow extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Unfollow() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		User user = (User) session.getAttribute("userObject");
		UserService iUserService = new UserService();
		FollowerService iFollowerService=new FollowerService();
		int followerId;
		int followingId =(Integer.parseInt(request.getParameter("followingId"))) ;
	
		try {	
			followerId = user.getUserId();
			
			
			/*User follower = UserDao.getInstance().getUserById(followerId);
			
			User following=UserDao.getInstance().getUserById(followingId);
			Set<User> newSet = new HashSet<User>();
			newSet = follower.getUsers();
			newSet.remove(following);
			follower.setUsers(newSet);
			System.out.println(follower.getUsers());
			//follower.getUsers().remove(following);
*/			
			iFollowerService.removeFriend(followerId, followingId);
			
		    response.sendRedirect("Followings");						
		
		} catch (Exception e) {
		
			request.setAttribute("message","You can't unfollow the person");
			request.getRequestDispatcher("./exception/error.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
