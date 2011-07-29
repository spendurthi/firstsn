package com.standone.web.manager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.standone.spring.vo.DepartmentVo;
import com.standone.spring.vo.DesignationVo;
import com.standone.spring.vo.DropDownVo;

public class DropDownManager {
	private DropDownVo dropDownVo;
	private DepartmentManager departmentManager;
	private DesignationManager designationManager;
	public DesignationManager getDesignationManager() {
		return designationManager;
	}
	public void setDesignationManager(DesignationManager designationManager) {
		this.designationManager = designationManager;
	}
	public DepartmentManager getDepartmentManager() {
		return departmentManager;
	}
	public void setDepartmentManager(DepartmentManager departmentManager) {
		this.departmentManager = departmentManager;
	}
	public DropDownVo getDropDownVo() {
		return dropDownVo;
	}
	public void setDropDownVo(DropDownVo dropDownVo) {
		this.dropDownVo = dropDownVo;
	}
	public void flushDepartments(){
		String col=":";
		String comma=",";
		
		List<DepartmentVo> deptList=departmentManager.getAll();
		StringBuilder builder=new StringBuilder();
		for(DepartmentVo vo:deptList){
			builder.append(vo.getDeptId());
			builder.append(col);
			builder.append(vo.getDeptName());
			builder.append(comma);
		}
		dropDownVo.setDepartments(builder.toString());
	}
	public void flushDesignations(){
		String col=":";
		String comma=",";
		List<DesignationVo> desigList=designationManager.select();
		StringBuilder builder=new StringBuilder();
		for(DesignationVo vo:desigList){
			builder.append(vo.getDesigId());
			builder.append(col);
			builder.append(vo.getDesigName());
			builder.append(comma);
		}
		dropDownVo.setDesignations(builder.toString());
	}
	public void prepareDropDowns(){
		flushDepartments();
		flushDesignations();
	}
	public Map<String,String> getDepartmentsDD(){
		String[] oneRow=dropDownVo.getDepartments().split(",");
		Map<String,String> dd=new HashMap<String,String>();
		String key=new String();
		String value=new String();
		for(String row:oneRow){
			key = row.split(":")[0];
			value = row.split(":")[1];
			dd.put(key,value);
		}
		return dd;
	}
	public Map<String,String> getDesignationsDD(){
		String[] oneRow=dropDownVo.getDesignations().split(",");
		Map<String,String> dd=new HashMap<String,String>();
		String key=new String();
		String value=new String();
		for(String row:oneRow){
			key = row.split(":")[0];
			value = row.split(":")[1];
			dd.put(key,value);
		}
		return dd;
	}
}
