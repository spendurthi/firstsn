package com.standone.test;

import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import com.standone.hbr.util.HibernateUtil;
import com.standone.hbr.vo.Organization;

public class OrganizationTest {
	public static Organization addOrganization(Organization org){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();
        session.save(org);
        transaction.commit();
        return org;
    }
	public static void main(String[] args) {
		Organization org=new Organization(1,"StandOne Group");
		addOrganization(org);

	}

}
