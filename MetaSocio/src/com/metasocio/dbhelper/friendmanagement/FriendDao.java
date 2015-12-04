package com.metasocio.dbhelper.friendmanagement;

import java.util.ArrayList;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.metasocio.dbhelper.commentmanagement.CommentDao;
import com.metasocio.exception.MetaSocioException;
import com.metasocio.model.friendsmanagement.Friend;
import com.metasocio.model.usermanagement.User;

public class FriendDao {
	private static FriendDao iFriendDao;

	private FriendDao() {

	}

	public static FriendDao getInstance() {

		/*if (iFriendDao == null) {*/
			iFriendDao = new FriendDao();

		/*}*/
		return iFriendDao;
	}
	
	public List<User> getUsersWhomYouAreNotFollowing(int userId, List<User> users,
			Session session) throws MetaSocioException {
		// Criteria criteria = session.createCriteria(Friends.class);
		List<User> usersList = new ArrayList<User>();
		Query query;
		for (User user : users) {
			/*
			 * query = session.createQuery("from  " + Friends.class +
			 * " where friend_one = ? And friend_two=?");
			 * query.setParameter("userId", userId);
			 * query.setParameter("friendId",user.getUser_id());
			 */

			System.out.println("id from crud" + user.getUserId());
			String hql = "from Friend f where f.friendOne =:userId and f.friendTwo=:friendId";
			query = session.createQuery(hql);
			query.setParameter("userId", userId);
			query.setParameter("friendId", user.getUserId());
			// Friends friend=(Friends) query.uniqueResult();
			if (query.uniqueResult() == null) {
				System.out.println("id match");
				usersList.add(user);
			} else {
				System.out.println("id not match");
			}

		}

		return usersList;
	}
	
	
	public void addFriend(Friend friend, Friend secondFriend,
			Session session) throws MetaSocioException {
		session.save(friend);
		
		session.save(secondFriend);
	}


}
