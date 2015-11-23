package com.metasocio.controller.friendmanagement;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.metasocio.exception.MetaSocioSystemException;
import com.metasocio.model.friendsmanagement.Friends;
import com.metasocio.model.usermanagement.User;
import com.metasocio.service.MetaSocioService;

/**
 * Servlet implementation class AddFriend
 */
@WebServlet("/AddFriend")
public class AddFriend extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddFriend() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("********************************************add**************************");
		int userId =(Integer.parseInt(request.getParameter("userId"))) ;
		int friendId =(Integer.parseInt(request.getParameter("friendId"))) ;
		MetaSocioService iService=new MetaSocioService();
		Friends friend = new Friends();
		Friends secondFriend = new Friends();
		try {
			
			String userName = iService.getNameById(userId);
			java.util.Date date= new java.util.Date();
			friend.setCreated_at(date);
			secondFriend.setCreated_at(date);
			friend.setCreated_by(userName);
			secondFriend.setCreated_by(userName);
			friend.setUpdated_by(userName);
			secondFriend.setUpdated_by(userName);
			secondFriend.setCreated_by(userName);
			friend.setFriend_one(userId);
			secondFriend.setFriend_one(friendId);
			friend.setFriend_two(friendId);
			secondFriend.setFriend_two(userId);
			 iService.addFriend(friend,secondFriend);
			 
			// User user=new User();
			
			// HttpSession session=request.getSession(false);
			// session.setAttribute("userObject",user);
			 response.sendRedirect("HomePage");
			
			/*List<User> remainingUsersHavingSameDepartment = iService.getUsersHavingSameDepartment(userId);
			
			
			
			request.getRequestDispatcher("./view/postmanagement/home.jsp").forward(request, response);*/
		} catch (MetaSocioSystemException e) {
			// TODO Auto-generated catch block
			System.out.println("["+e.getMessage()+"]");
			request.setAttribute("message","["+e.getMessage()+"]");
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
