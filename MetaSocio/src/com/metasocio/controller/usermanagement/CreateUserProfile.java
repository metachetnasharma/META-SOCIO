package com.metasocio.controller.usermanagement;

import java.io.IOException;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.metasocio.exception.MetaSocioSystemException;
import com.metasocio.model.usermanagement.User;
import com.metasocio.service.MetaSocioService;

/**
 * Servlet implementation class CreateUserProfile
 */
@WebServlet("/CreateUserProfile")
public class CreateUserProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateUserProfile() {
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
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String phnNo=request.getParameter("phone");
		String department=request.getParameter("department");
		String role=request.getParameter("role");
		String projectName=request.getParameter("projectName");
		String image=request.getParameter("picture");
		System.out.println("image======="+image);
		User user=new User();
		user.setName(name);
		user.setEmail_id(email);
		user.setPhone_No(phnNo);
		user.setDepartment(department);
		user.setRole(role);
		user.setProject_name(projectName);
		user.setImage_url(image);
		
		java.util.Date date= new java.util.Date();
		
		user.setCreated_at(date);
		//CRUD crud=new CRUD();
	MetaSocioService iService=new MetaSocioService();
		try {
			iService.setUserInfo(user);
			HttpSession session=request.getSession(false);
			session.setAttribute("userObject",user);
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
