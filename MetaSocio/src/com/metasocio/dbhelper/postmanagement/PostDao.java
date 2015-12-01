package com.metasocio.dbhelper.postmanagement;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.metasocio.dbhelper.friendmanagement.FriendDao;
import com.metasocio.exception.MetaSocioException;
import com.metasocio.model.postmanagement.Post;
import com.metasocio.model.usermanagement.User;
import com.metasocio.modelhelper.ImageHelper;
/**
 * Name: PostDao
 * @author : Anurag
 * Since: 28 November,2015
 * Description: Data base access object
 */
public class PostDao 
{
	private static PostDao iPostDao;

	private PostDao() 
	{

	}

	public static PostDao getInstance() 
	{
		// checks the object
		if (iPostDao == null) 
		{
			iPostDao = new PostDao();

		}
		return iPostDao;
	}
	/**
	 * Name: addPost
	 * @param newPost: post to be updated
	 * @param transaction: transaction to be updated
	 * @param session: session to be updated
	 * @throws MetaSocioException
	 */
	public void addPost(Post newPost, Transaction transaction,Session session) throws MetaSocioException
	{
		// save the data to the database
		session.saveOrUpdate(newPost);

	}
	/**
	 * Name: retrive post with Image
	 * @param transaction
	 * @param session
	 * @return
	 * @throws MetaSocioException
	 * Description: retrive image 
	 **/
	public List<Post> retrievePostWithImageOnHome(Transaction transaction,Session session) throws MetaSocioException
	{
		// Query with session to update
		Query query = session.createQuery("select pm.postId, pm.postDetails, pm.groupId, pm.datePosted, pm.likes,"
				+ "pm.updatedAt, pm.createdBy, pm.updatedBy, pm.isdelete, pm.user from Post pm order by pm.datePosted desc ");
		// getting the object with rows 
		List<Object[]> rows=query.list();
		// getting the post with image
		  List<Post> postsWithImage = new ArrayList<Post>();
		  //ImageHelper imageHelper = null;
		for (Object[] row: rows)
		{
			// sets the data to the post table
			Post post=new Post();
		    post.setPostId((int) row[0]);
		    post.setPostDetails((String)row[1]);
		    post.setGroupId((int)row[2]);
		    post.setDatePosted((Timestamp) row[3]);
		    post.setLikes((int) row[4]);
		    post.setUpdatedAt( (Timestamp) row[5]);
		    post.setCreatedBy((String) row[6]);
		    post.setUpdatedBy((String) row[7]);
		    post.setIsdelete((int) row[8]);
		    post.setUser((User) row[9]);
		    System.out.println(post.getUser().getUserId()+post.getUser().getImageURL()+"post"+post.getPostId()+"---------------------------------------");
		    postsWithImage.add(post);
		}
		// returns the list with post image
		return postsWithImage;
	}
	/**
	 * Name: incrementLikesOnPost
	 * @param postId
	 * @param transaction
	 * @param session
	 * @throws MetaSocioException
	 * Description: increments the likes on post
	 */
	public void incrementLikesOnPost(int postId,Session session) throws MetaSocioException
	{ 
		// Update like on post
		Query updateLikesOnPost = session.createQuery("UPDATE Post as pm SET pm.likes = pm.likes + 1 WHERE pm.postId = "+postId+"");
		updateLikesOnPost.executeUpdate();
	}
	/**
	 * Name: decrementLikesOnpost
	 * @param postId
	 * @param transaction
	 * @param session
	 * @throws MetaSocioException
	 */
	public void decrementLikesOnPost(int postId, Transaction transaction,Session session)  throws MetaSocioException 
	{
		// Descrement the likes on post
		Query updateLike = session.createQuery("UPDATE Post as pm SET pm.likes = pm.likes - 1 WHERE pm.postId = "+postId+"");
		updateLike.executeUpdate();
	}
}
