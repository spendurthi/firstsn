package com.standone.web.manager;

import java.util.List;

import com.standone.spring.dao.EmployeeDao;
import com.standone.spring.vo.EmployeeVo;

public class EmployeeManager {
	private EmployeeDao dao;

	public void setDao(EmployeeDao dao) {
		this.dao = dao;
	}
	public int delete(EmployeeVo vo) {
		return dao.delete(vo);
	}
	public int save(EmployeeVo vo) {
		return dao.save(vo);
	}
	public List<EmployeeVo> select() {
		return (List)dao.select();
	}
	public EmployeeVo select(int id) {
		return (EmployeeVo) dao.select(id);
	}
	public int update(EmployeeVo vo) {
		return dao.update(vo);
	}
}
