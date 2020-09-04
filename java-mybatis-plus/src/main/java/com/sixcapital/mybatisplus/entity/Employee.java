package com.sixcapital.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.TableField;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by mo on 2020/8/31
 */
public class Employee {

    //雇员编号
    private int empno;
    //雇员姓名
    private String ename;
    //雇员职位
    private String job;
    //雇员上级编号
    private int mgr;
    //雇佣日期
    private Date hiredate;
    //薪资
    private BigDecimal sal;
    //部门编号
    private int deptnu;
    //所属部门
    @TableField(exist = false)
    private Department department;

    public Employee() {
    }

    public Employee(int empno, String ename, String job, int mgr, Date hiredate, BigDecimal sal, int deptnu) {
        this.empno = empno;
        this.ename = ename;
        this.job = job;
        this.mgr = mgr;
        this.hiredate = hiredate;
        this.sal = sal;
        this.deptnu = deptnu;
    }

    public Employee(int empno, String ename, String job, int mgr, Date hiredate, BigDecimal sal, int deptnu, Department Department) {
        this.empno = empno;
        this.ename = ename;
        this.job = job;
        this.mgr = mgr;
        this.hiredate = hiredate;
        this.sal = sal;
        this.deptnu = deptnu;
        this.department = department;
    }

    public int getEmpno() {
        return empno;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getMgr() {
        return mgr;
    }

    public void setMgr(int mgr) {
        this.mgr = mgr;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public BigDecimal getSal() {
        return sal;
    }

    public void setSal(BigDecimal sal) {
        this.sal = sal;
    }

    public int getDeptnu() {
        return deptnu;
    }

    public void setDeptnu(int deptnu) {
        this.deptnu = deptnu;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empno=" + empno +
                ", ename='" + ename + '\'' +
                ", job='" + job + '\'' +
                ", mgr=" + mgr +
                ", hiredate=" + hiredate +
                ", sal=" + sal +
                ", deptnu=" + deptnu +
                ", department=" + department +
                '}';
    }
}
