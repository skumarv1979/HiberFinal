package com.skumarv.m2m;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.skumarv.util.HibernateAnnotationUtil;

public class ManyToManyMain {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateAnnotationUtil
				.getSessionFactory("com/skumarv/m2m/hibernate.cfg.xml");
		try {
			Session session = sessionFactory.openSession();
			Transaction trans = session.beginTransaction();
			Set<Cart> carts = getData();

			Iterator<Cart> itr = carts.iterator();
			
			for (;itr.hasNext();) {
				session.persist(itr.next());
			}
			

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

	public static Set<Cart> getData() {
		Cart cart = new Cart();
		cart.setTotal(1763.76);
		
		Set<Item> itemsSet = new HashSet<Item>();
		Item item1 = new Item();
		item1.setName("Item 1");
		item1.setUnitPrice(127.87);
		itemsSet.add(item1);
		
		
		Item item2 = new Item();
		item2.setName("Item 2");
		item2.setUnitPrice(764.32);
		itemsSet.add(item2);
		
		cart.setItems(itemsSet);

		Cart cart2 = new Cart();
		cart2.setTotal(6543.74);
		cart2.setItems(itemsSet);
		
		Set<Cart> carts = new HashSet<Cart>();
		carts.add(cart);
		carts.add(cart2);
		
		/*item1.setCarts(carts);
		item2.setCarts(carts);*/
		
		return carts;
	}
}
