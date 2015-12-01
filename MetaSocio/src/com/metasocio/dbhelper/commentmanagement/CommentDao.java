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

public class CommentDao {
	private static CommentDao iCommentDao;

	private CommentDao() {

	}

	public static CommentDao getInstance() {

		if (iCommentDao == null) {
			iCommentDao = new CommentDao();

		}
		return iCommentDao;
	}
	
	public void addComment(Comment newComment,
			Transaction transaction, Session session) throws MetaSocioException {
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

	public List<Comment> retrieveCommentListWithImageByPostID(int postId,
			Transaction transaction, Session session) throws MetaSocioException {
		Query query = session.createQuery("select cm.commentId, cm.comments, cm.dateCommented, cm.updatedAt, cm.createdBy,"
				+ "cm.updatedBy, cm.isdelete, cm.user from Comment cm where cm.post.postId=:id order by cm.dateCommented desc");
		query.setInteger("id",postId);
		List<Object[]> rows=query.list();
		 System.out.println("row:::::::::::::::::::::"+rows);
		  List<Comment> commentsWithImage = new ArrayList<Comment>();
		  
		  //ImageHelper imageHelper = null;
		for (Object[] row: rows) {
			//ImageHelper imageHelper = new ImageHelper();
			Comment comment = new Comment();
		    System.out.println(" ------------------- ");
		    //(Integer) resultSet.getObject("foo");
		    comment.setCommentId((int) row[0]);
		    comment.setComments((String)row[1]);
		    comment.setDateCommented((Date) row[2]);
		  //  comment.setCreatedAt((Date) row[3]);
		    comment.setUpdatedAt( (Timestamp) row[3]);
		    comment.setCreatedBy((String) row[4]);
		    comment.setUpdatedBy((String) row[5]);
		    comment.setIsdelete((int) row[6]);
		   // imageHelper.setComment(comment);
		    comment.setUser((User) row[7]);
		   // comment=imageHelper.getComment();
		    System.out.println(comment.getUser().getUserId()+comment.getUser().getImageURL()+"post"+comment.getCommentId()+"---------------------------------------");
		    commentsWithImage.add(comment);
		    //System.out.println(imageHelper);
		  // System.out.println(row[0]);
		   //System.out.println(row[1]);
		}
		return commentsWithImage;
	}

}
