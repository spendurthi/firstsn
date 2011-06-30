package com.firstsn.web.struts;

import com.firstsn.admin.dao.OrganizationDao;
import com.opensymphony.xwork2.ActionSupport;

public class Organization extends ActionSupport {
	private com.firstsn.admin.vo.Organization org;
	public com.firstsn.admin.vo.Organization getOrg() {
		return org;
	}

	public void setOrg(com.firstsn.admin.vo.Organization org) {
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
