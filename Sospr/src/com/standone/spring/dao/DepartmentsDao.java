package com.standone.spring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.standone.parents.BaseDao;
import com.standone.spring.vo.DepartmentVo;


public class DepartmentsDao extends BaseDao{
	public DepartmentVo getDepartment(Long id){
		String sql="SELECT DEPT_ID,DEPT_NAME FROM DEPARTMENT WHERE DEPT_ID=? ";
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
		String sql="SELECT DEPT_ID,DEPT_NAME FROM DEPARTMENT";
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
	public int addDepartment(final DepartmentVo vo){
		final String sql="INSERT INTO DEPARTMENT(DEPT_ID,DEPT_NAME) VALUES(?,?) ";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		int i=template.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(
					Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
				ps.setInt(1, vo.getDeptId());
				ps.setString(2, vo.getDeptName());
				return ps;
			}
		}, keyHolder);
		return i;
	}
	public int updateDepartment(final DepartmentVo vo){
		final String sql="UPDATE DEPARTMENT SET DEPT_ID=?,DEPT_NAME=? WHERE DEPT_ID=? ";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		int i=template.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(
					Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
				ps.setInt(1, vo.getDeptId());
				ps.setString(2, vo.getDeptName());
				ps.setInt(3, vo.getDeptId());
				return ps;
			}
		}, keyHolder);
		return i;
	}
	public int deleteDepartment(final DepartmentVo vo){
		final String sql="DELETE FROM DEPARTMENT WHERE DEPT_ID=?";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		int i=template.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(
					Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
				ps.setInt(1, vo.getDeptId());
				return ps;
			}
		}, keyHolder);
		return i;
	}
}
