package com.metasocio.facade.usermanagement;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.metasocio.dbhelper.CRUD;
import com.metasocio.dbhelper.friendmanagement.FriendDao;
import com.metasocio.dbhelper.usermanagement.UserDao;
import com.metasocio.dbhelper.usermanagement.ValidateUser;
import com.metasocio.exception.MetaSocioException;
import com.metasocio.facade.followermanagement.FollowerFacade;
import com.metasocio.facade.friendmanagement.FriendFacade;
import com.metasocio.model.usermanagement.User;

public class UserFacade {
	public boolean isEmailExists(String email,Session session) throws MetaSocioException {
		boolean isUserExists=false;
	    ValidateUser iUser = ValidateUser.getInstance();
		isUserExists=iUser.isEmailExists(email,session);
		//int id = vehicleDao.getId(connection);
		//vehicleDao.createCar(id, car, connection);
		return isUserExists;
	}

	public void setUserInfo(User user, Session session) throws MetaSocioException {
		//CRUD iCrud = CRUD.getInstance();
		UserDao iUserDao=UserDao.getInstance();
		iUserDao.setUserInfo(user,session);
		
	}

	public List<User> getUsersHavingSameDepartment(User user, Session session) throws MetaSocioException{

		//CRUD iCrud = CRUD.getInstance();
		UserDao iUserDao=UserDao.getInstance();
		
		/*String department=iUserDao.getDepartment(userId,session);*/
		
		
		List<User>  users = iUserDao.getUsersHavingSameDepartment(user.getDepartment(),session);
		//System.out.println("*********************************department"+users);
		FollowerFacade iFollowerFacade=new FollowerFacade();
		
		List<User> userWhomYouAreNotFollowing = iFollowerFacade.getUsersWhomYouAreNotFollowing(user.getUserId(),users,session);
		//System.out.println("***********************************not friend"+users);
		return userWhomYouAreNotFollowing;
	}

	/*public int getIdByEmail(String email,
			Session session) throws MetaSocioException {
		
		//CRUD iCrud = CRUD.getInstance();
				UserDao iUserDao=UserDao.getInstance();
				
		int id = iUserDao.getIdByEmail(email,session);
		return id;
	}
	

	public String getNameById(int userId, 
			Session session) throws MetaSocioException {

		//CRUD iCrud = CRUD.getInstance();
		UserDao iUserDao=UserDao.getInstance();
		String userName = iUserDao.getNameById(userId,session);
		return userName;
	}
	
	public String getImageById(int userId,
			Session session) throws MetaSocioException {

		//CRUD iCrud = CRUD.getInstance();
		UserDao iUserDao=UserDao.getInstance();
		String userImage = iUserDao.getImageById(userId,session);
		return userImage;
	}*/

	public User getUserByEmail(String email, Session session)  throws MetaSocioException {
		
		//CRUD iCrud = CRUD.getInstance();
				UserDao iUserDao=UserDao.getInstance();
				
		User user = iUserDao.getUserByEmail(email,session);
		return user;
	}

	public User getUserById(int followingId, Session session) throws MetaSocioException {
		
		//CRUD iCrud = CRUD.getInstance();
				UserDao iUserDao=UserDao.getInstance();
				
		User user = iUserDao.getUserById(followingId,session);
		return user;
	}

	public List<User> getAllUsers(Session session) throws MetaSocioException {
		
		//CRUD iCrud = CRUD.getInstance();
				UserDao iUserDao=UserDao.getInstance();
				
		List<User> usersList = iUserDao.getAllUsers(session);
		return usersList;
	}
}
