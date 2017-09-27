package com.skumarv.m2mtest;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.skumarv.util.HibernateAnnotationUtil;

public class ManyToManyTest {
	public static void main(String[] args) {
		
		Groups grp1 = new Groups();
		grp1.setName("Group1");
		Groups grp2 = new Groups();
		grp2.setName("Group2");
		Groups grp3 = new Groups();
		grp3.setName("Group3");
		Groups grp4 = new Groups();
		grp4.setName("Group4");
		
		Users u1= new Users();
		u1.setName("User1");
		
		Users u2= new Users();
		u2.setName("User2");
		
		Users u3= new Users();
		u3.setName("User3");
		
		Set<Users> users1 = new HashSet<Users>();
		users1.add(u1);
		users1.add(u2);
		grp1.setUsers(users1);
		
		Set<Users> users2 = new HashSet<Users>();
		users2.add(u2);
		users2.add(u3);
		grp2.setUsers(users2);
		
		Set<Users> users3 = new HashSet<Users>();
		users3.add(u1);
		users3.add(u3);
		grp3.setUsers(users3);

		Set<Users> users4 = new HashSet<Users>();
		users4.add(u1);
		users4.add(u2);
		users4.add(u3);
		grp4.setUsers(users4);
		
		/*Set<Groups> groups1 = new HashSet<Groups>();
		groups1.add(grp1);
		groups1.add(grp3);
		groups1.add(grp4);
		u1.setGroups(groups1);
		
		Set<Groups> groups2 = new HashSet<Groups>();
		groups2.add(grp1);
		groups2.add(grp2);
		groups2.add(grp4);
		u2.setGroups(groups2);
		
		Set<Groups> groups3 = new HashSet<Groups>();
		groups3.add(grp2);
		groups3.add(grp3);
		groups3.add(grp4);
		u3.setGroups(groups3);*/

		SessionFactory sessionFactory = HibernateAnnotationUtil
				.getSessionFactory();
		try {
			Session session = sessionFactory.openSession();
			Transaction trans = session.beginTransaction();
			
			session.saveOrUpdate(grp1);
			session.saveOrUpdate(grp2);
			session.saveOrUpdate(grp3);
			session.saveOrUpdate(grp4);
			/*session.saveOrUpdate(u1);
			session.saveOrUpdate(u2);
			session.saveOrUpdate(u3);*/
			
			trans.commit();
			session.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
