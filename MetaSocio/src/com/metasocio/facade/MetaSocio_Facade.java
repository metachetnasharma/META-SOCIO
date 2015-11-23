package com.metasocio.facade;


import java.util.List;





import org.hibernate.Session;
import org.hibernate.Transaction;

import com.metasocio.dbhelper.CRUD;
import com.metasocio.dbhelper.ValidateUser;
import com.metasocio.exception.MetaSocioException;
import com.metasocio.model.friendsmanagement.Friends;
import com.metasocio.model.postmanagement.PostManagement;
import com.metasocio.model.usermanagement.User;
import com.sun.org.apache.regexp.internal.recompile;

public class MetaSocio_Facade {

	public boolean isEmailExists(String email, Transaction transaction,Session session) throws MetaSocioException {
		boolean isUserExists=false;
	ValidateUser iUser = ValidateUser.getInstance();
		isUserExists=iUser.isEmailExists(email,transaction,session);
		//int id = vehicleDao.getId(connection);
		//vehicleDao.createCar(id, car, connection);
		return isUserExists;
	}

	public void setUserInfo(User user, Transaction transaction, Session session) throws MetaSocioException {
		CRUD iCrud = CRUD.getInstance();
		iCrud.setUserInfo(user,transaction,session);
		
	}

	public List<User> getUsersHavingSameDepartment(int userId, Transaction transaction, Session session) throws MetaSocioException{

		CRUD iCrud = CRUD.getInstance();
		
		String department=iCrud.getDepartment(userId,transaction,session);
		List<User>  users = iCrud.getUsersHavingSameDepartment(department,transaction,session);
		System.out.println("*********************************department"+users);
		users = iCrud.getUsersWhoAreNotFriends(userId,users,transaction,session);
		System.out.println("***********************************not friend"+users);
		return users;
	}

	public int getIdByEmail(String email, Transaction transaction,
			Session session) throws MetaSocioException {
		
		CRUD iCrud = CRUD.getInstance();
		int id = iCrud.getIdByEmail(email,transaction,session);
		return id;
	}

	public String getNameById(int userId, Transaction transaction,
			Session session) throws MetaSocioException {

		CRUD iCrud = CRUD.getInstance();
		String userName = iCrud.getNameById(userId,transaction,session);
		return userName;
	}

	public void addFriend(Friends friend, Friends secondFriend, Transaction transaction,
			Session session) throws MetaSocioException {
		CRUD iCrud = CRUD.getInstance();
		 iCrud.addFriend(friend,secondFriend, transaction,session);
		
	}

	public void sharePost(PostManagement newPost, Transaction transaction,Session session) throws MetaSocioException {
		CRUD iCrud = CRUD.getInstance();
		iCrud.addPost(newPost,transaction,session);
		
		
	}
	public List<PostManagement> retrievePostOnHome(Transaction transaction,Session session) throws MetaSocioException {
	
		CRUD iCrud = CRUD.getInstance();
		List<PostManagement> postList=iCrud.retrievePostOnHome(transaction,session);
		return postList;
		
	}
	

	/*public boolean checkFriend(int id, List<User> friends, Transaction transaction,
			Session session) {
		CRUD iCrud = CRUD.getInstance();
		boolean isFriend = iCrud.checkFriend(id,friends,transaction,session);
		return isFriend;
	}*/

}
