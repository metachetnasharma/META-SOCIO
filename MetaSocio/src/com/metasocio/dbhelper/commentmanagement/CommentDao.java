package com.metasocio.dbhelper.commentmanagement;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;









import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.metasocio.dbhelper.CRUD;
import com.metasocio.exception.MetaSocioException;
import com.metasocio.model.commentmanagement.Comment;
import com.metasocio.model.postmanagement.Post;
import com.metasocio.model.usermanagement.User;
import com.metasocio.modelhelper.ImageHelper;
/****************************************************************************
 * Name: PostDao
 * @author : 
 * Since: 28 November,2015
 * Description: This class is directly querying the database regarding 
 * comments on post to get the required information.
 ****************************************************************************/
public class CommentDao {
	private static CommentDao iCommentDao; //making static instance of class 
	/**
	 * Creating private constructor
	 */
	private CommentDao() {

	}
	/****************************************************************
	* This function is to create single instance of this class, 
	* if the instance already exists return the previous one
	* and if instance is null create a new instance.
	* 
	* @return : Returning instance of this class
	************************************************************/
	public static CommentDao getInstance() {

	/*	if (iCommentDao == null) {*/
			iCommentDao = new CommentDao();

	/*	}*/
		return iCommentDao;//Returning instance of this class
	}
	/*************************************************************
	 * This function is to save comment information in the database
	 * @param newComment
	 * @param transaction
	 * @param session
	 * @throws MetaSocioException
	 ************************************************************/
	public void addComment(Comment newComment,
			 Session session) throws MetaSocioException {
		session.save(newComment);	
	}
	
	/*public List<Comment> retrieveCommentListByPostID(int post_ID, Transaction transaction,
			Session session) {
		String hql = "FROM Comment WHERE postId="+post_ID +" order by createdAt desc";
		Query query = session.createQuery(hql);
		List<Comment> commentList = query.list();
		for(Comment comment : commentList){
			System.out.println("Crud Comments " + comment.getComments());
		}
		return commentList;
	}*/

	
	/**************************************************************
	 * This function is to retrieve comment list with image on home 
	 * page from the database
	 * @param postId
	 * @param transaction
	 * @param session
	 * @return list of comments with user's image whom commented
	 * @throws MetaSocioException
	 **************************************************************/
	public List<Comment> retrieveCommentListWithImageByPostID(int postId,
			Session session) throws MetaSocioException {
	
		// query to retrieve comments from comment table
		Query query = session.createQuery("select cm.commentId, cm.comments, cm.dateCommented, cm.updatedAt, cm.createdBy,"
				+ "cm.updatedBy, cm.isDelete, cm.user from Comment cm where cm.post.postId=:id AND cm.isDelete=:isdelete order by cm.dateCommented desc");
		query.setInteger("id",postId);
		query.setInteger("isdelete",0);
		List<Object[]> rows=query.list();
		 System.out.println("row:::::::::::::::::::::"+rows);
		 
		//declaration of array list named commentsWithImage 
		  List<Comment> commentsWithImage = new ArrayList<Comment>();
		  
		  //ImageHelper imageHelper = null;
		for (Object[] row: rows) {
			//ImageHelper imageHelper = new ImageHelper();
			
			// Creating object of Comment class
			Comment comment = new Comment();
		    System.out.println(" ------------------- ");
		    //(Integer) resultSet.getObject("foo");
		    
		 // Setting comment information in comment object
		    comment.setCommentId((int) row[0]);
		    comment.setComments((String)row[1]);
		    comment.setDateCommented((Date) row[2]);
		  //  comment.setCreatedAt((Date) row[3]);
		    comment.setUpdatedAt( (Timestamp) row[3]);
		    comment.setCreatedBy((String) row[4]);
		    comment.setUpdatedBy((String) row[5]);
		    comment.setIsDelete((int) row[6]);
		   // imageHelper.setComment(comment);
		    comment.setUser((User) row[7]);
		   // comment=imageHelper.getComment();
		    System.out.println(comment.getUser().getUserId()+comment.getUser().getImageURL()+"post"+comment.getCommentId()+"---------------------------------------");
		    
		  //adding this object to list commentsWithImage
		    commentsWithImage.add(comment);
		    //System.out.println(imageHelper);
		  // System.out.println(row[0]);
		   //System.out.println(row[1]);
		}
		return commentsWithImage;
	}

	public void deleteCommentOnPost(int postId, Session session) throws MetaSocioException  {
		Query deleteCommentOnPost = session.createQuery("UPDATE Comment as c SET c.isDelete "
				+ "= "+ 1 +" WHERE c.post.postId = "+postId+""); 		//Preparing query to update required field
		deleteCommentOnPost.executeUpdate();	
		
	}

	public void deleteCommentByCommentId(int commentId, Session session) throws MetaSocioException {
		Query deleteCommentByCommentId = session.createQuery("UPDATE Comment as c SET c.isDelete "
				+ "= "+ 1 +" WHERE c.commentId = "+commentId+""); 		//Preparing query to update required field
		deleteCommentByCommentId.executeUpdate();	
	}

	public void editCommentByCommentId(int commentId, String commentDetails, Session session) throws MetaSocioException {
		Query editCommentByCommentId = session.createQuery("UPDATE Comment as c SET c.comments=:comments WHERE c.commentId = "+commentId+""); 		//Preparing query to update required field
		editCommentByCommentId.setString("comments", commentDetails);
		editCommentByCommentId.executeUpdate();	
		
	}

}
