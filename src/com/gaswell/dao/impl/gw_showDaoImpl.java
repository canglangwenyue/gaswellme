package com.gaswell.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.gaswell.dao.gw_showDao;
import com.gaswell.entity.gw_show;
import com.gaswell.util.hibernateutil;

@Component("gw")
@Resource(name = "sessionFactory")
public class gw_showDaoImpl implements gw_showDao {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<gw_show> getgaswell() {
		SessionFactory factory = hibernateutil.getSessionFactory();

		Session session = factory.openSession();
		session.beginTransaction();
		session.load(gw_show.class, 1);
		Query query = session.createQuery("from gw_show");
		List<gw_show> list = query.list();
		// System.out.println(gh.getLand_voltage());
		System.out.println(list.get(0).getName());
		return list;
	}
}
