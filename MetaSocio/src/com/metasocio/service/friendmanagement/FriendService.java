package com.metasocio.service.friendmanagement;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.metasocio.exception.MetaSocioSystemException;
import com.metasocio.facade.MetaSocio_Facade;
import com.metasocio.facade.friendmanagement.FriendFacade;
import com.metasocio.hibernate.factory.ConfigurationFactory;
import com.metasocio.model.friendsmanagement.Friend;

public class FriendService {
	public void addFriend(Friend friend, Friend secondFriend)
			throws MetaSocioSystemException {
		Session session = null;
		// boolean isUserExists=false;
		Transaction transaction = null;
		// String userName;
		try {
			Configuration cfg =ConfigurationFactory.getConfigurationInstance();

			//Configuration cfg = new Configuration();
			//cfg.configure("hibernate.cfg.xml");
			FriendFacade iFriendFacade=new FriendFacade();

			SessionFactory sessionFactory = cfg.buildSessionFactory();

			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			iFriendFacade.addFriend(friend, secondFriend, transaction, session);

			transaction.commit();

		} catch (Exception e) {

			System.out.println("[" + e.getMessage() + "]");
			try {
				transaction.rollback();
				System.out.println("Transaction roll back");
				throw new MetaSocioSystemException("Transaction roll back,["
						+ e.getMessage() + "]", e);
			} catch (Exception e1) {
				System.out.println("error in transactiopn roll back,["
						+ e1.getMessage() + "]");
				throw new MetaSocioSystemException("[" + e.getMessage()
						+ "];error in transactiopn roll back,["
						+ e1.getMessage() + "]", e);
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
		// return isAdded;
	}
}
