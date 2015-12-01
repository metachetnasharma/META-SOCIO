package com.metasocio.controller.commentmanagement;

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
import com.metasocio.model.commentmanagement.Comment;
import com.metasocio.model.postmanagement.Post;
import com.metasocio.model.usermanagement.User;
import com.metasocio.service.MetaSocioService;
import com.metasocio.service.commentmanagement.CommentService;

/**
 * Servlet implementation class AddPost
 */
@WebServlet("/AddComment")
public class AddComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddComment() {
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
		//System.out.println("in post******************************");
		String comment = request.getParameter("comment");
		String postID = request.getParameter("postID");
		System.out.println(comment + postID);
		User user=new User();
		
		
		//System.out.println("*********************************in home");
		try {
			HttpSession session =request.getSession(false);
			user=(User) session.getAttribute("userObject");
			//CRUD crud=new CRUD();
			//MetaSocioService iService=new MetaSocioService();
			CommentService iCommentService=new CommentService();
			//isService.setUserInfo(user);
			Comment newComment=new Comment();
			Date date= new java.util.Date();
			int userId = user.getUserId();
			Post post=new Post();
			//post.setCreatedAt(date);
			//user.setCreatedAt(date);
			post.setPostId(Integer.parseInt(postID));
			//newComment.setPostId(postId);
			//newComment.setPostId();
			newComment.setPost(post);
			//newComment.setUserId(userId);
			newComment.setUser(user);
			newComment.setComments(comment);
			//java.util.Date date= new java.util.Date();
			
			System.out.println("------------------comment date -----------------"+date);
			newComment.setDateCommented(date);
			//newComment.setCreatedAt(date);
			String userName=user.getName();
			newComment.setCreatedBy(userName);
			newComment.setUpdatedBy(userName);
			newComment.setIsdelete(0);
			
			iCommentService.shareComment(newComment);
			
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
