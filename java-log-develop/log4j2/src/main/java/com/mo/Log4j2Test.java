package com.mo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by mo on 2021/5/13
 */
public class Log4j2Test {

    private static final Logger logger = LogManager.getLogger(Log4j2Test.class);

    public static void main(String[] args) {

        logger.info("这是Log4j2的日志信息");
        String name = "测试日志";
        logger.info("name={}", name);//不需要拼接字符串
    }
}
