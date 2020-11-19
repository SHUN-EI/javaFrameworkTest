package com.mo.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.TableField;

import java.util.List;

/**
 * Created by mo on 2020/9/2
 */
public class Department {

    //部门编号
    private int deptnu;
    //部门名称
    private String dname;
    //部门地址
    private String addr;
    //员工
    @TableField(exist = false)
    private List<Employee> employees;

    public Department() {
    }

    public Department(int deptnu, String dname, String addr) {
        this.deptnu = deptnu;
        this.dname = dname;
        this.addr = addr;
    }

    public Department(int deptnu, String dname, String addr, List<Employee> employees) {
        this.deptnu = deptnu;
        this.dname = dname;
        this.addr = addr;
        this.employees = employees;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public int getDeptnu() {
        return deptnu;
    }

    public void setDeptnu(int deptnu) {
        this.deptnu = deptnu;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    @Override
    public String toString() {
        return "Department{" +
                "deptnu=" + deptnu +
                ", dname='" + dname + '\'' +
                ", addr='" + addr + '\'' +
                ", employees=" + employees +
                '}';
    }
}
