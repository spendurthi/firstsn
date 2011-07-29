package com.standone.app.manager;

import java.util.List;

import com.firstsn.admin.vo.DepartmentVo;
import com.standone.app.spring.dept.dao.DepartmentsDao;

public class DepartmentManager {
	private DepartmentsDao dao;	
	public void setDao(DepartmentsDao dao) {
		this.dao = dao;
	}
	public com.firstsn.admin.vo.DepartmentVo getDepartment(Long id){
		return dao.getDepartment(id);
	}
	public List<DepartmentVo> getAll(){
		return dao.getAll();
	}
}
