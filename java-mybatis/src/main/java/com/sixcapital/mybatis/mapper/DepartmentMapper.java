package com.sixcapital.mybatis.mapper;

import com.sixcapital.mybatis.entity.Department;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by mo on 2020/9/2
 */
public interface DepartmentMapper {

    @Select("select *  from dept")
    List<Department> getDepartments();

    // 方法存在多个参数，所有的参数前面必须加上 @Param("id")注解
    @Select("select *  from dept where deptnu = #{deptnu}")
    Department getDepartmentById(@Param("deptnu") int id);

    @Insert("insert into dept values(#{deptnu},#{dname},#{addr})")
    int addDepartment(Department department);

    @Update("update dept set dname=#{dname}, addr=#{addr} where deptnu=#{deptnu}")
    int updateDepartment(Department department);

    @Delete("delete from dept where deptnu=#{deptnu}")
    int deleteDepartment(@Param("deptnu") int id);
}
