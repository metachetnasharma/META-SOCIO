package com.metasocio.facade.commentmanagement;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.metasocio.dbhelper.CRUD;
import com.metasocio.dbhelper.commentmanagement.CommentDao;
import com.metasocio.dbhelper.postmanagement.PostDao;
import com.metasocio.exception.MetaSocioException;
import com.metasocio.model.commentmanagement.Comment;
import com.metasocio.modelhelper.ImageHelper;

public class CommentFacade {
	public void shareComment(Comment newComment,
			Transaction transaction, Session session) throws MetaSocioException {
		//CRUD iCrud = CRUD.getInstance();
		CommentDao iCommentDao=CommentDao.getInstance();
		iCommentDao.addComment(newComment,transaction,session);
		
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

	public List<Comment> retrieveCommentListWithImageByPostID(int postId,
			Transaction transaction, Session session) throws MetaSocioException {
		CommentDao iCommentDao = CommentDao.getInstance();
		List<Comment> commentsWithImage = new ArrayList<Comment>();
		commentsWithImage = iCommentDao.retrieveCommentListWithImageByPostID(postId, transaction,
				session);
		return commentsWithImage;
	}
}
