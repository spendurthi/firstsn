package com.firstsn.admin.dao;

import java.util.Collection;

import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import com.firstsn.admin.parents.ValueObject;
import com.firstsn.admin.util.HibernateUtil;
import com.firstsn.admin.vo.Organization;

public class OrganizationDao implements Crud {

	@Override
	public int delete(ValueObject vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int save(ValueObject vo) {
		Organization org=(Organization)vo;
		Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();
        session.save(org);
        transaction.commit();
		return 0;
	}

	@Override
	public Collection<ValueObject> select() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ValueObject select(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ValueObject select(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(ValueObject vo) {
		// TODO Auto-generated method stub
		return 0;
	}
}
