package com.standone.web.spring;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import com.standone.spring.vo.DepartmentVo;
import com.standone.web.manager.DepartmentManager;
import com.standone.web.manager.DropDownManager;

public class Department extends MultiAction {
	
	private String viewName;
	private String valueName;
	private DepartmentVo vo;
	
	public ModelAndView listDepartments(HttpServletRequest request, HttpServletResponse response){
		List<DepartmentVo> listOfDepts=manager.getAll();
		ModelAndView mav=new ModelAndView(viewName);
		mav.addObject(valueName, listOfDepts);
		System.out.println("In Departments - "+viewName);
		
		ApplicationContext springContext = (ApplicationContext)request.getSession().getServletContext().getAttribute(
				WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
		if (ddManager==null){
			ddManager = (DropDownManager)springContext.getBean("spDdManager");
		}
		
		mav.addObject("deptDD", ddManager.getDepartmentsDD());
		request.setAttribute(viewName, vo);
		return mav;
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
	@Override
	protected void flushDD() {
		ddManager.flushDepartments();
	}
	
	
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
	
	public void setVo(DepartmentVo vo) {
		this.vo = vo;
	}
	public DepartmentVo getVo() {
		return vo;
	}
	
}
