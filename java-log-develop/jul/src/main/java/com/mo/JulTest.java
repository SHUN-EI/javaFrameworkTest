package com.mo;

import java.util.logging.Logger;

/**
 * Created by mo on 2021/5/13
 */
public class JulTest {

    static {
        System.setProperty("java.util.logging.config.file",
                JulTest.class.getClassLoader().getResource("logging.properties").getPath());
    }

    private static final Logger logger = Logger.getLogger(JulTest.class.getName());

    public static void main(String[] args) {
        logger.finest("finest：这是JUL的日志信息");
        logger.fine("fine：这是JUL的日志信息");
        logger.info("info：这是JUL的日志信息");
        logger.warning("warning：这是JUL的日志信息");
    }
}
