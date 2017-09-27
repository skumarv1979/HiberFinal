package com.skumarv.test.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.skumarv.test.entity.Cust;
import com.skumarv.test.entity.Trans;
import com.skumarv.util.HibernateAnnotationUtil;

public class TransCustDAO {
	public static void main(String[] args) {
		Trans trans = new Trans();
		Cust cust = new Cust();
		
		trans.setAmount(6237.19);
		cust.setName("Xyz");
		
		TransCustDAO obj = new TransCustDAO();
		obj.insertTranCust(trans, cust);
	}
	public void insertTranCust(Trans trans, Cust cust) {
		trans.setCust(cust);
		cust.setTrans(trans);
		SessionFactory sf = HibernateAnnotationUtil.getSessionFactory();
		Session session = sf.openSession();
		Transaction txn = session.beginTransaction();
		
		session.persist(trans);
		
		
		txn.commit();
		session.close();
	}
}
