package com.sixcapital.mybatis.mapper;

import com.sixcapital.mybatis.entity.Department;
import com.sixcapital.mybatis.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * Created by mo on 2020/9/2
 */
public class DepartmentMapperTest {

    @Test
    public void getDepartmentsTest() {
        //获取sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //获取Mapper对象
        DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);

        List<Department> departments = mapper.getDepartments();
        departments.forEach(d -> System.out.println(d));

        sqlSession.close();

    }
}
