package com.sog.hibernate.util;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static final SessionFactory sessionFactory;
	private static Configuration config;
	static {
		try {
			config=new Configuration();
			sessionFactory = config.configure()
					.buildSessionFactory();
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
}