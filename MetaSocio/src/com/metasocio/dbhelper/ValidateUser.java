package com.metasocio.dbhelper;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.metasocio.exception.MetaSocioException;
import com.metasocio.model.usermanagement.User;


public class ValidateUser {
	private static ValidateUser iUser;

	private ValidateUser() {

	}

	public static ValidateUser getInstance() {

		if (iUser == null) {
			iUser = new ValidateUser();

		}
		return iUser;
	}

	/**
	 * @param email
	 * @param transaction
	 * @param session
	 * @return
	 * @throws MetaSocioException
	 */
	public boolean isEmailExists(String email, Transaction transaction,
			Session session) throws MetaSocioException {
		boolean isUserExists = false;
		// Configuration cfg = new Configuration();
		// cfg.configure("hibernate.cfg.xml");
		// SessionFactory sessionFactory =transaction.buildSessionFactory();

		Criteria criteria = session.createCriteria(User.class);

		criteria.add(Restrictions.eq("email_id", email));

		User user = (User) criteria.uniqueResult();

		if (user != null) {
			isUserExists = true;

		} else {
			isUserExists = false;
		}
		// tx.commit();

		return isUserExists;

	}
}

// Configuration cfg = new Configuration();
// cfg.configure("http://localhost:8080/MetaSocio/WEB-INF/classes/com/hibernate.cfg.xml");

// SessionFactory factory = cfg.configure().buildSessionFactory();
/*
 * Session sess = null; try{ SessionFactory sf = new Configuration().
 * configure().buildSessionFactory(); sess = sf.openSession(); Transaction tr =
 * sess.beginTransaction(); Criteria criteria = sess.createCriteria(User.class);
 * criteria.add(Restrictions.eq("email_id" , "p")); List<User> employees =
 * criteria.list();
 * System.out.println("size"+employees.size()+"list"+employees);
 * System.out.println
 * ("Get Employee which name is Birendra Kumar and salary is 12050.0 :");
 * for(User emp: employees){ System.out.println( "Id: " + emp.getCreated_by() +
 * ", EmpName: " + emp.getDepartment() + ", EmpSal: " + emp.getEmail_id() ); }
 * tr.commit(); }catch(Exception ex){ ex.printStackTrace(); }finally{ if(sess !=
 * null){ sess.close(); } } }
 * 
 * 
 * Session session = factory.getCurrentSession();
 * 
 * try {
 * 
 * session.beginTransaction();
 * 
 * 
 * 
 * Criteria criteria = session.createCriteria(User.class);
 * 
 * criteria.add(Restrictions.eq("email_id", "p"));
 * 
 * System.out.println("heloo"+criteria.list()); User user = (User)
 * criteria.uniqueResult(); System.out.println("************************"+user);
 * 
 * if (user!=null) { System.out.println("user found:");
 * 
 * System.out.println("************"+user.getCreated_by() + " - " +
 * user.getEmail_id());
 * 
 * } else{ System.out.println("hi................................s"); }
 * 
 * 
 * session.getTransaction().commit();
 * 
 * }
 * 
 * catch (HibernateException e) {
 * 
 * e.printStackTrace(); session.getTransaction().rollback();
 * 
 * }
 * 
 * 
 * 
 * }
 */

/*
 * Transaction tx = session.beginTransaction();
 * 
 * tx = null; try{ tx = session.beginTransaction(); Criteria criteria =
 * session.createCriteria(User.class);
 * 
 * criteria.add(Restrictions.eq("email_id", email_Id)); User user = (User)
 * criteria.uniqueResult();
 * 
 * 
 * 
 * if (user!=null) {
 * 
 * System.out.println("user found:");
 * System.out.println(user.getEmail_id()+user.getCreated_by());
 * //System.out.println(employee.getId() + " - " + employee.getName());
 * 
 * }
 * 
 * 
 * 
 * session.getTransaction().commit();
 * 
 * 
 * 
 * 
 * 
 * tx.commit(); }catch (HibernateException e) { if (tx!=null) tx.rollback();
 * e.printStackTrace(); }finally { session.close(); } }
 */

