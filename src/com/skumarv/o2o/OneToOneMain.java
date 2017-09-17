package com.skumarv.o2o;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class OneToOneMain {
	public static void main(String[] args) {
		SessionFactory sf = HibernateAnnotationUtil.getSessionFactory();
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();
		
		session.persist(getData());
		
		
		trans.commit();
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
