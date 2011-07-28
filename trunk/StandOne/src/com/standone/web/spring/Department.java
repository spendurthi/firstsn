package com.standone.web.spring;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.standone.spring.vo.DepartmentVo;
import com.standone.web.manager.DepartmentManager;

public class Department extends MultiActionController {
	private String viewName;
	private String valueName;
	public void setViewName(String viewName) {
		this.viewName = viewName;
	}
	public void setValueName(String valueName) {
		this.valueName = valueName;
	}
	private DepartmentManager manager;
	public void setManager(DepartmentManager manager) {
		this.manager = manager;
	}
	public ModelAndView listDepartments(HttpServletRequest request, HttpServletResponse response){
		List<DepartmentVo> listOfDepts=manager.getAll();
		return new ModelAndView(viewName,valueName,listOfDepts);
	}
	public ModelAndView addDepartment(HttpServletRequest request, HttpServletResponse response,DepartmentVo departmentVo){
		manager.addDepartment(departmentVo);
		List<DepartmentVo> listOfDepts=manager.getAll();		
		return new ModelAndView(viewName,valueName,listOfDepts);
	}
	public ModelAndView updateDepartment(HttpServletRequest request, HttpServletResponse response,DepartmentVo departmentVo){
		manager.updateDepartment(departmentVo);
		List<DepartmentVo> listOfDepts=manager.getAll();		
		return new ModelAndView(viewName,valueName,listOfDepts);
	}
	public ModelAndView deleteDepartment(HttpServletRequest request, HttpServletResponse response,DepartmentVo departmentVo){
		manager.deleteDepartment(departmentVo);
		List<DepartmentVo> listOfDepts=manager.getAll();		
		return new ModelAndView(viewName,valueName,listOfDepts);
	}
	public ModelAndView updateMode(HttpServletRequest request, HttpServletResponse response,DepartmentVo departmentVo){
		DepartmentVo vo=manager.getDepartment((long)departmentVo.getDeptId());
		return new ModelAndView(viewName,"deptVo",vo);
	}
}
