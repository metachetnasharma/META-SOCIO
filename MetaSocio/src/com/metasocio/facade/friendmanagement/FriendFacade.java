package com.metasocio.facade.friendmanagement;

import java.util.List;




import org.hibernate.Session;
import org.hibernate.Transaction;

import com.metasocio.dbhelper.CRUD;
import com.metasocio.dbhelper.followermanagement.FollowerDao;
import com.metasocio.dbhelper.friendmanagement.FriendDao;
import com.metasocio.exception.MetaSocioException;
import com.metasocio.model.friendsmanagement.Friend;
import com.metasocio.model.usermanagement.User;

public class FriendFacade {

	public List<User> getUsersWhomYouAreNotFollowing(int userId, List<User> users,
			 Session session)throws MetaSocioException {
		//CRUD iCrud = CRUD.getInstance();
				FollowerDao iFollowerDao=new FollowerDao();
				List<User> usersList=iFollowerDao.getUsersWhomYouAreNotFollowing(userId,users,session);
				
			return usersList;
	}
	public void addFriend(Friend friend, Friend secondFriend,
			Session session) throws MetaSocioException {
		//CRUD iCrud = CRUD.getInstance();
		FriendDao iFriendDao=FriendDao.getInstance();
		iFriendDao.addFriend(friend,secondFriend, session);
		
	}

}
