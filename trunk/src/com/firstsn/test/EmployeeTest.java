package com.firstsn.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import com.firstsn.admin.Employee;
import com.firstsn.admin.util.HibernateUtil;

public class EmployeeTest {

    public static void main(String[] args) {
        // Add employee
        DepartmentTest.viewDepartment(3);
        Employee e1=new Employee("Ram", DepartmentTest.viewDepartment(3));
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
