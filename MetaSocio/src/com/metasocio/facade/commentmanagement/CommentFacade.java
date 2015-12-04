package com.metasocio.facade.commentmanagement;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.metasocio.dbhelper.CRUD;
import com.metasocio.dbhelper.commentmanagement.CommentDao;
import com.metasocio.dbhelper.postmanagement.PostDao;
import com.metasocio.exception.MetaSocioException;
import com.metasocio.facade.likemanagement.LikeFacade;
import com.metasocio.model.commentmanagement.Comment;
import com.metasocio.modelhelper.ImageHelper;
/***************************************************************************
 * Name: CommentFacade
 * @author Since: 28 November,2015 
 * Description: Facade Layer to Comment on post
 **************************************************************************/
public class CommentFacade {
	

	/************************************************************************
	 * Name : ShareComment
	 * @param newComment
	 * @param transaction
	 * @param session
	 * @throws MetaSocioException
	 * Description: Save comments on a post in database
	 ***********************************************************************/
	public void shareComment(Comment newComment,
			Session session) throws MetaSocioException {
		//CRUD iCrud = CRUD.getInstance();
		
		// Gets the instance of the Dao
		CommentDao iCommentDao=CommentDao.getInstance();
		
		// Calling method addComment existing in CommentDao class
		iCommentDao.addComment(newComment,session);
		
	}
	
/*	public List<Comment> retrieveCommentListByPostID(int postID, Transaction transaction,Session session) throws MetaSocioException {
		
		//CRUD iCrud = CRUD.getInstance();
		CommentDao iCommentDao=CommentDao.getInstance();
		List<Comment> commentList=iCommentDao.retrieveCommentListByPostID(postID, transaction,session);
		for(Comment comment : commentList){
			System.out.println("Facade Comments " + comment.getComments());
		}
		return commentList;
		
	}*/

	
	/**************************************************************************
	 * Name : retrieveCommentListWithImageByPostID
	 * @param postId
	 * @param transaction
	 * @param session
	 * @return list of comments with images
	 * @throws MetaSocioException
	 * Description:retrieve comments on home page
	 *****************************************************************************/
	public List<Comment> retrieveCommentListWithImageByPostID(int postId,
			 Session session) throws MetaSocioException {
		// Gets the Instance of Dao
		CommentDao iCommentDao = CommentDao.getInstance();// Get comments with image in the ArrayList
		List<Comment> commentsWithImage = new ArrayList<Comment>();
		commentsWithImage = iCommentDao.retrieveCommentListWithImageByPostID(postId,
				session);// Calling retrieveCommentListWithImageByPostID method existing in CommentDao class
		return commentsWithImage;
	}

	public void deleteCommentOnPost(int postId, Session session)  throws MetaSocioException {
		CommentDao iCommentDao = CommentDao.getInstance();
		
		iCommentDao.deleteCommentOnPost(postId,session);;
		
	}

	public void deleteCommentByCommentId(int commentId, Session session) throws MetaSocioException {
		
		CommentDao icoCommentDao = CommentDao.getInstance();
		// decrement likes on post
		icoCommentDao.deleteCommentByCommentId(commentId,session);
	    
	   /* CommentFacade iCommentFacade=new CommentFacade();
	    iCommentFacade.deleteCommentOnPost(postId,session);
	    
	    LikeFacade iLikeFacade=new LikeFacade();
	    iLikeFacade.deleteLikeOnPost(postId,session);*/
	}

	public void editCommentByCommentId(int commentId, String commentDetails, Session session)throws MetaSocioException {
		
		CommentDao icoCommentDao = CommentDao.getInstance();
		// decrement likes on post
		icoCommentDao.editCommentByCommentId(commentId,commentDetails,session);
		
	}
}
