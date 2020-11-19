package com.mo.mybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by mo on 2020/9/4
 */
@MapperScan("com.sixcapital.mybatisplus.mapper")
@SpringBootApplication
public class MybatisPlusBootstrap {
    public static void main(String[] args) {
        SpringApplication.run(MybatisPlusBootstrap.class, args);
    }
}
