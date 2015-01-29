package com.standone.hbr.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

public class HibernateUtil {
	private static final SessionFactory sessionFactory;
	private static Configuration config;
	static {
		try {
			config=new Configuration();
			sessionFactory = config.configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public static void addClass(Class className){
		config.addClass(className);
	}
	public static Session getHbrSession(){
		Session session = sessionFactory.getCurrentSession();
		if (session == null){
			session = sessionFactory.openSession();
		}
		return session;
	}
}