package com.standone.app.spring.dept.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.firstsn.admin.vo.DepartmentVo;

public class DepartmentsDao {
	private JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	public DepartmentVo getDepartment(Long id){
		String sql="SELECT DEPT_ID,DEPT_NAME FROM PUBLIC.DEPARTMENT WHERE DEPT_ID=? ";
		RowMapper row=new RowMapper() {
			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				DepartmentVo dept=new DepartmentVo();
				dept.setDeptId((int)rs.getLong("DEPT_ID"));
				dept.setDeptName(rs.getString("DEPT_NAME"));				
				return dept;
			}
		};
		return (DepartmentVo)template.queryForObject(sql, new Object[] {Long.valueOf(id)},row);
	}
	public List<DepartmentVo> getAll(){
		String sql="SELECT DEPT_ID,DEPT_NAME FROM PUBLIC.DEPARTMENT";
		RowMapper row=new RowMapper() {
			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				DepartmentVo dept=new DepartmentVo();
				dept.setDeptId((int)rs.getLong("DEPT_ID"));
				dept.setDeptName(rs.getString("DEPT_NAME"));				
				return dept;
			}
		};
		return template.query(sql,row);
	}
}
