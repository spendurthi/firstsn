package com.firstsn.admin.dao;

import java.util.Collection;

import com.firstsn.admin.parents.ValueObject;

public interface Crud {
	public int save(ValueObject vo);
	public Collection<ValueObject> select();
	public ValueObject select(int id);
	public ValueObject select(String id);
	public int update(ValueObject vo);
	public int delete(ValueObject vo);
	
}
