package com.mo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by mo on 2021/5/13
 */
public class LogbackTest {

    private static final Logger logger = LoggerFactory.getLogger(LogbackTest.class);

    public static void main(String[] args) {
        String name = "测试日志";
        logger.info("name=" + name);
        logger.info("name={}", name);//不需要拼接字符串
    }
}
