package com.metasocio.service.commentmanagement;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.metasocio.exception.MetaSocioSystemException;
import com.metasocio.facade.MetaSocio_Facade;
import com.metasocio.facade.commentmanagement.CommentFacade;
import com.metasocio.facade.postmanagement.PostFacade;
import com.metasocio.hibernate.factory.ConfigurationFactory;
import com.metasocio.model.commentmanagement.Comment;
import com.metasocio.modelhelper.ImageHelper;

public class CommentService {

	public void shareComment(Comment newComment) throws MetaSocioSystemException {
		Session session = null;
		// boolean isUserExists=false;
		Transaction transaction = null;
		try {
			Configuration cfg =ConfigurationFactory.getConfigurationInstance();

			//Configuration cfg = new Configuration();
			//cfg.configure("hibernate.cfg.xml");
			//MetaSocio_Facade iFacade = new MetaSocio_Facade();
              CommentFacade iCommentFacade=new CommentFacade();
			SessionFactory sessionFactory = cfg.buildSessionFactory();

			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			iCommentFacade.shareComment(newComment, transaction, session);
			// int id = vehicleDao.getId(connection);
			// vehicleDao.createCar(id, vehicle, connection);
			transaction.commit();

		}catch (Exception e) {
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
	
	/*public List<Comment> retrieveCommentListByPostID(int postID)
			throws MetaSocioSystemException {
		Session session = null;
		// boolean isUserExists=false;
		List<Comment> commentList= null;
		Transaction transaction = null;
		try {
			Configuration cfg =ConfigurationFactory.getConfigurationInstance();

			//Configuration cfg = new Configuration();
			//cfg.configure("hibernate.cfg.xml");
			//MetaSocio_Facade iFacade = new MetaSocio_Facade();
            CommentFacade iCommentFacade=new CommentFacade();

			SessionFactory sessionFactory = cfg.buildSessionFactory();

			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			 commentList = iCommentFacade.retrieveCommentListByPostID(postID, transaction, session);
			 for(Comment comment : commentList){
					System.out.println("Service Comments " + comment.getComments());
				}
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
		return commentList;

	}
*/
	public List<Comment> retrieveCommentListWithImageByPostID(int postId) throws MetaSocioSystemException {
		Session session = null;
		// boolean isUserExists=false;
		
		Transaction transaction = null;
		 List<Comment> commentsWithImage = new ArrayList<Comment>();	
		 try {
			
			CommentFacade iCommentFacade=new CommentFacade();
			Configuration cfg =ConfigurationFactory.getConfigurationInstance();

			SessionFactory sessionFactory = cfg.buildSessionFactory();

			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			commentsWithImage = iCommentFacade.retrieveCommentListWithImageByPostID(postId, transaction, session);
			
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
		return commentsWithImage;
	}
}
