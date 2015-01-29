package com.standone.hbr.dao;

import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Order;

import com.standone.hbr.parents.ValueObject;
import com.standone.hbr.util.HibernateUtil;
import com.standone.hbr.vo.User;

public class LoginDao implements Crud {

	@Override
	public int delete(ValueObject vo) {
		int returnValue=1;
		try{
			Session session = HibernateUtil.getHbrSession();
			Transaction tx=session.beginTransaction();
			User dbUser = (User)vo;
			session.delete(dbUser);
			tx.commit();
		}catch(Exception e){
			returnValue=-1;
			e.printStackTrace();
		}
		return returnValue;
	}

	@Override
	public int save(ValueObject vo) {
		int returnValue=1;
		try{
			Session session = HibernateUtil.getHbrSession();
			Transaction tx=session.beginTransaction();
			User dbUser = (User)vo;
			session.save(dbUser);
			tx.commit();
		}catch(Exception e){
			returnValue=-1;
			e.printStackTrace();
		}
		return returnValue;
	}

	@Override
	public Collection<ValueObject> select() {
		Session session = HibernateUtil.getHbrSession();
		Criteria criteria =session.createCriteria(User.class);
		List lov=criteria.addOrder(Order.asc("USER_ID")).list();
		return lov;
	}

	@Override
	public ValueObject select(int id) {
		return null;
	}

	@Override
	public ValueObject select(String id) {
		Session session = HibernateUtil.getHbrSession();
		session.beginTransaction();
		User user=(User)session.get(User.class, id);		
		return user;
	}

	@Override
	public int update(ValueObject vo) {
		int returnValue=1;
		try{
			Session session = HibernateUtil.getHbrSession();
			Transaction tx=session.beginTransaction();
			User dbUser = (User)vo;
			session.update(dbUser);
			tx.commit();
		}catch(Exception e){
			returnValue=-1;
			e.printStackTrace();
		}
		return returnValue;
	}
}
