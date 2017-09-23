package com.skumarv.o2o;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.skumarv.util.HibernateAnnotationUtil;

public class OneToOneMain {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateAnnotationUtil
				.getSessionFactory();
		try {
			Session session = sessionFactory.openSession();
			Transaction trans = session.beginTransaction();

			session.persist(getData());

			trans.commit();
		} catch (Exception e) {
			System.out.println("Exception occured. " + e.getMessage());
			e.printStackTrace();
		} finally {
			if (!sessionFactory.isClosed()) {
				System.out.println("Closing SessionFactory");
				sessionFactory.close();
			}
		}
	}

	public static Txn getData() {
		Txn txn = new Txn();
		txn.setDate(new Date());
		txn.setTotal(123.76);

		Address adres = new Address();
		adres.setAddressLine("Address Line 1");
		adres.setCity("Chennai");
		adres.setState("TamilNadu");

		Customer cust = new Customer();
		cust.setName("Sachin");
		cust.setEmail("sachin@hotmail.com");
		cust.setAddress(adres);
		cust.setTxn(txn);

		txn.setCust(cust);

		return txn;
	}
}
