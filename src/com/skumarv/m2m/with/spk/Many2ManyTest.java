package com.skumarv.m2m.with.spk;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.skumarv.util.HibernateAnnotationUtil;

public class Many2ManyTest {

	public static void main(String[] args) {
		SessionFactory sf = HibernateAnnotationUtil.getSessionFactory();
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();
		
		/*User user = new User();
		user.setName("Saravanakumar");
		user.setEmail("skum@hot.com");
		Group group = new Group();
		group.setName("AdminGroup");
		UserGroup ug = new UserGroup();
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		
		cal.add(Calendar.MONTH, -2);
		ug.setUser(user);
		ug.setGroup(group);
		ug.setActivationDt(cal.getTime());
		session.persist(ug);
		
		
		Group groupIT = new Group();
		groupIT.setName("ITGroup");
		ug = new UserGroup();
		ug.setUser(user);
		ug.setGroup(groupIT);
		ug.setActivationDt(new Date());
		session.persist(ug);*/
		
		List<UserGroup> ug =  session.createCriteria(UserGroup.class).list();
		for (UserGroup userGroup : ug) {
			System.out.println(userGroup);
		}
		
		trans.commit();
		session.flush();
		session.close();
	}

}
