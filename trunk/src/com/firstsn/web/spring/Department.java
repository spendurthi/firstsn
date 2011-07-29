package com.firstsn.web.spring;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.firstsn.admin.vo.DepartmentVo;
import com.standone.app.manager.DepartmentManager;

public class Department extends MultiActionController {
	private DepartmentManager manager;
	public void setManager(DepartmentManager manager) {
		this.manager = manager;
	}
	public ModelAndView listDepartments(HttpServletRequest request, HttpServletResponse response){
		List<DepartmentVo> listOfDepts=manager.getAll();
		return new ModelAndView("department","listOfDepts",listOfDepts);
	}
}
