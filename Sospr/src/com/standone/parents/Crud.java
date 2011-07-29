package com.standone.parents;

import java.util.List;

public interface Crud {
	public int save(final ValueObject pVo);
	public List select();
	public ValueObject select(final int id);
	public ValueObject select(final String id);
	public int update(final ValueObject pVo);
	public int delete(final ValueObject pVo);
	
}
