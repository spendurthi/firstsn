package com.firstsn.admin.vo;

import com.firstsn.admin.parents.ValueObject;

public class Employee extends ValueObject{
    private int empId;
    private String empName;
    private Department deptId;
    public int getEmpId() {
        return empId;
    }
    public Employee() {
        super();
    }
    public Employee(String empName, Department deptId) {
        super();
        this.empName = empName;
        this.deptId = deptId;
    }
    public Employee(int empId, String empName, Department deptId) {
        super();
        this.empId = empId;
        this.empName = empName;
        this.deptId = deptId;
    }
    public void setEmpId(int empId) {
        this.empId = empId;
    }
    public String getEmpName() {
        return empName;
    }
    public void setEmpName(String empName) {
        this.empName = empName;
    }
    public Department getDeptId() {
        return deptId;
    }
    public void setDeptId(Department deptId) {
        this.deptId = deptId;
    }
    @Override
    public String toString() {
        String s="Emp Id :"+empId+" Employee Name: "+empName+" Department: "+deptId.getDeptName();
        return s;
    }
}
