package com.standone.web.spring;

import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.standone.web.manager.DropDownManager;

public class MultiAction extends MultiActionController {
	protected DropDownManager ddManager;

	public DropDownManager getDdManager() {
		return ddManager;
	}

	public void setDdManager(DropDownManager ddManager) {
		this.ddManager = ddManager;
	}
	protected void flushDD(){
		
	}
}
