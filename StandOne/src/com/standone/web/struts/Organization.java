package com.standone.web.struts;

import com.opensymphony.xwork2.ActionSupport;
import com.standone.hbr.dao.OrganizationDao;

public class Organization extends ActionSupport {
	private m.standone.hbr.vo.Organization org;
	public m.standone.hbr.vo.Organization getOrg() {
		return org;
	}

	public void setOrg(m.standone.hbr.vo.Organization org) {
		this.org = org;
	}
	public String saveOrganization(){
		OrganizationDao organizationDao=new OrganizationDao();
		org.setOrgId(2);
		org.setOrgName("Surya");
		organizationDao.save(org);
		return SUCCESS;
	}
	public String select(){
		return SUCCESS;
	}
}
