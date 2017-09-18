package com.skumarv.m2m4;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.skumarv.util.HibernateAnnotationUtil;

public class Many2ManyTester {
	public static void main(String[] args) {
		// loads configuration and mappings

		// builds a session factory from the service registry
		SessionFactory sessionFactory = HibernateAnnotationUtil
				.getSessionFactory("com/skumarv/m2m4/hibernate.cfg.xml");

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
		User user = new User("sam", "mas", "sam@gmail.com");
		
		Group group = new Group("Designer");
		session.save(group);
		
		UserGroup userGroup = new UserGroup();
		userGroup.setGroup(group);
		userGroup.setUser(user);
		userGroup.setActivated(true);
		userGroup.setRegisteredDate(new Date());
		
		user.addUserGroup(userGroup);
		
		session.save(user);
	}
	
	public static void testSaveWithExistingUserAndGroup(Session session) {
		// this user is obtained from the database with ID 40
		User user = (User) session.get(User.class, new Long(40));

		// this group is obtained from the database with ID 26		
		Group group = (Group) session.get(Group.class, new Long(26));
		
		UserGroup userGroup = new UserGroup();
		userGroup.setGroup(group);
		userGroup.setUser(user);
		userGroup.setActivated(true);
		userGroup.setRegisteredDate(new Date());
				
		session.save(userGroup);		
	}
	
	public static void testDeleteUserGroup(Session session) {
		UserGroup userGroup = new UserGroup();
		
		User user = new User();
		user.setId(39);
		userGroup.setUser(user);
		
		Group group = new Group();
		group.setId(25);
		userGroup.setGroup(group);
		
		session.delete(userGroup);
	}
}
