package com.sixcapital.mybatis.mapper;

import com.sixcapital.mybatis.entity.Employee;
import com.sixcapital.mybatis.utils.MybatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mo on 2020/8/31
 */
public class EmployeeMapperTest {

    static Logger logger = Logger.getLogger(EmployeeMapperTest.class);

    @Test
    public void getEmployeelistTest() {
        //获取sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //获取Mapper对象
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        List<Employee> employeelist = mapper.getEmployeelist();

        employeelist.forEach(e -> System.out.println(e));
        //关闭sqlSession
        sqlSession.close();
    }

    @Test
    public void getEmployeeByEmpnoTest() {
        //获取sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //获取Mapper对象
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee employee = mapper.getEmployeeByEmpno(1002);

        System.out.println(employee);
        //关闭sqlSession
        sqlSession.close();
    }

    @Test
    public void addEmployeeTest() {
        //获取sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //获取Mapper对象
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee employee = new Employee(1109, "奥巴马333", "经理", 1006, new Date(), new BigDecimal(16000), 20);
        int result = mapper.addEmployee(employee);

        if (result > 0) {
            System.out.println("添加员工操作成功");
        }

        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updateEmployeeTest() {
        //获取sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //获取Mapper对象
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

        int result = mapper.updateEmployee(new Employee(1108, "奥巴马22", "工程师", 1006, new Date(), new BigDecimal(16000), 20));
        if (result > 0) {
            System.out.println("修改员工操作成功");
        }

        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteEmployeeTest() {
        //获取sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //获取Mapper对象
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

        int result = mapper.deleteEmployee(1108);
        if (result > 0) {
            System.out.println("删除员工操作成功");
        }

        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updateEmployee2Test() {
        //获取sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //获取Mapper对象
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

        Map<String, Object> map = new HashMap<>();
        map.put("id", 1108);
        map.put("name", "奥巴马222");
        map.put("job", "工程师");

        int result = mapper.updateEmployee2(map);
        if (result > 0) {
            System.out.println("更新员工操作成功");
        }

        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void getEmployeeLikeTest() {
        //获取sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //获取Mapper对象
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        List<Employee> employees = mapper.getEmployeeLike("%奥%");

        employees.forEach(e -> System.out.println(e));
        sqlSession.close();
    }

    @Test
    public void getEmployeeByLimitTest() {
        //获取sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //获取Mapper对象
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

        Map<String, Integer> map = new HashMap<>();
        map.put("startIndex", 0);
        map.put("pageSize", 2);

        List<Employee> employees = mapper.getEmployeeByLimit(map);
        employees.forEach(e -> System.out.println(e));
        sqlSession.close();
    }

    @Test
    public void getEmployeeByRowBoundsTest() {
        //获取sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //获取Mapper对象
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        //RowBounds实现分页
        RowBounds rowBounds = new RowBounds(1, 2);

        List<Employee> employees = sqlSession.selectList("com.sixcapital.mybatis.mapper.EmployeeMapper.getEmployeeByRowBounds",
                null, rowBounds);

        employees.forEach(e -> System.out.println(e));
        sqlSession.close();
    }

    @Test
    public void getEmployeeDetailTest() {
        //获取sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //获取Mapper对象
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

        List<Employee> employees = mapper.getEmployeeDetail();
        employees.forEach(e -> System.out.println(e));

        sqlSession.close();
    }

    @Test
    public void getEmployeeDetailWithJoinTest() {
        //获取sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //获取Mapper对象
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

        List<Employee> employees = mapper.getEmployeeDetailWithJoin();
        employees.forEach(e -> System.out.println(e));

        sqlSession.close();
    }

    @Test
    public void getEmployeeIfTest() {
        //获取sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //获取Mapper对象
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

        Map<Object, Object> map = new HashMap<>();
        map.put("job", "经理");
        map.put("ename", "%奥%");

        List<Employee> employees = mapper.getEmployeeIf(map);
        employees.forEach(e -> System.out.println(e));

        sqlSession.close();
    }

    @Test
    public void getEmployeeChooseTest() {
        //获取sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //获取Mapper对象
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

        Map<Object, Object> map = new HashMap<>();
        map.put("job", "经理");
        map.put("ename", "奥巴马333");
        map.put("sal", new BigDecimal(16000));

        List<Employee> employees = mapper.getEmployeeChoose(map);
        employees.forEach(e -> System.out.println(e));

        sqlSession.close();
    }


    @Test
    public void log4jTest() {
        logger.info("info:进入了log4jTest");
        logger.debug("debug:进入了log4jTest");
        logger.error("error:进入了log4jTest");
    }
}
