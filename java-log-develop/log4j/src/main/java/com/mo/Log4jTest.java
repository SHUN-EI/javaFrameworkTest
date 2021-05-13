package com.mo;

import org.apache.log4j.Logger;

/**
 * Created by mo on 2021/5/13
 */
public class Log4jTest {

    private static final Logger logger = Logger.getLogger(Log4jTest.class);

    public static void main(String[] args) {
         logger.info("这是Log4j的日志信息");
    }
}
