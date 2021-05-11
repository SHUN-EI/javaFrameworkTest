package com.mo.log.test;

import com.mo.log.config.LogConfig;
import com.mo.log.constant.LogConstant;
import org.junit.Test;

import java.io.File;

/**
 * Created by mo on 2021/5/8
 */
public class LogConfigTest {

    @Test
    public void logByteAndExceptionTest() {
        System.out.println(LogConfig.getByteByString("Test"));
        System.out.println(LogConfig.getStackTraceInfo(new Exception("测试异常")));
    }

    @Test
    public void logConstantTest() {
        System.out.println(LogConstant.CFG_LOG_LEVEL);
        System.out.println(LogConstant.CONSOLE_PRINT);
        System.out.println(LogConstant.CFG_CHARSET_NAME);
        System.out.println(LogConstant.CFG_LOG_PATH);
    }

    @Test
    public void logConfigTest() {
        File file = new File(LogConfig.logConfigFileName);
        String result = LogConfig.readProperties(file, "value1");
        System.out.println("读取到配置文件为" + result);
    }

    @Test
    public void getConfigTest() {
        String result1 = LogConfig.getConfig("value1");
        String result2 = LogConfig.getConfig("value2");
        System.out.println("读取到配置文件:value1为" + result1);
        System.out.println("读取到配置文件:value2为" + result2);
    }
}
