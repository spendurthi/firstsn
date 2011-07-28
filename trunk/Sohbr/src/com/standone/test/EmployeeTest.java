package com.standone.test;

import java.util.List;

import m.standone.hbr.vo.Employee;

import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import com.standone.hbr.util.HibernateUtil;

public class EmployeeTest {

    public static void main(String[] args) {
        // Add employee
        DepartmentTest.viewDepartment(3);
        Employee e1=new Employee("Surya", DepartmentTest.viewDepartment(1));
        addEmployee(e1);

    }
    public static Employee addEmployee(Employee emp){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();
        session.save(emp);
        transaction.commit();
        return emp;
    }
    public static List<Employee> viewAll(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query=session.createQuery("FROM Employee");
        return query.list();
    }

}
