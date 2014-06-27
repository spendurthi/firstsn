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
import com.standone.parents.Crud;
import com.standone.parents.ValueObject;
import com.standone.spring.vo.EmployeeVo;

public class EmployeeDao extends BaseDao implements Crud {

	@Override
	public int delete(ValueObject vo) {
		final String sql="DELETE FROM EMPLOYEE WHERE EMP_ID=?";
		final EmployeeVo lVo=new EmployeeVo();
		KeyHolder keyHolder = new GeneratedKeyHolder();
		int i=template.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(
					Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
				ps.setInt(1, lVo.getEmpId());
				return ps;
			}
		}, keyHolder);
		return i;
	}

	@Override
	public int save(ValueObject vo) {
		final String sql="INSERT INTO EMPLOYEE (EMP_ID, EMP_NAME,DEPT_ID) VALUES (?,?,?)";
		final EmployeeVo lVo=(EmployeeVo)vo;
		KeyHolder keyHolder = new GeneratedKeyHolder();
		int i=template.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(
					Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
				ps.setInt(1, lVo.getEmpId());
				ps.setString(2, lVo.getEmpName());
				ps.setInt(3, lVo.getDeptId());
				return ps;
			}
		}, keyHolder);
		return i;
	}

	@Override
	public List select() {
		final String sql="SELECT EMP_ID, EMP_NAME,DEPT_ID FROM EMPLOYEE ";
		RowMapper row=new RowMapper() {
			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				EmployeeVo emp=new EmployeeVo();
				emp.setEmpId((int)rs.getInt("EMP_ID"));
				emp.setEmpName(rs.getString("EMP_NAME"));
				emp.setDeptId(rs.getInt("DEPT_ID"));
				return emp;
			}
		};
		return (List<ValueObject>)template.query(sql,row);
	}

	@Override
	public ValueObject select(int id) {
		final String sql="SELECT EMP_ID, EMP_NAME,DEPT_ID FROM EMPLOYEE WHERE EMP_ID=? ";
		RowMapper row=new RowMapper() {
			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				EmployeeVo emp=new EmployeeVo();
				emp.setEmpId((int)rs.getInt("EMP_ID"));
				emp.setEmpName(rs.getString("EMP_NAME"));
				emp.setDeptId(rs.getInt("DEPT_ID"));
				return emp;
			}
		};
		return (ValueObject)template.queryForObject(sql, new Object[] {Long.valueOf(id)},row);
	}

	@Override
	public ValueObject select(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(ValueObject vo) {
		final EmployeeVo lVo=(EmployeeVo)vo;
		final String sql="UPDATE EMPLOYEE SET EMP_ID = ?,	EMP_NAME = ?,DEPT_ID = ? WHERE EMP_ID = ?";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		int i=template.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(
					Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
				ps.setInt(1, lVo.getEmpId());
				ps.setString(2, lVo.getEmpName());
				ps.setInt(3, lVo.getDeptId());
				ps.setInt(4, lVo.getEmpId());
				return ps;
			}
		}, keyHolder);
		return i;
	}

}
