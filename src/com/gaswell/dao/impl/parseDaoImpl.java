package com.gaswell.dao.impl;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.gaswell.dao.parseDao;
import com.gaswell.util.binaryToPicUtil;
import com.gaswell.util.hibernateutil;

@Component("parsedao")
@Resource(name = "sessionFactory")
public class parseDaoImpl implements parseDao{
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	

	public void saveEntity(Object object) {
		// TODO Auto-generated method stub
		SessionFactory factory = hibernateutil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		session.save(object);
		session.getTransaction().commit();
	}

	public String editPic(String dataPic, String gasWellName) {
		// TODO Auto-generated method stub
		binaryToPicUtil btpu = new binaryToPicUtil();
		String picPath = btpu.saveImage(dataPic, gasWellName, "jpg");
		return picPath;
	}
	
}
