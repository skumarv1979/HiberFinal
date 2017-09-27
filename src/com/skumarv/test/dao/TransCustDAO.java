package com.skumarv.test.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.skumarv.test.entity.Cust;
import com.skumarv.test.entity.Trans;
import com.skumarv.util.HibernateAnnotationUtil;

public class TransCustDAO {
	public static void main(String[] args) {
		/*Trans trans = new Trans();
		Cust cust = new Cust();
		
		trans.setAmount(6237.19);
		cust.setName("Xyz");
		
		TransCustDAO obj = new TransCustDAO();
		obj.insertTranCust(trans, cust);*/
		/*Trans trans = new Trans();
		trans.setAmount(4342.36);
		TransCustDAO obj = new TransCustDAO();
		obj.insertTran(trans);
		trans = new Trans();
		trans.setAmount(1963.37);
		obj.insertTran(trans);*/
		Cust cust = new Cust();
		cust.setName("Abcds");
		TransCustDAO obj = new TransCustDAO();
		obj.updateCust(3, cust);
	}
	public void updateCust(int tno, Cust cust) {
		SessionFactory sf = HibernateAnnotationUtil.getSessionFactory();
		Session session = sf.openSession();
		Transaction txn = session.beginTransaction();
		
		Trans trans = (Trans) session.get(Trans.class, new Integer(tno));
		if(trans!=null) {
			trans.setCust(cust);
			cust.setTrans(trans);
			session.persist(trans);
		}
		else {
			System.out.println("Invalid trans");
		}
		
		
		txn.commit();
		session.close();
		
	}
	public void insertTran(Trans trans) {
		SessionFactory sf = HibernateAnnotationUtil.getSessionFactory();
		Session session = sf.openSession();
		Transaction txn = session.beginTransaction();
		
		session.persist(trans);
		
		
		txn.commit();
		session.close();
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
