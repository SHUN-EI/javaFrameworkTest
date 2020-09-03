package com.sixcapital.mybatis.mapper;

import com.sixcapital.mybatis.entity.Employee;
import org.apache.ibatis.type.Alias;

import java.util.List;
import java.util.Map;

/**
 * Created by mo on 2020/8/31
 */
//@Alias("Employee")
public interface EmployeeMapper {
    List<Employee> getEmployeelist();

    Employee getEmployeeByEmpno(int empNo);

    int addEmployee(Employee employee);

    int updateEmployee(Employee employee);

    int deleteEmployee(int empNo);

    int updateEmployee2(Map<String, Object> map);

    int updateEmployee3(Map map);

    List<Employee> getEmployeeLike(String name);

    List<Employee> getEmployeeByLimit(Map<String, Integer> map);

    List<Employee> getEmployeeByRowBoundsRowBounds();

    List<Employee> getEmployeeDetail();

    List<Employee> getEmployeeDetailWithJoin();

    List<Employee> getEmployeeIf(Map map);

    List<Employee> getEmployeeIf2(Map map);

    List<Employee> getEmployeeChoose(Map map);

    List<Employee> getEmployeeForEach(Map map);

}
