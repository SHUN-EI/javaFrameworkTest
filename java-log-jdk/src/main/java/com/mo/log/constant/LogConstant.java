package com.mo.log.constant;

import com.mo.log.config.LogConfig;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mo on 2021/5/8
 */
public class LogConstant {

    /**
     * 调试信息
     */
    public static final int DEBUG = 0;
    /**
     * 普通信息
     */
    public static final int INFO = 1;
    /**
     * 警告信息
     */
    public static final int WARN = 2;
    /**
     * 错误信息
     */
    public static final int ERROR = 3;
    /**
     * 严重错误信息
     */
    public static final int FATAL = 4;

    /**
     * 日志级别
     */
    public static String CFG_LOG_LEVEL = LogConfig.getConfigWithDefault("CFG_LOG_LEVEL", "INFO");
    /**
     * 是否输出到控制台
     */
    public static boolean CONSOLE_PRINT = Boolean.valueOf(LogConfig.getConfigWithDefault("CONSOLE_PRINT", "true"));

    /**
     * 当前运行环境的字符集
     */
    public static String CFG_CHARSET_NAME = LogConfig.getConfigWithDefault("CFG_CHARSET_NAME", "UTF-8");
    /**
     * 日志文件路径
     */
    public static String CFG_LOG_PATH = LogConfig.getConfigWithDefault("CFG_LOG_PATH", "./log");


    public static Map<String, String> LEVE_MAP = new HashMap<String, String>() {
        {
            put("0", "DEBUG");
            put("1", "INFO");
            put("2", "WARN");
            put("3", "ERROR");
            put("4", "FATAL");

        }
    };
}
