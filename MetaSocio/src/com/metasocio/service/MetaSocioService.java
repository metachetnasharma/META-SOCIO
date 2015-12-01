package com.metasocio.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.metasocio.exception.MetaSocioSystemException;
import com.metasocio.facade.MetaSocio_Facade;
import com.metasocio.hibernate.factory.ConfigurationFactory;
import com.metasocio.model.usermanagement.User;

public class MetaSocioService {

	

	

	
	/*
	 * public boolean checkFriends(int id, List<User> friends) { Configuration
	 * cfg = new Configuration(); cfg.configure("hibernate.cfg.xml");
	 * MetaSocio_Facade iFacade=new MetaSocio_Facade(); //boolean
	 * isUserExists=false;
	 * 
	 * SessionFactory sessionFactory =cfg.buildSessionFactory();
	 * 
	 * Session session = sessionFactory.openSession(); Transaction
	 * transaction=session.beginTransaction(); boolean isFriend;
	 * 
	 * try { isFriend = iFacade.checkFriend(id,friends, transaction, session);
	 * transaction.commit();
	 * 
	 * } catch (Exception e) {
	 * 
	 * System.out.println("[" + e.getMessage() + "]"); transaction.rollback();
	 * System.out.println("Transaction roll back"); throw new
	 * MetaSocioSystemException("Transaction roll back,[" + e.getMessage() +
	 * "]", e); } finally { if(session!=null){ session.close(); } } return
	 * isFriend; }
	 */

	

}
