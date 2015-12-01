package com.metasocio.facade.friendmanagement;

import java.util.List;



import org.hibernate.Session;
import org.hibernate.Transaction;

import com.metasocio.dbhelper.CRUD;
import com.metasocio.dbhelper.friendmanagement.FriendDao;
import com.metasocio.exception.MetaSocioException;
import com.metasocio.model.friendsmanagement.Friend;
import com.metasocio.model.usermanagement.User;

public class FriendFacade {

	public List<User> getUsersWhoAreNotFriends(int userId, List<User> users,
			Transaction transaction, Session session)throws MetaSocioException {
		//CRUD iCrud = CRUD.getInstance();
				FriendDao iFriendDao=FriendDao.getInstance();
				List<User> usersList=iFriendDao.getUsersWhoAreNotFriends(userId,users,transaction,session);
				
			return usersList;
	}
	public void addFriend(Friend friend, Friend secondFriend, Transaction transaction,
			Session session) throws MetaSocioException {
		//CRUD iCrud = CRUD.getInstance();
		FriendDao iFriendDao=FriendDao.getInstance();
		iFriendDao.addFriend(friend,secondFriend, transaction,session);
		
	}

}
