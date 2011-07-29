package com.standone.web.spring;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.standone.spring.vo.DesignationVo;
import com.standone.spring.vo.EmployeeVo;
import com.standone.web.manager.EmployeeManager;

public class Employee extends MultiAction {
	private String viewName;
	private String valueName;
	private EmployeeManager manager;
	public void setViewName(String viewName) {
		this.viewName = viewName;
	}
	public void setValueName(String valueName) {
		this.valueName = valueName;
	}
	
	public void setManager(EmployeeManager manager) {
		this.manager = manager;
	}
	public ModelAndView listEmployees(HttpServletRequest request, HttpServletResponse response){
		List<EmployeeVo> listOfEmps=manager.select();
		return new ModelAndView(viewName,valueName,listOfEmps);
	}
	public ModelAndView addEmployee(HttpServletRequest request, HttpServletResponse response,EmployeeVo employeeVo){
		manager.save(employeeVo);
		List<EmployeeVo> listOfEmps=manager.select();
		return new ModelAndView(viewName,valueName,listOfEmps);
	}
	public ModelAndView updateEmployee(HttpServletRequest request, HttpServletResponse response,EmployeeVo employeeVo){
		manager.update(employeeVo);
		List<EmployeeVo> listOfEmps=manager.select();
		return new ModelAndView(viewName,valueName,listOfEmps);
	}
	public ModelAndView deleteEmployee(HttpServletRequest request, HttpServletResponse response,EmployeeVo employeeVo){
		manager.delete(employeeVo);
		List<EmployeeVo> listOfEmps=manager.select();		
		return new ModelAndView(viewName,valueName,listOfEmps);
	}
	public ModelAndView updateMode(HttpServletRequest request, HttpServletResponse response){
		int empId=Integer.valueOf(request.getParameter("empId"));
		EmployeeVo vo=manager.select(empId);
		return new ModelAndView(viewName,"empVo",vo);
	}
}
