package com.skumarv.test.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.skumarv.test.entity.Channel;
import com.skumarv.test.entity.Pack;
import com.skumarv.util.HibernateAnnotationUtil;

public class ChannelDAO {

	public static void main(String[] args) {
		ChannelDAO chnlDao = new ChannelDAO();
		
		 List<Pack> packLst = chnlDao.getPackList(); 
		 for (Pack pack : packLst)
		 { chnlDao.insertPackage(pack); }
		 
		/*Map<Integer, Set<Channel>> mp = chnlDao.getChannels();
		Set<Entry<Integer, Set<Channel>>> entrySet = mp.entrySet();
		for (Entry<Integer, Set<Channel>> entry : entrySet) {
			chnlDao.updateChannels(entry.getKey(), entry.getValue());
		}*/
	}

	public void updateChannels(int packId, Set<Channel> channels) {
		SessionFactory sesFctry = HibernateAnnotationUtil.getSessionFactory();
		Session session = sesFctry.openSession();
		Transaction trans = session.beginTransaction();

		Pack pack = (Pack) session.get(Pack.class, new Integer(packId));
		if (pack != null) {
			pack.setChannels(channels);
			for (Channel channel : channels) {
				channel.setPack(pack);
			}
			session.saveOrUpdate(pack);
		} else {
			System.out.println("Invalid package");
		}

		trans.commit();
		session.close();
	}

	public void insertPackage(Pack pack) {
		SessionFactory sesFctry = HibernateAnnotationUtil.getSessionFactory();
		Session session = sesFctry.openSession();
		Transaction trans = session.beginTransaction();

		session.persist(pack);

		trans.commit();
		session.close();
	}

	public List<Pack> getPackList() {
		List<Pack> packLst = new ArrayList<Pack>();
		Pack pack = new Pack();
		pack.setName("Package 4");
		packLst.add(pack);

		pack = new Pack();
		pack.setName("Package 5");
		packLst.add(pack);

		pack = new Pack();
		pack.setName("Package 6");
		packLst.add(pack);

		return packLst;
	}

	public Map<Integer, Set<Channel>> getChannels() {

		Map<Integer, Set<Channel>> mp = new HashMap<Integer, Set<Channel>>();
		Set<Channel> channels1 = new HashSet<Channel>();
		Channel chnl = new Channel();
		chnl.setName("Channel 1");
		channels1.add(chnl);
		Channel chn2 = new Channel();
		chn2.setName("Channel 2");
		channels1.add(chn2);
		mp.put(1, channels1);

		Set<Channel> channels2 = new HashSet<Channel>();
		Channel chn3 = new Channel();
		chn3.setName("Channel 3");
		channels2.add(chn3);
		Channel chn4 = new Channel();
		chn4.setName("Channel 4");
		channels2.add(chn4);
		mp.put(2, channels2);

		Set<Channel> channels3 = new HashSet<Channel>();
		Channel chn5 = new Channel();
		chn5.setName("Channel 5");
		channels3.add(chn5);
		Channel chn6 = new Channel();
		chn6.setName("Channel 6");
		channels3.add(chn6);
		mp.put(3, channels3);
		return mp;
	}
}
