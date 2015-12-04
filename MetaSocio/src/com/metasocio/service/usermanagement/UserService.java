package com.metasocio.service.usermanagement;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.metasocio.exception.MetaSocioSystemException;
import com.metasocio.facade.MetaSocio_Facade;
import com.metasocio.facade.usermanagement.UserFacade;
import com.metasocio.hibernate.factory.ConfigurationFactory;
import com.metasocio.model.usermanagement.User;

public class UserService {
	public boolean isEmailExists(String email) throws MetaSocioSystemException {
		System.out
				.println("***********************************************in the exist method");
		Session session = null;
		boolean isUserExists = false;
		Transaction transaction = null;
		try {
			Configuration cfg =ConfigurationFactory.getConfigurationInstance();
			//cfg.configure("hibernate.cfg.xml");
			//MetaSocio_Facade iFacade = new MetaSocio_Facade();
            UserFacade iUserFacade=new UserFacade();
			SessionFactory sessionFactory = cfg.buildSessionFactory();

			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			System.out
					.println("************************************************is exists");
			isUserExists = iUserFacade.isEmailExists(email, session);
			System.out
					.println("************************************************ exists");
			// int id = vehicleDao.getId(connection);
			// vehicleDao.createCar(id, vehicle, connection);
			transaction.commit();

		} catch (Exception e) {
			e.printStackTrace();
		System.out
					.println("************************************************ exists exception");
		System.out.println("[" + e.getMessage() + "]");
		try {
				transaction.rollback();
				System.out.println("Transaction roll back");
				throw new MetaSocioSystemException("Transaction roll back,["
						+ e.getMessage() + "]", e);
			} catch (Exception e1) {
				e1.printStackTrace();
				
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
			Configuration cfg =ConfigurationFactory.getConfigurationInstance();

			//Configuration cfg = new Configuration();
			//cfg.configure("hibernate.cfg.xml");
			//MetaSocio_Facade iFacade = new MetaSocio_Facade();
            UserFacade iUserFacade=new UserFacade();

			SessionFactory sessionFactory = cfg.buildSessionFactory();

			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			iUserFacade.setUserInfo(user,session);
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
				e1.printStackTrace();
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

	public List<User> getUsersHavingSameDepartment(User user)
			throws MetaSocioSystemException {
		Session session = null;
		// boolean isUserExists=false;
		Transaction transaction = null;
		List<User> usersOfSameDepartment;
		try {
			Configuration cfg =ConfigurationFactory.getConfigurationInstance();

			//Configuration cfg = new Configuration();
			//cfg.configure("hibernate.cfg.xml");
			//MetaSocio_Facade iFacade = new MetaSocio_Facade();
            UserFacade iUserFacade=new UserFacade();

			SessionFactory sessionFactory = cfg.buildSessionFactory();

			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			usersOfSameDepartment = iUserFacade.getUsersHavingSameDepartment(
					user, session);
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

	/*public int getIdByEmail(String email) throws MetaSocioSystemException {
		Session session = null;
		// boolean isUserExists=false;
		Transaction transaction = null;
		int userId;
		try {
			Configuration cfg =ConfigurationFactory.getConfigurationInstance();

			//Configuration cfg = new Configuration();
			//cfg.configure("hibernate.cfg.xml");
			//MetaSocio_Facade iFacade = new MetaSocio_Facade();
            UserFacade iUserFacade=new UserFacade();

			SessionFactory sessionFactory = cfg.buildSessionFactory();

			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			userId = iUserFacade.getIdByEmail(email, session);
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
			Configuration cfg =ConfigurationFactory.getConfigurationInstance();

			//Configuration cfg = new Configuration();
			//cfg.configure("hibernate.cfg.xml");
			//MetaSocio_Facade iFacade = new MetaSocio_Facade();
            UserFacade iUserFacade=new UserFacade();

			SessionFactory sessionFactory = cfg.buildSessionFactory();

			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			userName = iUserFacade.getNameById(userId, session);
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
	
	public String getImageById(int userId) throws MetaSocioSystemException {
		Session session = null;
		// boolean isUserExists=false;
		Transaction transaction = null;
		String userImage;
		try {
			Configuration cfg =ConfigurationFactory.getConfigurationInstance();

			///Configuration cfg = new Configuration();
			//cfg.configure("hibernate.cfg.xml");
			//MetaSocio_Facade iFacade = new MetaSocio_Facade();
            UserFacade iUserFacade=new UserFacade();

			SessionFactory sessionFactory = cfg.buildSessionFactory();

			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			userImage = iUserFacade.getImageById(userId, session);
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
		return userImage;
	}*/

	public User getUserByEmail(String email) throws MetaSocioSystemException {
		Session session = null;
		// boolean isUserExists=false;
		Transaction transaction = null;
		User user;
		try {
			Configuration cfg =ConfigurationFactory.getConfigurationInstance();

			//Configuration cfg = new Configuration();
			//cfg.configure("hibernate.cfg.xml");
			//MetaSocio_Facade iFacade = new MetaSocio_Facade();
            UserFacade iUserFacade=new UserFacade();

			SessionFactory sessionFactory = cfg.buildSessionFactory();

			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			user = iUserFacade.getUserByEmail(email, session);
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
		return user;
	}

	public User getUserById(int followingId) throws MetaSocioSystemException {
		Session session = null;
		// boolean isUserExists=false;
		Transaction transaction = null;
		User user;
		try {
			Configuration cfg =ConfigurationFactory.getConfigurationInstance();

			//Configuration cfg = new Configuration();
			//cfg.configure("hibernate.cfg.xml");
			//MetaSocio_Facade iFacade = new MetaSocio_Facade();
            UserFacade iUserFacade=new UserFacade();

			SessionFactory sessionFactory = cfg.buildSessionFactory();

			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			user = iUserFacade.getUserById(followingId, session);
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
		return user;
	}
}
