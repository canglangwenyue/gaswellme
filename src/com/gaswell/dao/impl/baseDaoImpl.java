package com.gaswell.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.gaswell.dao.baseDao;
import com.gaswell.entity.gw_show;
import com.gaswell.util.hibernateutil;

@Component("basedao")
@Resource(name = "sessionFactory")
public class baseDaoImpl implements baseDao {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void add(gw_show gh) {
		SessionFactory factory = hibernateutil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();

		session.save(gh);
		session.getTransaction().commit();

	}

	public void update(String name) {

	}

	public boolean checkUserExistsWithName(String gwName) {

		SessionFactory factory = hibernateutil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		long count = (Long) session
				.createQuery(
						"select count(*) from gw_show gh where gh.name = :gwName")
				.setString("gwName", gwName).uniqueResult();
		session.getTransaction().commit();
		if (count > 0) {
			return false;
		}

		return true;
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
