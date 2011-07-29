package com.standone.parents;

import org.springframework.jdbc.core.JdbcTemplate;

public abstract class BaseDao {
	protected JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
}
