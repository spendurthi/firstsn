package com.standone.spring.vo;

import com.standone.parents.ValueObject;

public class DropDownVo extends ValueObject {
	private String departments;
	private String designations;
	public String getDepartments() {
		return departments;
	}
	public void setDepartments(String departments) {
		this.departments = departments;
	}
	public String getDesignations() {
		return designations;
	}
	public void setDesignations(String designations) {
		this.designations = designations;
	}
}
