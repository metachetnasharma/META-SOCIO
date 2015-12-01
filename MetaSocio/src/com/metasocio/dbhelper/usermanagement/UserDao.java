package com.metasocio.dbhelper.usermanagement;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.metasocio.dbhelper.postmanagement.PostDao;
import com.metasocio.exception.MetaSocioException;
import com.metasocio.model.usermanagement.User;

public class UserDao {
	private static UserDao iUserDao;

	private UserDao() {

	}

	public static UserDao getInstance() {

		if (iUserDao == null) {
			iUserDao = new UserDao();

		}
		return iUserDao;
	}
	
	public void setUserInfo(User user, Transaction transaction, Session session)
			throws MetaSocioException {
		session.save(user);
	}

	public String getDepartment(int userId, Transaction transaction,
			Session session) throws MetaSocioException {
		Criteria criteria = session.createCriteria(User.class);

		criteria.add(Restrictions.eq("userId", userId));
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
		criteria.add(Restrictions.eq("emailId", email));
		User user = new User();
		user = (User) criteria.uniqueResult();
		int id = user.getUserId();
		// System.out.println("*******************************department="+department);
		return id;

	}

	public String getNameById(int userId, Transaction transaction,
			Session session) throws MetaSocioException {
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("userId", userId));
		User user = new User();
		user = (User) criteria.uniqueResult();
		String userName = user.getName();
		return userName;
	}

	public String getImageById(int userId, Transaction transaction,
			Session session) throws MetaSocioException {
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("userId", userId));
		User user = new User();
		user = (User) criteria.uniqueResult();
		String userImage = user.getImageURL();
		return userImage;
	}
	
}

