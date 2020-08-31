package com.sixcapital.mybatis.mapper;

import com.sixcapital.mybatis.entity.Employee;

import java.util.List;

/**
 * Created by mo on 2020/8/31
 */
public interface EmployeeMapper {
    List<Employee> getEmployeelist();

    Employee getEmployeeByEmpno(int empNo);

    int addEmployee(Employee employee);

    int updateEmployee(Employee employee);

    int deleteEmployee(int empNo);
}
