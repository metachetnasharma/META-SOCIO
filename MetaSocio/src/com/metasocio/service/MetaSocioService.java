package com.metasocio.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.metasocio.exception.MetaSocioSystemException;
import com.metasocio.facade.MetaSocio_Facade;
import com.metasocio.model.friendsmanagement.Friends;
import com.metasocio.model.postmanagement.PostManagement;
import com.metasocio.model.usermanagement.User;

public class MetaSocioService {

	public boolean isEmailExists(String email) throws MetaSocioSystemException {
		System.out
				.println("***********************************************in the exist method");
		Session session = null;
		boolean isUserExists = false;
		Transaction transaction = null;
		try {
			Configuration cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml");
			MetaSocio_Facade iFacade = new MetaSocio_Facade();

			SessionFactory sessionFactory = cfg.buildSessionFactory();

			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			System.out
					.println("************************************************is exists");
			isUserExists = iFacade.isEmailExists(email, transaction, session);
			System.out
					.println("************************************************ exists");
			// int id = vehicleDao.getId(connection);
			// vehicleDao.createCar(id, vehicle, connection);
			transaction.commit();

		} catch (Exception e) {
			System.out
					.println("************************************************ exists exception");
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
		return isUserExists;
	}

	public void setUserInfo(User user) throws MetaSocioSystemException {
		Session session = null;
		// boolean isUserExists=false;
		Transaction transaction = null;
		try {
			Configuration cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml");
			MetaSocio_Facade iFacade = new MetaSocio_Facade();

			SessionFactory sessionFactory = cfg.buildSessionFactory();

			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			iFacade.setUserInfo(user, transaction, session);
			// int id = vehicleDao.getId(connection);
			// vehicleDao.createCar(id, vehicle, connection);
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

	}

	public List<User> getUsersHavingSameDepartment(int userId)
			throws MetaSocioSystemException {
		Session session = null;
		// boolean isUserExists=false;
		Transaction transaction = null;
		List<User> usersOfSameDepartment;
		try {
			Configuration cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml");
			MetaSocio_Facade iFacade = new MetaSocio_Facade();

			SessionFactory sessionFactory = cfg.buildSessionFactory();

			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			usersOfSameDepartment = iFacade.getUsersHavingSameDepartment(
					userId, transaction, session);
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

		return usersOfSameDepartment;
	}

	public int getIdByEmail(String email) throws MetaSocioSystemException {
		Session session = null;
		// boolean isUserExists=false;
		Transaction transaction = null;
		int userId;
		try {
			Configuration cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml");
			MetaSocio_Facade iFacade = new MetaSocio_Facade();

			SessionFactory sessionFactory = cfg.buildSessionFactory();

			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			userId = iFacade.getIdByEmail(email, transaction, session);
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
		return userId;
	}

	public String getNameById(int userId) throws MetaSocioSystemException {
		Session session = null;
		// boolean isUserExists=false;
		Transaction transaction = null;
		String userName;
		try {
			Configuration cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml");
			MetaSocio_Facade iFacade = new MetaSocio_Facade();

			SessionFactory sessionFactory = cfg.buildSessionFactory();

			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			userName = iFacade.getNameById(userId, transaction, session);
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
		return userName;
	}

	public void addFriend(Friends friend, Friends secondFriend)
			throws MetaSocioSystemException {
		Session session = null;
		// boolean isUserExists=false;
		Transaction transaction = null;
		// String userName;
		try {
			Configuration cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml");
			MetaSocio_Facade iFacade = new MetaSocio_Facade();

			SessionFactory sessionFactory = cfg.buildSessionFactory();

			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			iFacade.addFriend(friend, secondFriend, transaction, session);

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

	public void sharePost(PostManagement newPost)
			throws MetaSocioSystemException {
		Session session = null;
		// boolean isUserExists=false;
		Transaction transaction = null;
		try {
			Configuration cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml");
			MetaSocio_Facade iFacade = new MetaSocio_Facade();

			SessionFactory sessionFactory = cfg.buildSessionFactory();

			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			iFacade.sharePost(newPost, transaction, session);
			// int id = vehicleDao.getId(connection);
			// vehicleDao.createCar(id, vehicle, connection);
			transaction.commit();

		} catch (Exception e) {
			e.printStackTrace();
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

	}

	
	public List<PostManagement> retrievePostOnHome()
			throws MetaSocioSystemException {
		Session session = null;
		// boolean isUserExists=false;
		List<PostManagement> postList= null;
		Transaction transaction = null;
		try {
			Configuration cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml");
			MetaSocio_Facade iFacade = new MetaSocio_Facade();

			SessionFactory sessionFactory = cfg.buildSessionFactory();

			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			 postList = iFacade.retrievePostOnHome(transaction, session);
			
			transaction.commit();

		} catch (Exception e) {
			e.printStackTrace();
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
		return postList;

	}
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
