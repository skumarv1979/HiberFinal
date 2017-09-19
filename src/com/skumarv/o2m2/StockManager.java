package com.skumarv.o2m2;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.skumarv.util.HibernateAnnotationUtil;

/**
 * 
 * This program demonstrates using JPA annotations in Hibernate
 * in order to implement a one-to-many association mapping.
 * @author www.codejava.net
 *
 */
public class StockManager {

	public static void main(String[] args) {
		// loads configuration and mappings
		
		// builds a session factory from the service registry
		SessionFactory sessionFactory = HibernateAnnotationUtil
				.getSessionFactory("com/skumarv/o2m2/hibernate.cfg.xml");
		
		// obtains the session
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		/*Category category = new Category("Computer");
		
		Product pc = new Product("DELL PC", "Quad-core PC", 1200, category);
		
		Product laptop = new Product("MacBook", "Apple High-end laptop", 2100, category);
		
		Product phone = new Product("iPhone 5", "Apple Best-selling smartphone", 499, category);
		
		Product tablet = new Product("iPad 3", "Apple Best-selling tablet", 1099, category);
		
		Set<Product> products = new HashSet<Product>();
		products.add(pc);
		products.add(laptop);
		products.add(phone);
		products.add(tablet);
		
		category.setProducts(products);
		
		session.save(category);*/
		
		/*Category category = new Category("Software");
		session.saveOrUpdate(category);
		
		category = new Category("Hardware");
		session.saveOrUpdate(category);*/
		
		Category category = (Category) session.get(Category.class, new Long(2));
		Product bank = new Product("Banking Software", "Banking Calc", 132, category);
		Product game = new Product("Gaming Software", "Temple Run", 654, category);
		Set<Product> products = new HashSet<Product>();
		products.add(bank);
		products.add(game);
		category.setProducts(products);
		session.saveOrUpdate(category);
		
		session.getTransaction().commit();
		session.close();		
	}
}