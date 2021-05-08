package com.mo.log.config;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by mo on 2021/5/8
 */
public class LogConfig {

    public static final String configFile = "/Users/mo/develop/workspace/javaFrameworkTest/java-log-jdk/src/main/resources/log.properties";

    public static String readProperties(File file, String key) {

        String result = "";
        try (FileInputStream fis = new FileInputStream(file);
             BufferedInputStream bis = new BufferedInputStream(fis);) {

            Properties properties = new Properties();
            properties.load(bis);
            result = properties.getProperty(key, "");
        } catch (IOException e) {

        }

        return result;

    }

}
