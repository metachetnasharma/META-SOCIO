package com.metasocio.facade.postmanagement;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.metasocio.dbhelper.postmanagement.PostDao;
import com.metasocio.exception.MetaSocioException;
import com.metasocio.facade.commentmanagement.CommentFacade;
import com.metasocio.facade.likemanagement.LikeFacade;
import com.metasocio.model.postmanagement.Post;
import com.metasocio.modelhelper.ImageHelper;
/**
 * Name: PostFacade
 * @author Anurag
 * Since: 28 November,2015
 * Description: Facade Layer to Share post
 */
public class PostFacade 
{
	/**
	 * Name: SharePOst
	 * @param newPost
	 * @param transaction
	 * @param session
	 * @throws MetaSocioException
	 * Description: Shares post on the home Page
	 **/
	public void savePost(Post newPost, Session session)
			throws MetaSocioException 
	{
		// Gets the instance of the Dao
		PostDao iPostDao = PostDao.getInstance();
		// Adds the post And calls the addpost
		iPostDao.savePost(newPost, session);
	}

	/**
	 * Name:retrievePostWithImageOnHome
	 * @param transaction
	 * @param session
	 * @return
	 * @throws MetaSocioException
	 * Description:retrieve post from the Session
	 **/
	public List<Post> retrievePostWithImageOnHome(Session session) throws MetaSocioException 
	{
		// Gets the Instance of Dao 
		PostDao iPostDao = PostDao.getInstance();
		// Gets the ArrayList
		List<Post> postsWithImage = new ArrayList<Post>();
		postsWithImage = iPostDao.retrievePostWithImageOnHome(session);
		// Returns posts with image
		return postsWithImage;
	}
	/**
	 * Name: incrementLikesOn Post
	 * @param postId
	 * @param transaction
	 * @param session
	 * @throws MetaSocioException
	 * Description: Increments like on post and sends the link to Dao
	 */
	public void incrementLikesOnPost(int postId,
			Session session) throws MetaSocioException
	{
		// Gets the Instance 
		PostDao iPostDao = PostDao.getInstance();
		//dao is called
		iPostDao.incrementLikesOnPost(postId,session);
	}
	/**
	 * Name:decrementLikesOnPost
	 * @param postId
	 * @param transaction
	 * @param session
	 * @throws MetaSocioException
	 * Description:decrements likes on post
	 */
	public void decrementLikesOnPost(int postId,Session session)  throws MetaSocioException
	{
		// Gets the Instance
		PostDao iPostDao = PostDao.getInstance();
		// decrement likes on post
	    iPostDao.decrementLikesOnPost(postId,session);
	}

	public void deletePostByPostId(int postId, Session session) throws MetaSocioException {
		
				PostDao iPostDao = PostDao.getInstance();
				// decrement likes on post
			    iPostDao.deletePostByPostId(postId,session);
			    
			    CommentFacade iCommentFacade=new CommentFacade();
			    iCommentFacade.deleteCommentOnPost(postId,session);
			    
			    LikeFacade iLikeFacade=new LikeFacade();
			    iLikeFacade.deleteLikeOnPost(postId,session);
	}

	public void editPostByPostId(int postId, String postDetails, Session session) throws MetaSocioException {
		
		PostDao iPostDao = PostDao.getInstance();
		// decrement likes on post
	    iPostDao.editPostByPostId(postId,postDetails,session);
	    
	    
	}
}
