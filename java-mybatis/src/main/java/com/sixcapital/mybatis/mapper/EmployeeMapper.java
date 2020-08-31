package com.sixcapital.mybatis.mapper;

import com.sixcapital.mybatis.entity.Employee;

import java.util.List;
import java.util.Map;

/**
 * Created by mo on 2020/8/31
 */
public interface EmployeeMapper {
    List<Employee> getEmployeelist();

    Employee getEmployeeByEmpno(int empNo);

    int addEmployee(Employee employee);

    int updateEmployee(Employee employee);

    int deleteEmployee(int empNo);

    int updateEmployee2(Map<String, Object> map);

    List<Employee> getEmployeeLike(String name);
}
