package com.firstsn.admin.vo;

import java.util.HashSet;
import java.util.Set;

import com.firstsn.admin.parents.ValueObject;

public class Department extends ValueObject {
    private int deptId;
    private String deptName;
    private Set<Employee> employees=new HashSet<Employee>(); 
    public void addEmployee(Employee emp){
       getEmployees().add(emp);
    }
    public Set<Employee> getEmployees() {
        return employees;
    }
    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
    public int getDeptId() {
        return deptId;
    }
    public Department(){
        
    }
    public Department(String deptName) {
        super();
        this.deptName = deptName;
    }
    public Department(int deptId, String deptName) {
        super();
        this.deptId = deptId;
        this.deptName = deptName;
    }
    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }
    public String getDeptName() {
        return deptName;
    }
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
    @Override
    public String toString() {
        String s="DeptId: "+deptId+" Dept Name: "+deptName;        
        return s;
    }
}
