package com.mo.mybatis.mapper;

import com.mo.mybatis.entity.Department;
import com.mo.mybatis.utils.MybatisUtils;
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

    @Test
    public void getDepartmentByIdTest() {
        //获取sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //获取Mapper对象
        DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);

        Department department = mapper.getDepartmentById(20);
        System.out.println(department);
        sqlSession.close();
    }

    @Test
    public void addDepartmentTest() {
        //获取sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //获取Mapper对象
        DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);

        Department department = new Department(60, "行政部", "南京");

        int result = mapper.addDepartment(department);
        if (result > 0) {
            System.out.println("添加部门操作成功");
        }

        sqlSession.close();
    }

    @Test
    public void updateDepartmentTest() {
        //获取sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //获取Mapper对象
        DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);

        int result = mapper.updateDepartment(new Department(60, "行政部22", "南京222"));
        if (result > 0) {
            System.out.println("更新部门操作成功");
        }

        sqlSession.close();
    }

    @Test
    public void deleteDepartmentTest() {
        //获取sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //获取Mapper对象
        DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);

        int result = mapper.deleteDepartment(60);
        if (result > 0) {
            System.out.println("删除部门操作成功");
        }

        sqlSession.close();
    }

    @Test
    public void getDepartmentDetailWithJoinTest() {
        //获取sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //获取Mapper对象
        DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);

        Department department = mapper.getDepartmentDetailWithJoin(20);
        System.out.println(department);
        sqlSession.close();
    }

    @Test
    public void getDepartmentDetailTest() {
        //获取sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //获取Mapper对象
        DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);

        Department department = mapper.getDepartmentDetail(20);
        System.out.println(department);
        sqlSession.close();
    }

    @Test
    public void cacheLevel2Test() {
        //获取sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        SqlSession sqlSession2 = MybatisUtils.getSqlSession();
        //获取Mapper对象
        DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);
        DepartmentMapper mapper2 = sqlSession2.getMapper(DepartmentMapper.class);

        Department department = mapper.getDepartmentDetailWithJoin(20);
        System.out.println(department);
        sqlSession.close();

        Department department2 = mapper2.getDepartmentDetailWithJoin(20);
        System.out.println(department2);
        System.out.println(department==department2);

        sqlSession2.close();
    }
}
