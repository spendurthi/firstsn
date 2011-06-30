package com.firstsn.web.spring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

public class Organization extends org.springframework.web.servlet.mvc.SimpleFormController  {
	private com.firstsn.admin.vo.Organization org;
	public com.firstsn.admin.vo.Organization getOrg() {
		return org;
	}
	public void setOrg(com.firstsn.admin.vo.Organization org) {
		this.org = org;
	}
	private String orgName;
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		System.out.println(orgName);
		return new ModelAndView("organization");
	}

}
