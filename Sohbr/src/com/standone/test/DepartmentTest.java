package com.standone.test;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import m.standone.hbr.vo.DepartmentVo;
import m.standone.hbr.vo.Employee;

import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import com.standone.hbr.util.HibernateUtil;

public class DepartmentTest {
    public static void addEmployees(Set<m.standone.hbr.vo.Employee> empList,int deptNo){
        Session session = com.standone.hbr.util.HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();
        DepartmentVo dept=viewDepartment(deptNo);    
        dept.setEmployees(empList);
        session.update(dept);   
        transaction.commit();
    }
    
    public static DepartmentVo addDepartment(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();
        DepartmentVo dept=new DepartmentVo(1,"ADMIN");
        session.save(dept);
        transaction.commit();
        return dept;
    }
    public static DepartmentVo viewDepartment(int deptId){
        Session session = HibernateUtil.getSessionFactory().openSession();
        DepartmentVo dept=(DepartmentVo)session.get(DepartmentVo.class, new Integer(deptId));
        return dept;
    }
    public static List<DepartmentVo> viewAll(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query=session.createQuery("FROM Department");
        List<DepartmentVo> depts=query.list();
        return depts;
    }
    public static DepartmentVo update(DepartmentVo dept){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();
        DepartmentVo lDept=(DepartmentVo)session.get(DepartmentVo.class, new Integer(dept.getDeptId()));
        lDept.setDeptId(dept.getDeptId());
        lDept.setDeptName(dept.getDeptName());
        session.update(lDept);
        transaction.commit();
        return lDept;
    }
    public static void main(String[] args) {        
        addDepartment();
        //viewDepartment(2);
        //viewAll();
        // Update department
        //Department d1=new Department(4,"Customer Service");
        //System.out.println(update(d1));
        // Add employees to a department
//        Department d=viewDepartment(3);
//        for (Iterator iterator = d.getEmployees().iterator(); iterator.hasNext();) {
//            Employee type = (Employee) iterator.next();
//            System.out.println(type);
//            
//        }
    }
    

}
