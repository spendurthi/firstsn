package com.standone.hbr.dao;

import java.util.Collection;

import org.hibernate.classic.Session;

import com.standone.hbr.parents.ValueObject;
import com.standone.hbr.vo.User;

public class LoginDao implements Crud {

	@Override
	public int delete(ValueObject vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int save(ValueObject vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Collection<ValueObject> select() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ValueObject select(int id) {
		return null;
	}

	@Override
	public ValueObject select(String id) {
		Session session = com.standone.hbr.util.HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		User user=(User)session.get(User.class, id);
		return user;
	}

	@Override
	public int update(ValueObject vo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
