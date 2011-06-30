package com.firstsn.test;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import com.firstsn.admin.util.HibernateUtil;
import com.firstsn.admin.vo.Department;
import com.firstsn.admin.vo.Employee;

public class DepartmentTest {
    public static void addEmployees(Set<com.firstsn.admin.vo.Employee> empList,int deptNo){
        Session session = com.firstsn.admin.util.HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();
        Department dept=viewDepartment(deptNo);    
        dept.setEmployees(empList);
        session.update(dept);   
        transaction.commit();
    }
    
    public static Department addDepartment(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();
        Department dept=new Department(1,"ADMIN");
        session.save(dept);
        transaction.commit();
        return dept;
    }
    public static Department viewDepartment(int deptId){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Department dept=(Department)session.get(Department.class, new Integer(deptId));
        return dept;
    }
    public static List<Department> viewAll(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query=session.createQuery("FROM Department");
        List<Department> depts=query.list();
        return depts;
    }
    public static Department update(Department dept){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();
        Department lDept=(Department)session.get(Department.class, new Integer(dept.getDeptId()));
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
