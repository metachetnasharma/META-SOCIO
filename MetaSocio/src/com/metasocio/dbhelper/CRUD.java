package com.metasocio.dbhelper;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.metasocio.exception.MetaSocioException;
import com.metasocio.model.friendsmanagement.Friends;
import com.metasocio.model.postmanagement.PostManagement;
import com.metasocio.model.usermanagement.User;

public class CRUD {
	private static CRUD iCrud;

	private CRUD() {

	}

	public static CRUD getInstance() {

		if (iCrud == null) {
			iCrud = new CRUD();

		}
		return iCrud;
	}

	public void setUserInfo(User user, Transaction transaction, Session session)
			throws MetaSocioException {
		session.save(user);
	}

	public String getDepartment(int userId, Transaction transaction,
			Session session) throws MetaSocioException {
		Criteria criteria = session.createCriteria(User.class);

		criteria.add(Restrictions.eq("user_id", userId));
		User user = new User();
		user = (User) criteria.uniqueResult();
		String department = user.getDepartment();
		// System.out.println("*******************************department="+department);
		return department;

	}

	public List<User> getUsersHavingSameDepartment(String department,
			Transaction transaction, Session session) throws MetaSocioException {

		Criteria criteria = session.createCriteria(User.class);

		criteria.add(Restrictions.eq("department", department));
		User user = new User();
		List<User> usersList = new ArrayList<User>();
		usersList = criteria.list();
		// System.out.println("__________________________________*******************"+friendList);
		return usersList;

	}

	public int getIdByEmail(String email, Transaction transaction,
			Session session) throws MetaSocioException {
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("email_id", email));
		User user = new User();
		user = (User) criteria.uniqueResult();
		int id = user.getUser_id();
		// System.out.println("*******************************department="+department);
		return id;

	}

	public List<User> getUsersWhoAreNotFriends(int userId, List<User> users,
			Transaction transaction, Session session) throws MetaSocioException {
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

			System.out.println("id from crud" + user.getUser_id());
			String hql = "from Friends f where f.friend_one =:userId and f.friend_two=:friendId";
			query = session.createQuery(hql);
			query.setParameter("userId", userId);
			query.setParameter("friendId", user.getUser_id());
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

	public String getNameById(int userId, Transaction transaction,
			Session session) throws MetaSocioException {
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("user_id", userId));
		User user = new User();
		user = (User) criteria.uniqueResult();
		String userName = user.getName();
		return userName;
	}

	public void addFriend(Friends friend, Friends secondFriend,
			Transaction transaction, Session session) throws MetaSocioException {
		session.save(friend);
		session.save(secondFriend);
	}

	public void addPost(PostManagement newPost, Transaction transaction,
			Session session) throws MetaSocioException {
		session.save(newPost);

	}

	public List retrievePostOnHome(Transaction transaction, Session session) {
		String hql = "FROM PostManagement order by created_at desc";
		Query query = session.createQuery(hql);
		List<PostManagement> postList = query.list();
		for (int i = 0; i < postList.size(); i++) {
			System.out.println(postList.get(i).getPostDetails());
			

		}
		return postList;

	}
}
