package com.metasocio.controller.postmanagement;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.metasocio.dbhelper.CRUD;
import com.metasocio.exception.MetaSocioSystemException;
import com.metasocio.model.postmanagement.PostManagement;
import com.metasocio.model.usermanagement.User;
import com.metasocio.service.MetaSocioService;
import com.sun.jmx.snmp.Timestamp;

/**
 * Servlet implementation class HomePage
 */
@WebServlet("/HomePage")
public class HomePage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HomePage() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		User user = new User();
		/*
		 * user.setName(name); user.setEmail_id(email); user.setPhone_No(phnNo);
		 * user.setDepartment(department); user.setRole(role);
		 * user.setProject_name(projectName); user.setImage_url(image);
		 * 
		 * java.util.Date date= new java.util.Date();
		 * 
		 * user.setCreated_at(date);
		 */

		System.out.println("*********************************in home");
		try {
			HttpSession session = request.getSession(false);
			user = (User) session.getAttribute("userObject");
			// CRUD crud=new CRUD();
			MetaSocioService iService = new MetaSocioService();
			// isService.setUserInfo(user);
			List<User> usersOfSamedepartment;

			int userId = iService.getIdByEmail(user.getEmail_id());
			user.setUser_id(userId);
			usersOfSamedepartment = iService
					.getUsersHavingSameDepartment(userId);
			request.setAttribute("userObject", user);
			request.setAttribute("usersList", usersOfSamedepartment);

			// boolean checkFriends = isService.checkFriends(id,friends)
			/*
			 * request.setAttribute("id",userId); request.setAttribute("email",
			 * email);
			 */
			System.out.println("in home page****************************");
		   List<PostManagement> postList = null;
		   postList = iService.retrievePostOnHome();
		   request.setAttribute("postList", postList);
			request.getRequestDispatcher("./view/postmanagement/home.jsp")
					.forward(request, response);
		} catch (MetaSocioSystemException e) {
			// TODO Auto-generated catch block
			System.out.println("[" + e.getMessage() + "]");
			request.setAttribute("message", "[" + e.getMessage() + "]");
			request.getRequestDispatcher("./exception/error.jsp").forward(
					request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		/*
		 * String name=request.getParameter("name"); String
		 * email=request.getParameter("email"); String
		 * phnNo=request.getParameter("phone"); String
		 * department=request.getParameter("department"); String
		 * role=request.getParameter("role"); String
		 * projectName=request.getParameter("projectName"); String
		 * image=request.getParameter("picture");
		 * System.out.println("image======="+image);
		 */
		User user = new User();
		/*
		 * user.setName(name); user.setEmail_id(email); user.setPhone_No(phnNo);
		 * user.setDepartment(department); user.setRole(role);
		 * user.setProject_name(projectName); user.setImage_url(image);
		 * 
		 * java.util.Date date= new java.util.Date();
		 * 
		 * user.setCreated_at(date);
		 */

		try {
			HttpSession session = request.getSession(false);
			user = (User) session.getAttribute("userObject");
			// CRUD crud=new CRUD();
			MetaSocioService iService = new MetaSocioService();
			// isService.setUserInfo(user);
			List<User> usersOfSamedepartment;

			int userId = iService.getIdByEmail(user.getEmail_id());
			user.setUser_id(userId);
			usersOfSamedepartment = iService
					.getUsersHavingSameDepartment(userId);
			request.setAttribute("userObject", user);
			request.setAttribute("usersList", usersOfSamedepartment);

			// boolean checkFriends = isService.checkFriends(id,friends)
			/*
			 * request.setAttribute("id",userId); request.setAttribute("email",
			 * email);
			 */
			System.out.println("in home page****************************");

			request.getRequestDispatcher("./view/postmanagement/home.jsp")
					.forward(request, response);
		} catch (MetaSocioSystemException e) {
			// TODO Auto-generated catch block
			System.out.println("[" + e.getMessage() + "]");
			request.setAttribute("message", "[" + e.getMessage() + "]");
			request.getRequestDispatcher("./exception/error.jsp").forward(
					request, response);
		}

	}

}
