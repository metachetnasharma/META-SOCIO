package com.metasocio.controller.commentmanagement;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.metasocio.exception.MetaSocioSystemException;
import com.metasocio.service.commentmanagement.CommentService;

/**
 * Servlet implementation class DeleteComment
 */
@WebServlet("/DeleteComment")
public class DeleteComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteComment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 int commentId=Integer.parseInt(request.getParameter("commentId"));
		 CommentService iCommentService=new CommentService();
		 try {
			iCommentService.deleteCommentByCommentId(commentId);
			response.sendRedirect("HomePage");
		} catch (MetaSocioSystemException e) {
			// TODO Auto-generated catch block
			String errorMessage="Can't delete comment";
			request.setAttribute("message",errorMessage);
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
