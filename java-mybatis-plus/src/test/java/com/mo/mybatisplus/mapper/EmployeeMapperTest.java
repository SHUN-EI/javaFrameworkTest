package com.mo.mybatisplus.mapper;

import com.mo.mybatisplus.entity.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Date;
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

    @Test
    public void queryEmployeeByIdTest(){
        Employee employee = employeeMapper.selectById(1109);
        System.out.println(employee);
    }

    @Test
    public void addEmployeeTest() {

        Employee employee = new Employee();
        employee.setEmpno(1123);
        employee.setEname("奥巴马667");
        employee.setJob("经理");
        employee.setHiredate(new Date());
        employee.setSal(new BigDecimal(16000));
        employee.setDeptnu(20);
        employee.setMgr(1006);

        int result = employeeMapper.insert(employee);

        if (result > 0) {
            System.out.println("添加员工操作成功");
        }
    }

    @Test
    public void updateEmployeeTest() {
        Employee employee = new Employee();
        employee.setEmpno(1121);
        employee.setEname("奥巴马638");

        int result = employeeMapper.updateById(employee);
        if (result > 0) {
            System.out.println("更新员工操作成功");
        }
    }
    
    @Test
    public void deleteEmployeeTest(){
        int result = employeeMapper.deleteById(1110);
        if (result > 0) {
            System.out.println("删除员工操作成功");
        }
    }
}
