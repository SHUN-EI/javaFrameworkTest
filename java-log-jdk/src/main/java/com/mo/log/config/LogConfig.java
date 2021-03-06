package com.mo.log.config;

import com.mo.log.constant.LogConstant;
import com.sun.tools.corba.se.idl.StringGen;
import com.sun.xml.internal.bind.v2.model.core.ID;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by mo on 2021/5/8
 */
public class LogConfig {

    public static final String logConfigFileName = "log.properties";


    /**
     * 配置文件缓存
     */
    private static Map<String, Object[]> propsMap = new HashMap<>();

    /**
     * 字符串转字节
     *
     * @param values
     * @return
     */
    public static byte[] getByteByString(String values) {
        byte[] result = null;

        if (null == values || "".equals(values.trim())) {
            return new byte[0];
        }

        try {
            result = values.getBytes(LogConstant.CFG_CHARSET_NAME);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return result;

    }

    /**
     * 获取异常堆栈信息
     *
     * @param e
     * @return
     */
    public static String getStackTraceInfo(Exception e) {
        String result = null;

        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             PrintWriter printWriter = new PrintWriter(baos)) {
            e.printStackTrace(printWriter);
            result = new String(baos.toByteArray(), LogConstant.CFG_CHARSET_NAME);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return result;
    }

    /**
     * 获取配置
     *
     * @param key
     * @return
     */
    public static String getConfig(String key) {
        File file = new File(logConfigFileName);

        //当前目录
        if (!file.exists()) {
            //从类路径下获取
            URL url = LogConfig.class.getClassLoader().getResource(logConfigFileName);

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
     * 获取配置,传入默认值
     *
     * @param key
     * @param defaultValue
     * @return
     */
    public static String getConfigWithDefault(String key, String defaultValue) {
        String value = getConfig(key);
        return value == null ? defaultValue : value;
    }

    /**
     * 获取配置,传入默认值-long类型
     *
     * @param key
     * @param defaultValue
     * @return
     */
    public static Long getConfigByLong(String key, Long defaultValue) {
        String value = getConfig(key);
        return value == null || "".equals(value.trim()) ? defaultValue : Long.valueOf(value);

    }

    /**
     * 读取配置文件的配置项
     *
     * @param file
     * @param key
     * @return
     */
    public static String readProperties(File file, String key) {

        String result = null;
        //先从缓存里面读取配置文件
        Object[] objects = propsMap.get(logConfigFileName);
        if (null == objects) {
            setCache(file);
            System.out.println("缓存里面没有找到...");
        } else {
            long lastModified = Long.valueOf(objects[0] + "");
            long fileLastModified = file.lastModified();
            //若缓存中的修改时间比当前文件的修改时间小，则更新缓存
            if (lastModified < fileLastModified) {
                setCache(file);
            }
            System.out.println("进入缓存里面找....");
        }

        objects = propsMap.get(logConfigFileName);
        Properties properties = (Properties) objects[1];
        result = properties.getProperty(key);

        return result;

    }

    /**
     * 更新缓存
     *
     * @param file
     */
    private static void setCache(File file) {

        try (FileInputStream fis = new FileInputStream(file)) {
            Properties properties = new Properties();
            properties.load(fis);
            Object[] cacheObjects = new Object[2];
            cacheObjects[0] = file.lastModified();
            cacheObjects[1] = properties;

            //配置文件加入缓存
            propsMap.put(logConfigFileName, cacheObjects);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
