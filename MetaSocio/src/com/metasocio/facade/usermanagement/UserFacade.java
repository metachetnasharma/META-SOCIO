package com.metasocio.facade.usermanagement;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.metasocio.dbhelper.CRUD;
import com.metasocio.dbhelper.friendmanagement.FriendDao;
import com.metasocio.dbhelper.usermanagement.UserDao;
import com.metasocio.dbhelper.usermanagement.ValidateUser;
import com.metasocio.exception.MetaSocioException;
import com.metasocio.facade.friendmanagement.FriendFacade;
import com.metasocio.model.usermanagement.User;

public class UserFacade {
	public boolean isEmailExists(String email, Transaction transaction,Session session) throws MetaSocioException {
		boolean isUserExists=false;
	    ValidateUser iUser = ValidateUser.getInstance();
		isUserExists=iUser.isEmailExists(email,transaction,session);
		//int id = vehicleDao.getId(connection);
		//vehicleDao.createCar(id, car, connection);
		return isUserExists;
	}

	public void setUserInfo(User user, Transaction transaction, Session session) throws MetaSocioException {
		//CRUD iCrud = CRUD.getInstance();
		UserDao iUserDao=UserDao.getInstance();
		iUserDao.setUserInfo(user,transaction,session);
		
	}

	public List<User> getUsersHavingSameDepartment(int userId, Transaction transaction, Session session) throws MetaSocioException{

		//CRUD iCrud = CRUD.getInstance();
		UserDao iUserDao=UserDao.getInstance();
		
		String department=iUserDao.getDepartment(userId,transaction,session);
		List<User>  users = iUserDao.getUsersHavingSameDepartment(department,transaction,session);
		//System.out.println("*********************************department"+users);
		FriendFacade iFriendFacade=new FriendFacade();
		
		users = iFriendFacade.getUsersWhoAreNotFriends(userId,users,transaction,session);
		//System.out.println("***********************************not friend"+users);
		return users;
	}

	public int getIdByEmail(String email, Transaction transaction,
			Session session) throws MetaSocioException {
		
		//CRUD iCrud = CRUD.getInstance();
				UserDao iUserDao=UserDao.getInstance();
				
		int id = iUserDao.getIdByEmail(email,transaction,session);
		return id;
	}
	

	public String getNameById(int userId, Transaction transaction,
			Session session) throws MetaSocioException {

		//CRUD iCrud = CRUD.getInstance();
		UserDao iUserDao=UserDao.getInstance();
		String userName = iUserDao.getNameById(userId,transaction,session);
		return userName;
	}
	
	public String getImageById(int userId, Transaction transaction,
			Session session) throws MetaSocioException {

		//CRUD iCrud = CRUD.getInstance();
		UserDao iUserDao=UserDao.getInstance();
		String userImage = iUserDao.getImageById(userId,transaction,session);
		return userImage;
	}
}
