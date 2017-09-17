package com.skumarv.o2m;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.skumarv.util.HibernateAnnotationUtil;

public class OneToManyMain {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateAnnotationUtil
				.getSessionFactory("com/skumarv/o2m/hibernate.cfg.xml");
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

	public static Cart getData() {
		Cart cart = new Cart();
		cart.setName("Cart Name");
		cart.setTotal(1763.76);
		
		Set<Items> itemsSet = new HashSet<Items>();
		Items items = new Items();
		items.setName("Item 1");
		items.setQuantity(2);
		items.setTotal(127.87);
		items.setCart(cart);
		itemsSet.add(items);
		
		
		items = new Items();
		items.setName("Item 2");
		items.setQuantity(4);
		items.setTotal(764.32);
		items.setCart(cart);
		itemsSet.add(items);
		
		cart.setItems(itemsSet);

		return cart;
	}
}