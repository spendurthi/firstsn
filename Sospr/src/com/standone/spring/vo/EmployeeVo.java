package com.standone.spring.vo;

import com.standone.parents.ValueObject;

public class EmployeeVo extends ValueObject{
    private int empId;
    private String empName;
    private int deptId;
    public int getEmpId() {
        return empId;
    }
    public EmployeeVo() {
        super();
    }
    public EmployeeVo(String empName, int deptId) {
        super();
        this.empName = empName;
        this.deptId = deptId;
    }
    public EmployeeVo(int empId, String empName, int deptId) {
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
    public int getDeptId() {
        return deptId;
    }
    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }
    @Override
    public String toString() {
        String s="Emp Id :"+empId+" Employee Name: "+empName+" Department: "+deptId;
        return s;
    }
}
