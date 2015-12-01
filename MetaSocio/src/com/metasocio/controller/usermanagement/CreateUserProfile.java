package com.metasocio.controller.usermanagement;

import java.io.IOException;




import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.naming.java.javaURLContextFactory;

import com.metasocio.exception.MetaSocioSystemException;
import com.metasocio.model.usermanagement.User;
import com.metasocio.service.MetaSocioService;
import com.metasocio.service.usermanagement.UserService;

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
		String address=request.getParameter("address");
		String phnNo=request.getParameter("phoneNumber");
		String city=request.getParameter("city");
		String department=request.getParameter("department");
		String role=request.getParameter("role");
		String college=request.getParameter("college");
		String course=request.getParameter("course");
		String highSchool=request.getParameter("highSchool");
		String stream=request.getParameter("stream");
		String dobString=request.getParameter("dateOfBirth");
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("MM/dd/yyyy");
		Date dob = null;
		if(dobString!=null){
		try {
		
				dob = simpleDateFormat.parse(dobString);
				System.out.println(dob+"dob");
			}
		 catch (ParseException e1) {
			// TODO Auto-generated catch block
			System.out.println(e1.getMessage());
		}
		}
		String gender=request.getParameter("gender");
		String about=request.getParameter("about");
		String nickName=request.getParameter("nickName");
		String relationshipStatus=request.getParameter("relationship");
		String image=request.getParameter("picture");
		//System.out.println("image======="+image);
		User user=new User();
		user.setName(name);
		user.setEmailId(email);
		user.setAddress(address);
		user.setPhoneNo(phnNo);
		user.setCity(city);
		user.setDepartment(department);
		user.setRole(role);
        user.setCollege(college);
        user.setCourse(course);
        user.setHighSchool(highSchool);
        user.setStream(stream);
        user.setDateOfBirth(dob);
        user.setGender(gender);
        user.setAbout(about);
        user.setNickName(nickName);
        user.setRelationshipStatus(relationshipStatus);
		user.setImageURL(image);
		
		Date date= new Date();
		
		user.setCreatedAt(date);
		//CRUD crud=new CRUD();
	//MetaSocioService iService=new MetaSocioService();
		UserService iUserService=new UserService();
		try {
			iUserService.setUserInfo(user);
			HttpSession session=request.getSession(false);
			session.setAttribute("userObject",user);
			response.sendRedirect("HomePage");
			//request.getRequestDispatcher("./view/PostManagement/home.jsp").forward(request, response);
		} catch (MetaSocioSystemException e) {
			// TODO Auto-generated catch block
			//System.out.println("["+e.getMessage()+"]");;
			request.setAttribute("message","["+e.getMessage()+"]");
			request.getRequestDispatcher("./exception/error.jsp").forward(request, response);
		}
	}

}
