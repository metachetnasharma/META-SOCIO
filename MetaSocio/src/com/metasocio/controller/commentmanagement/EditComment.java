package com.metasocio.controller.commentmanagement;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.metasocio.exception.MetaSocioSystemException;
import com.metasocio.service.commentmanagement.CommentService;
import com.metasocio.service.postmanagement.PostService;

/**
 * Servlet implementation class EditPost
 */
@WebServlet("/EditComment")
public class EditComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditComment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
System.out.println("in edit comment    ------------------------------");
		
		int commentId=Integer.parseInt(request.getParameter("commentId"));
		String commentDetails=request.getParameter("commentContent");
		 CommentService iCommentService=new CommentService();
	        
		try {
			iCommentService.editCommentByCommentId(commentId, commentDetails);
			response.setContentType("text/plain");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(commentDetails);
		} catch (MetaSocioSystemException e) {
			// TODO Auto-generated catch block
			request.setAttribute("message","Can't update the comment");
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
