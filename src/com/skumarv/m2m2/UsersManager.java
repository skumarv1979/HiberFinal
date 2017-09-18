package com.skumarv.m2m2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.skumarv.util.HibernateAnnotationUtil;

/**
 * A program that demonstrates using JPA annotations to map a bidirectional
 * many-to-many association in Hibernate framework.
 * 
 * @author www.codejava.net
 * 
 */
public class UsersManager {

	public static void main(String[] args) {
		// loads configuration and mappings

		// builds a session factory from the service registry
		SessionFactory sessionFactory = HibernateAnnotationUtil
				.getSessionFactory("com/skumarv/m2m2/hibernate.cfg.xml");

		// obtains the session
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Group groupAdmin = new Group("Administrator Group");
		Group groupGuest = new Group("Guest Group");

		User user1 = new User("Tom", "tomcat", "tom@codejava.net");
		User user2 = new User("Mary", "mary", "mary@codejava.net");

		groupAdmin.addUser(user1);
		groupAdmin.addUser(user2);

		groupGuest.addUser(user1);

		user1.addGroup(groupAdmin);
		user2.addGroup(groupAdmin);
		user1.addGroup(groupGuest);

		session.save(groupAdmin);
		session.save(groupGuest);

		session.getTransaction().commit();
		session.close();
	}

}