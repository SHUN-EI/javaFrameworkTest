package com.sixcapital.mybatisplus.mapper;

import com.sixcapital.mybatisplus.entity.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * Created by mo on 2020/9/4
 */
@SpringBootTest
public class EmployeeMapperTest {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Test
    public void getEmployeesTest() {

        List<Employee> employees = employeeMapper.selectList(null);
        employees.forEach(System.out::println);

    }
}
