package com.sixcapital.mybatis.mapper;

import com.sixcapital.mybatis.entity.Department;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by mo on 2020/9/2
 */
public interface DepartmentMapper {

    @Select("select *  from dept")
    List<Department> getDepartments();
}
