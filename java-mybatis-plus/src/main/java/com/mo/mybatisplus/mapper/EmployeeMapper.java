package com.mo.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mo.mybatisplus.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by mo on 2020/9/4
 */
//@Repository //代表持久层
@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {
    // 在对应的Mapper上面继承基本的类 BaseMapper
    // 所有的CRUD操作都已经编写完成了,你不需要像以前的配置一大堆文件了！

}
