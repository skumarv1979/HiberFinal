package com.skumarv.test.dao;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.skumarv.test.entity.AdditionalChannel;
import com.skumarv.test.entity.AdditionalChannelId;
import com.skumarv.test.entity.Channel;
import com.skumarv.test.entity.Customer;
import com.skumarv.test.entity.Address;
import com.skumarv.test.entity.Pack;
import com.skumarv.util.HibernateAnnotationUtil;

public class CustomerDAO {
	public static void main(String[] args) {
		CustomerDAO custDao = new CustomerDAO();
		/*Customer cust = new Customer();
		cust.setName("Sfsdgdfg");
		Address adress = new Address();
		adress.setAddressLine("AddressLine 1");
		adress.setCity("City 1");
		adress.setStreet("Street 1");
		adress.setState("State 1");
		adress.setPin("123456");
		custDao.insertCustomer(cust, adress);

		cust = new Customer();
		cust.setName("Gdghdfg");
		adress = new Address();
		adress.setAddressLine("AddressLine 2");
		adress.setCity("City 2");
		adress.setStreet("Street 2");
		adress.setState("State 2");
		adress.setPin("895345");
		custDao.insertCustomer(cust, adress);*/
		
		//custDao.subscription(2, 3);
		//custDao.getCustomer(2);
		custDao.subscribeAdditionalChannel(2,2);

	}
	public void subscribeAdditionalChannel(int cuid, int chid) {
		SessionFactory sf = HibernateAnnotationUtil.getSessionFactory();
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();
		
		Customer cust = (Customer) session.get(Customer.class, new Integer(cuid));
		if(cust!=null) {
			Channel channel = (Channel) session.get(Channel.class, new Integer(chid));
			if(channel!=null) {
				Set<Pack> packs = cust.getPacks();
				boolean isAlreadyInPacks = false;
				if(packs!=null && !packs.isEmpty()) {
					for (Pack pack : packs) {
						Set<Channel> channels = pack.getChannels();
						if(channels!=null && !channels.isEmpty()) {
							if(channels.contains(channel)) {
								isAlreadyInPacks = true;
								break;
							}
						}
					}
				}
				if(!isAlreadyInPacks) {
					Calendar endDt = Calendar.getInstance();
					endDt.setTime(new Date());
					endDt.add(Calendar.DATE, 20);
					Date stDt = new Date();
					AdditionalChannel addChann = new AdditionalChannel();
					AdditionalChannelId adChId = new AdditionalChannelId();
					adChId.setChannel(channel);
					adChId.setCust(cust);
					addChann.setPrimary(adChId);
					addChann.setStDate(stDt);
					addChann.setEndDate(endDt.getTime());
					session.saveOrUpdate(addChann);
				}
				else {
					System.out.println("Channel already part of Package");
				}
			}
			else {
				System.out.println("Invalid channel");
			}
		}
		else {
			System.out.println("Invalid customer");
		}
		
		
		trans.commit();
		session.flush();
		session.close();
	}
	public void getCustomer(int cid) {
		SessionFactory sf = HibernateAnnotationUtil.getSessionFactory();
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();
		
		Customer cust = (Customer) session.get(Customer.class, new Integer(cid));
		System.out.println(cust);
		
		trans.commit();
		session.flush();
		session.close();
	}
	public void subscription(int cid, int pid) {
		SessionFactory sf = HibernateAnnotationUtil.getSessionFactory();
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();
		
		Customer cust = (Customer) session.get(Customer.class, new Integer(cid));
		if(cust!=null) {
			Pack pack = (Pack) session.get(Pack.class, new Integer(pid));
			if(pack != null) {
				Set<Pack> packs= cust.getPacks();
				if(packs==null) {
					packs = new HashSet<Pack>();
					cust.setPacks(packs);
				}
				packs.add(pack);
				session.saveOrUpdate(cust);
			}
			else {
				System.out.println("Invalid Package");
			}
		}
		else {
			System.out.println("Invalid customer");
		}
		
		trans.commit();
		session.flush();
		session.close();
	}
	public void insertCustomer(Customer cust, Address address) {
		SessionFactory sf = HibernateAnnotationUtil.getSessionFactory();
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();
		
		cust.setAddress(address);
		session.persist(cust);
		
		trans.commit();
		session.flush();
		session.close();
	}
}
