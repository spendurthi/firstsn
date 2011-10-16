package com.standone.test;

import junit.framework.TestCase;

import org.hibernate.classic.Session;

import com.sog.hibernate.util.HibernateUtil;
import com.sog.hibernate.vo.User;

public class UserTest extends TestCase {
	private Session session;
	@Override
	protected void setUp() throws Exception {		
		session = HibernateUtil.getSessionFactory().openSession();
	}

	@Override
	protected void tearDown() throws Exception {
		session.close();
	}
	public void testAdd(){
		User user = new User();
		user.setUserId("Stand One 1");
		user.setPassword("password1");
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
	}
	public void testUpdate(){
		User user = new User();
		user.setUserId("Stand One 1");
		user.setPassword("password1cnahge");
		session.beginTransaction();
		session.update(user);
		session.getTransaction().commit();
	}
	public void testGet(){
		User user = new User();
		session.beginTransaction();
		user=(User) session.get(User.class,"1");
		System.out.println(user.getUserId());
		System.out.println(user.getPassword());
	
	}
	public void testLoad(){
		User user = new User();
		session.beginTransaction();
		user=(User) session.load(User.class,"1");
		System.out.println(user.getUserId());
		System.out.println(user.getPassword());
	}
	public void testUpdateAfterGet(){
		User user = new User();
		session.beginTransaction();
		user=(User) session.get(User.class,"1");
		user.setPassword("phani");
		session.getTransaction().commit();
	}

}
