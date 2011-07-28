package com.standone.web.manager;

import java.util.List;

import com.standone.spring.dao.DepartmentsDao;
import com.standone.spring.vo.DepartmentVo;

public class DepartmentManager {
	private DepartmentsDao dao;	
	public void setDao(DepartmentsDao dao) {
		this.dao = dao;
	}
	public List<DepartmentVo> getAll(){
		return dao.getAll();
	}
	public DepartmentVo getDepartment(Long id){
		return dao.getDepartment(id);
	}
	public int addDepartment(DepartmentVo vo){
		return dao.addDepartment(vo);
	}
	public int updateDepartment(DepartmentVo vo){
		return dao.updateDepartment(vo);
	}
	public int deleteDepartment(DepartmentVo vo){
		return dao.deleteDepartment(vo);
	}
}
