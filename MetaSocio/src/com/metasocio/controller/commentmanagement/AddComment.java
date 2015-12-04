package com.metasocio.controller.commentmanagement;

import java.io.IOException;
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
import com.metasocio.service.commentmanagement.CommentService;

/*************************************************************************************
 * This class provides control of comments, this Servlet implementation class
 * AddPost
 *************************************************************************************/
@WebServlet("/AddComment")
public class AddComment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddComment() {
		super();
	}

	/********************************************************************************
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 **********************************************************************************/
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	/**********************************************************************************
	 * This method provides control from Home Page to database that is getting
	 * comments from Home Page and saving these comments to database
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 ********************************************************************************/
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String comment = request.getParameter("comment");// getting parameter
															// from text area in
															// which comments is
															// coommented
		String postID = request.getParameter("postID");// getting postId, to get
														// on which post
														// commented
		System.out.println(comment + postID);
		User user = new User();
		try {
			HttpSession session = request.getSession(false);// getting http
															// session
			user = (User) session.getAttribute("userObject");
			CommentService iCommentService = new CommentService(); // getting
																	// object of
																	// CommentService
																	// class
			Comment newComment = new Comment();// creating object of Comment
												// class
			Post post = new Post();// creating object of Post class
			post.setPostId(Integer.parseInt(postID));// setting postId to object
														// of Post class named
														// post
			// setting information of comment to object of Comment class named
			// newComment
			newComment.setPost(post);
			newComment.setUser(user);
			newComment.setComments(comment);
			iCommentService.shareComment(newComment);// calling share method
														// existing in
														// CommentService
			response.sendRedirect("HomePage");// redirect to HomePage
		} catch (MetaSocioSystemException e) {
			request.setAttribute("message", "[" + e.getMessage() + "]");
			request.getRequestDispatcher("./exception/error.jsp").forward(
					request, response);
		}
	}
}
