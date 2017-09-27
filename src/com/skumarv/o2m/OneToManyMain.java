package com.skumarv.o2m;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;

import com.skumarv.util.HibernateAnnotationUtil;

public class OneToManyMain {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateAnnotationUtil
				.getSessionFactory();
		try {
			Session session = sessionFactory.openSession();
			Transaction trans = session.beginTransaction();

			//session.persist(getData());
			/*Cart cart = (Cart) session.get(Cart.class, new Long(3));
			Set<Items> items = setOfItems(cart);
			cart.setItems(items);
			session.saveOrUpdate(cart);*/
			
			/*Cart cart = new Cart();
			cart.setName("Cart Name");
			cart.setTotal(765.64);
			session.persist(cart);*/
			
			DetachedCriteria maxId = DetachedCriteria.forClass(Items.class)
				    .setProjection( Projections.max("total") );
			List<Items> ls = session.createCriteria(Items.class)
				    .add( Property.forName("total").eq(maxId) )
				    .list();
			
			for (Items items : ls) {
				System.out.println(items);
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

	public static Set<Items> setOfItems(Cart cart) {
		Set<Items> itemsSet = new HashSet<Items>();
		Items items = new Items();
		items.setName("Item 33");
		items.setQuantity(2);
		items.setTotal(127.87);
		items.setCart(cart);
		itemsSet.add(items);
		
		
		items = new Items();
		items.setName("Item 44");
		items.setQuantity(4);
		items.setTotal(764.32);
		items.setCart(cart);
		itemsSet.add(items);
		
		return itemsSet;
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
