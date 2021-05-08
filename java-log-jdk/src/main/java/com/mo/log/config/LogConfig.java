package com.mo.log.config;

import com.sun.tools.corba.se.idl.StringGen;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by mo on 2021/5/8
 */
public class LogConfig {

    public static final String configFile = "/Users/mo/develop/workspace/javaFrameworkTest/java-log-jdk/src/main/resources/log.properties";

    /**
     * 配置文件缓存
     */
    private static Map<String, Properties> propsMap = new HashMap<String, Properties>();

    /**
     * 获取配置
     *
     * @param key
     * @return
     */
    public static String getConfig(String key) {
        File file = new File(configFile);
        String result = readProperties(file, key);
        return result;
    }

    /**
     * 读取配置文件的配置项
     *
     * @param file
     * @param key
     * @return
     */
    public static String readProperties(File file, String key) {

        String result = "";
        //先从缓存里面读取配置文件
        Properties prop = propsMap.get(configFile);
        if (null == prop) {
            System.out.println("缓存里面没有找到...");
            try (FileInputStream fis = new FileInputStream(file);
                 BufferedInputStream bis = new BufferedInputStream(fis);) {

                Properties properties = new Properties();
                properties.load(bis);
                //配置文件加入缓存
                propsMap.put(configFile, properties);
                result = properties.getProperty(key);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("进入缓存里面找....");
            result = prop.getProperty(key);
        }
        return result;

    }

}
