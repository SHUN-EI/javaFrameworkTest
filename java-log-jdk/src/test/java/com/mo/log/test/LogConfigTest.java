package com.mo.log.test;

import com.mo.log.config.LogConfig;
import org.junit.Test;

import java.io.File;

/**
 * Created by mo on 2021/5/8
 */
public class LogConfigTest {

    @Test
    public void logConfigTest() {
        File file = new File(LogConfig.configFile);
        String result = LogConfig.readProperties(file, "value");
        System.out.println("读取到配置文件为" + result);
    }
}
