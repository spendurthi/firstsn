package com.standone.spring.vo;

import java.sql.Blob;

import com.standone.parents.ValueObject;

public class Organization extends ValueObject {
	private int orgId;
	private String orgName;
	private Blob orgLogo;
	public Organization(){
		super();
	}
	public Organization(int orgId) {
		super();
		this.orgId = orgId;
	}
	public Organization(int orgId, String orgName) {
		super();
		this.orgId = orgId;
		this.orgName = orgName;
	}
	public Organization(int orgId, String orgName, Blob orgLogo) {
		super();
		this.orgId = orgId;
		this.orgName = orgName;
		this.orgLogo = orgLogo;
	}
	public int getOrgId() {
		return orgId;
	}
	public void setOrgId(int orgId) {
		this.orgId = orgId;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public Blob getOrgLogo() {
		return orgLogo;
	}
	public void setOrgLogo(Blob orgLogo) {
		this.orgLogo = orgLogo;
	}
}
