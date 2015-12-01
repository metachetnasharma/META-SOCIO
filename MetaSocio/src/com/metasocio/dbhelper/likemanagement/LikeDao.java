package com.metasocio.dbhelper.likemanagement;

import org.hibernate.Query;
import org.hibernate.Session;
import com.metasocio.exception.MetaSocioException;
import com.metasocio.model.likemanagement.Like;

/**
 * @author 
 * Since : 23 November, 2015
 * Description : This class is directly querying the database regarding likes on post to get the required information.
 */
public class LikeDao {
	private static LikeDao iLikeDao;		//Declaring static instance of class 

	/************************************
	 * Creating private constructor
	 ***********************************/
	private LikeDao() {	
		
	}							

	/****************************************************************
	 * This function is to create only single instance of this class, 
	 * if the instance already exists return the previous one
	 * and if instance is null create a new instance.
	 * 
	 * @return : Returning instance of this class
	 ************************************************************/
	public static LikeDao getInstance() {
		//Checking if instance already exists
		if (iLikeDao == null) {
			iLikeDao = new LikeDao(); 		//Creating instance of this class
		}
		return iLikeDao;		//Returning instance of this class
	}

	/**************************************************************
	 * This function is to save Like information
	 * in the database.Ex. Liker ID, post id etc.
	 * @param like : Setting data of POJO 'Like' in 
	 * 				 the related table.
	 * @param session : Creating a session to process 
	 *					query.
	 * @throws MetaSocioException : Throwing MetaSocioException
	 * 								if any exception occurs
	 **************************************************************/
	public void setLike(Like like, Session session)  throws MetaSocioException {
		session.save(like);			//Query to save 'Like' data in database
	}
	
	/***********************************************************************
	 * This function is to update 'isLiked' field in 'LikeCounter' table, if
	 * if user has already liked the post (isLiked = 0), then update the field to 
	 * Unlike (isLiked = 1) and vice-versa.
	 * 
	 * @param hasDeleted : This is the value which is to set in isLIkeed field. 
	 * @param userId & postId : These two parameters are making a unique combination
	 * 							on which field is to update.
	 * @param session : Creating a session to process 
	 *					query.
	 * @throws MetaSocioException : Throwing MetaSocioException
	 ***********************************************************************/
	public void updateIsLiked(int hasDeleted, int userId, int postId,
			Session session)  throws MetaSocioException {
		Query updateIsLiked = session.createQuery("UPDATE Like as lk SET lk.isLiked "
				+ "= "+ hasDeleted +" WHERE lk.postId = "+postId+" and lk.likerId=" + userId+""); 		//Preparing query to update required field
		updateIsLiked.executeUpdate();				//Executing updates		
	}
}
