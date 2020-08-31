package com.sixcapital.mybatis.mapper;

import com.sixcapital.mybatis.entity.Employee;
import com.sixcapital.mybatis.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * Created by mo on 2020/8/31
 */
public class EmployeeMapperTest {

    @Test
    public void testEmployeeMapper() {
        //获取sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //获取Mapper对象
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
         List<Employee> employeelist = mapper.getEmployeelist();

        employeelist.forEach(e -> System.out.println(e));
        //关闭sqlSession
        sqlSession.close();
    }
}
