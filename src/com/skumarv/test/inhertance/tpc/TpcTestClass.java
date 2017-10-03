package com.skumarv.test.inhertance.tpc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.skumarv.util.HibernateAnnotationUtil;

public class TpcTestClass {
	public static void main(String[] args) {
		SessionFactory sf = HibernateAnnotationUtil.getSessionFactory();
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();
		
		Employee emp = new Employee();
		emp.setName("Employee");
		
		RegularEmployee reg = new RegularEmployee();
		reg.setName("RegularEmployee");
		reg.setSalary(432.74f);
		reg.setBonus(432);
		
		ContractEmployee con = new ContractEmployee();
		con.setName("ContractEmployee");
		con.setPayPerHour(65.32f);
		con.setContractPeriod("3 months");
		
		session.persist(emp);
		session.persist(reg);
		session.persist(con);
		
		trans.commit();
		session.close();
	}
}
