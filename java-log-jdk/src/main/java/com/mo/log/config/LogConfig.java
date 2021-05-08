package com.mo.log.config;

import com.sun.tools.corba.se.idl.StringGen;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by mo on 2021/5/8
 */
public class LogConfig {

    public static final String configFileName = "log.properties";


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
        File file = new File(configFileName);

        //当前目录
        if (!file.exists()) {
            //从类路径下获取
            URL url = LogConfig.class.getClassLoader().getResource(configFileName);

            if (null == url) return null;

            String classPathFile = null;
            try {
                classPathFile = url.toURI().getPath();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }

            file = new File(classPathFile);
        }

        //还不存在的话
        if (!file.exists()) return null;

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
        Properties prop = propsMap.get(configFileName);
        if (null == prop) {
            System.out.println("缓存里面没有找到...");
            try (FileInputStream fis = new FileInputStream(file);
                 BufferedInputStream bis = new BufferedInputStream(fis);) {

                Properties properties = new Properties();
                properties.load(bis);
                //配置文件加入缓存
                propsMap.put(configFileName, properties);
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
