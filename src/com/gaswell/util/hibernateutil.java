package com.gaswell.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

@SuppressWarnings("deprecation")
public class hibernateutil {

	private static SessionFactory factory;
	static {
		factory = new AnnotationConfiguration().configure().buildSessionFactory();
	}
	public static SessionFactory getSessionFactory() {
		return factory;
	}
	
}
