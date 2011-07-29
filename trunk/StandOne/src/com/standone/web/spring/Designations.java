package com.standone.web.spring;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.standone.spring.vo.DepartmentVo;
import com.standone.spring.vo.DesignationVo;
import com.standone.web.manager.DesignationManager;

public class Designations extends MultiAction {
	private String viewName;
	private String valueName;
	private DesignationManager manager;
	public void setViewName(String viewName) {
		this.viewName = viewName;
	}
	public void setValueName(String valueName) {
		this.valueName = valueName;
	}
	public void setManager(DesignationManager manager) {
		this.manager = manager;
	}
	public ModelAndView listDesignations(HttpServletRequest request, HttpServletResponse response){
		List<DesignationVo> listOfDesigs=manager.select();
		return new ModelAndView(viewName,valueName,listOfDesigs);
	}
	public ModelAndView addDesignation(HttpServletRequest request, HttpServletResponse response,DesignationVo designationVo){
		manager.save(designationVo);
		List<DesignationVo> listOfDesigs=manager.select();	
		return new ModelAndView(viewName,valueName,listOfDesigs);
	}
	public ModelAndView updateEmployee(HttpServletRequest request, HttpServletResponse response,DesignationVo designationVo){
		manager.update(designationVo);
		List<DesignationVo> listOfDesigs=manager.select();	
		return new ModelAndView(viewName,valueName,listOfDesigs);
	}
	public ModelAndView deleteEmployee(HttpServletRequest request, HttpServletResponse response,DesignationVo designationVo){
		manager.delete(designationVo);
		List<DesignationVo> listOfDesigs=manager.select();		
		return new ModelAndView(viewName,valueName,listOfDesigs);
	}
	public ModelAndView updateMode(HttpServletRequest request, HttpServletResponse response){
		int desigId= Integer.valueOf(request.getParameter("desigId"));
		DesignationVo vo=manager.select(desigId);
		return new ModelAndView(viewName,"desigVo",vo);
	}
}
