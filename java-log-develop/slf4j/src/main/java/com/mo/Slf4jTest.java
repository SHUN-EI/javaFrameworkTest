package com.mo;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by mo on 2021/5/14
 */
public class Slf4jTest {

    private static final Logger logger = LoggerFactory.getLogger(Slf4jTest.class);

    public static void main(String[] args) {
        String name = "slf4j的测试日志";
        logger.info("info:name={}", name);
    }
}
