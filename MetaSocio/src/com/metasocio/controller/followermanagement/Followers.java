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
 * Servlet implementation class Followers
 */
@WebServlet("/Followers")
public class Followers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Followers() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {	HttpSession session=request.getSession(false);
		User user = (User) session.getAttribute("userObject");
	
		
		/*int id = iUserService.getIdByEmail(user.getEmailId());	*/
		int id=user.getUserId();
		/*User followingUser=UserDao.getInstance().getUserById(id);*/
		
		
		
		//User follower=UserDao.getInstance().getUserById(followerId);
		
		
		
		/*FriendService iFriendService=new FriendService();*/
		
		
		
		
		
		
		//User following=UserDao.getInstance().getUserById(followingId);
		
		//following.setUserId(followingId);
		//Set<User> followings = new HashSet<User>();
		//followings.add(following);		
		
			//follower.setUserId(followerId);
			//follower.setUsers(followings);
		FollowerService iFollowerService=new FollowerService();
		List<User> followersList = iFollowerService.getFollowers(user);
		
		UserService iUserService = new UserService();
	/*	List<User> userList = iUserService.getAllUsers();*/
			
			
			List<User> followersWhomYouAreNotFollowing = iFollowerService.getUsersWhomYouAreNotFollowing(user.getUserId(),followersList);
			System.out.println("In servlet "+followersList);
			
			
			request.setAttribute("followersWhomYouAreNotFollowing", followersWhomYouAreNotFollowing);
			request.setAttribute("usersList", followersList);
			
			request.setAttribute("listTitle", "Followers");
			request.getRequestDispatcher("./view/followermanagement/followers.jsp").forward(request, response);	
			/* HttpSession session=request.getSession(false);
			 session.setAttribute("userObject",user);*/
						
		//	request.getRequestDispatcher("./view/postmanagement/home.jsp").forward(request, response);
		} catch (MetaSocioSystemException e) {
			// TODO Auto-generated catch block
			//System.out.println("["+e.getMessage()+"]");
			request.setAttribute("message","Can't find followers");
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
