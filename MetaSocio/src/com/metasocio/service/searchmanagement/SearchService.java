package com.metasocio.service.searchmanagement;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.metasocio.exception.MetaSocioSystemException;
import com.metasocio.facade.searchmanagement.SearchFacade;
import com.metasocio.hibernate.factory.ConfigurationFactory;
import com.metasocio.model.usermanagement.User;
/********************************************************************************
 * @author 
 * Since : 23 November, 2015
 * Description : This SearchService class is providing services like session opening, 
 * session closing, beginning transaction and commit transactions.Session is opening 
 * a connection between Java and database and transactions is to commit queries in
 * database.
 */
public class SearchService {

	/***********************************************************************
	 * This function is managing search operations providing
	 * session to the facade layer and transactions will be committed
	 * in this layer, also closing session.
	 * @param search : input on which basis search result will come.
	 * @return : searchResult containing related search list of Users 
	 * @throws MetaSocioSystemException : Throwing MetaSocioException
	 * 								if any exception occurs
	 ***********************************************************************/
	public List<User> retrieveUsersByKey(String search)
			throws MetaSocioSystemException {
		Session session = null;//Creating session

		Transaction transaction = null;//Creating transaction
		List<User> searchResult = new ArrayList<User>();//Array List of User type
		try {

			SearchFacade iSearchFacade = new SearchFacade();//Creating instance of 'SearchFacade' class
			Configuration cfg = ConfigurationFactory.getConfigurationInstance();//Getting instance of configuration file


			SessionFactory sessionFactory = cfg.buildSessionFactory();	//Building session factory

			session = sessionFactory.openSession(); //opening session
			transaction = session.beginTransaction(); //beginning transaction
			
			//passing session and search string to manage search operation in Facade 
			searchResult = iSearchFacade.retrieveUsersByKey(
					session, search);

			transaction.commit();//committing transaction 

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
				session.close(); //closing session if not null
			}
		}
		return searchResult;
	}
}
