package com.skumarv.m2m3;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.skumarv.util.HibernateAnnotationUtil;

public class Many2ManyTester {
	public static void main(String[] args) {
		// loads configuration and mappings

		// builds a session factory from the service registry
		SessionFactory sessionFactory = HibernateAnnotationUtil
				.getSessionFactory();

		// obtains the session
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		testSaveAllNew(session);
//		testSaveWithExistingUserAndGroup(session);
//		testDeleteUserGroup(session);
		

		session.getTransaction().commit();
		session.close();		
	}

	public static void testSaveAllNew(Session session) {
		User user = new User("tommy", "ymmot", "tommy@gmail.com");
		Group group = new Group("Coders");
		
		UserGroup userGroup = new UserGroup();
		userGroup.setGroup(group);
		userGroup.setUser(user);
		userGroup.setActivated(true);
		userGroup.setRegisteredDate(new Date());
		
		session.save(userGroup);
	}
	
	public static void testSaveWithExistingUserAndGroup(Session session) {
		// this user is obtained from the database with ID 34
		User user = (User) session.get(User.class, new Long(34));

		// this group is obtained from the database with ID 17		
		Group group = (Group) session.get(Group.class, new Long(17));
		
		UserGroup userGroup = new UserGroup();
		userGroup.setGroup(group);
		userGroup.setUser(user);
		userGroup.setActivated(true);
		userGroup.setRegisteredDate(new Date());
				
		session.save(userGroup);		
	}
	
	public static void testDeleteUserGroup(Session session) {
		UserGroup userGroup = new UserGroup();
		userGroup.setId(3);
		session.delete(userGroup);
	}
}
