package com.metasocio.controller.followermanagement;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class Followings
 */
@WebServlet("/Followings")
public class Followings extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Followings() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
			
			HttpSession session=request.getSession(false);
			User user = (User) session.getAttribute("userObject");
					
			//User follower=UserDao.getInstance().getUserById(followerId);
			FollowerService iFollowerService=new FollowerService();
			UserService iUserService = new UserService();
			//User following=UserDao.getInstance().getUserById(followingId);
			
			//following.setUserId(followingId);
			//Set<User> followings = new HashSet<User>();
			//followings.add(following);
			try {			
			
				//follower.setUserId(followerId);
				//follower.setUsers(followings);
				int followerId = user.getUserId();
			
				//List<User> userList = iUserService.getAllUsers();
				List<User> followingsList = iFollowerService.getFollowings(followerId);
				request.setAttribute("listTitle", "Followings");
				request.setAttribute("usersList", followingsList);
				/* HttpSession session=request.getSession(false);
				 session.setAttribute("userObject",user);*/
				request.getRequestDispatcher("./view/followermanagement/followers.jsp").forward(request, response);				
			//	request.getRequestDispatcher("./view/postmanagement/home.jsp").forward(request, response);
			} catch (MetaSocioSystemException e) {
				// TODO Auto-generated catch block
				//System.out.println("["+e.getMessage()+"]");
				request.setAttribute("message","Can't find followings");
				request.getRequestDispatcher("./exception/error.jsp").forward(request, response);
	}}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
