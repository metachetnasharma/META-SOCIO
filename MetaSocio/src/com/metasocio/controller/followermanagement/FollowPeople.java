package com.metasocio.controller.followermanagement;



import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import com.google.gson.Gson;
import com.metasocio.exception.MetaSocioSystemException;
import com.metasocio.model.usermanagement.User;
import com.metasocio.service.followermanagement.FollowerService;
import com.metasocio.service.usermanagement.UserService;

/**
 * Servlet implementation class FollowPeople
 */
@WebServlet("/FollowPeople")
public class FollowPeople extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FollowPeople() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("hi fffffffoooooooooooooollllllllllllllllllllooooooooooowwwwwwwwwwwwww");
		try {	int followerId;
			HttpSession session=request.getSession(false);
			System.out.println(session.getAttribute("userObject"));
			User follower = (User) session.getAttribute("userObject");
			
			followerId=follower.getUserId();
			System.out.println("userId and follower id"+followerId);
			
			UserService iUserService = new UserService();
			
			/*followerId = iUserService.getIdByEmail(user.getEmailId());*/
			
			
			int followingId =(Integer.parseInt(request.getParameter("followingId"))) ;
			System.out.println("userId and followingId id"+followingId);
			User following=iUserService.getUserById(followingId);
			
			/*User follower = UserDao.getInstance().getUserById(followerId);*/
			
			/*FriendService iFriendService=new FriendService();*/
			FollowerService iFollowerService=new FollowerService();
			
			Set<User> followingsSet = follower.getUsers();
			followingsSet.add(following);
			
			/*iFriendService.addFriend(follower);*/
			follower.setUsers(followingsSet);
			iFollowerService.addFollowing(follower);
			
			String title = (String) request.getParameter("title");
			if(title!=null){
				if(title.equalsIgnoreCase("Followers")){
					response.sendRedirect("Followers");
				}
			}
			else{
				System.out.println("else------------------------");
				List<User> usersOfSamedepartment = iUserService.getUsersHavingSameDepartment(follower);
				response.sendRedirect("HomePage");		
			
				
				
				
				/* JSONArray usersOfSamedepartmentJsonArray=JSONArray.fromObject(usersOfSamedepartment);
				 System.out.println("hi my data is "+ usersOfSamedepartmentJsonArray);
				 response.setContentType("application/json");
				 response.setCharacterEncoding("UTF-8");
				 response.getWriter().write(new Gson().toJson(usersOfSamedepartmentJsonArray));*/
										
			}
		} catch (MetaSocioSystemException e) {
		
			request.setAttribute("message","You can't follow the person");
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
