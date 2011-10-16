package com.standone.spring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.standone.parents.BaseDao;
import com.standone.parents.Crud;
import com.standone.parents.ValueObject;
import com.standone.spring.vo.DesignationVo;

public class DesignationsDao extends BaseDao implements Crud {

	@Override
	public int delete(ValueObject vo) {
		final DesignationVo lVo=(DesignationVo)vo;
		final String sql="DELETE FROM PUBLIC.DESIGNATIONS WHERE DESIG_ID=?";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		int i=template.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(
					Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sql);
				ps.setInt(1, lVo.getDesigId());
				return ps;
			}
		}, keyHolder);
		return i;
	}

	@Override
	public int save(ValueObject vo) {
		final DesignationVo lVo=(DesignationVo)vo;
		final String sql="INSERT INTO PUBLIC.DESIGNATIONS (DESIG_ID, DESIG_NAME, DEPT_ID) VALUES (?,?,?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		int i=template.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(
					Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sql);
				ps.setInt(1, lVo.getDesigId());
				ps.setString(2, lVo.getDesigName());
				ps.setInt(3, lVo.getDeptId());
				return ps;
			}
		}, keyHolder);
		return i;
	}

	@Override
	public List<ValueObject> select() {
		final String sql="SELECT DESIG_ID,DESIG_NAME,DEPT_ID FROM PUBLIC.DESIGNATIONS ";
		RowMapper row=new RowMapper() {
			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				DesignationVo desig=new DesignationVo();
				desig.setDesigId((int)rs.getInt("DESIG_ID"));
				desig.setDesigName(rs.getString("DESIG_NAME"));
				desig.setDeptId(rs.getInt("DEPT_ID"));
				return desig;
			}
		};
		return (List<ValueObject>)template.query(sql,row);
	}

	@Override
	public ValueObject select(int id) {
		final String sql="SELECT DESIG_ID,DESIG_NAME,DEPT_ID FROM PUBLIC.DESIGNATIONS WHERE DESIG_ID=? ";
		RowMapper row=new RowMapper() {
			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				DesignationVo desig=new DesignationVo();
				desig.setDesigId((int)rs.getInt("DESIG_ID"));
				desig.setDesigName(rs.getString("DESIG_NAME"));
				desig.setDeptId(rs.getInt("DEPT_ID"));
				return desig;
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
		final DesignationVo lVo=(DesignationVo)vo;
		final String sql="UPDATE PUBLIC.DESIGNATIONS SET DESIG_ID = ?,	DESIG_NAME = ?,DEPT_ID = ? WHERE DESIG_ID = ?";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		int i=template.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(
					Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sql);
				ps.setInt(1, lVo.getDesigId());
				ps.setString(2, lVo.getDesigName());
				ps.setInt(3, lVo.getDeptId());
				ps.setInt(4, lVo.getDesigId());
				return ps;
			}
		}, keyHolder);
		return i;
	}

}
