package com.mo.log;

import com.mo.log.config.LogConfig;
import com.mo.log.constant.LogConstant;
import com.mo.log.constant.TimePatternConstant;
import com.mo.log.model.LogManger;
import com.mo.log.utils.TimeUtil;

import java.io.UnsupportedEncodingException;

/**
 * Created by mo on 2021/5/11
 */
public class Log {

    /**
     * volatile,保证线程的可见性，禁止指令重排
     */
    private volatile static Log log = null;

    private static LogManger logManger;

    static {
        logManger = LogManger.getInstance();
    }

    /**
     * 构造函数私有化
     */
    private Log() {
    }

    /**
     * 单例模式获取，双重检查锁定 （Double-Checked-Locking）
     *
     * @return
     */
    public static Log getInstance() {
        if (log == null) {
            synchronized (Log.class) {
                if (log == null) {
                    log = new Log();
                }
            }
        }

        return log;
    }

    /**
     * 写调试日志
     *
     * @param logMsg 日志内容
     */
    public void debug(String logMsg) {
        writeLog("debug", LogConstant.DEBUG, logMsg);
    }

    /**
     * 写普通日志
     *
     * @param logMsg 日志内容
     */
    public void info(String logMsg) {
        writeLog("info", LogConstant.INFO, logMsg);
    }

    /**
     * 写警告日志
     *
     * @param logMsg 日志内容
     */
    public void warn(String logMsg) {
        writeLog("warn", LogConstant.WARN, logMsg);
    }

    /**
     * 写错误日志
     *
     * @param logMsg 日志内容
     */
    public void error(String logMsg) {
        writeLog("error", LogConstant.ERROR, logMsg);
    }

    /**
     * 写严重错误日志
     *
     * @param logMsg 日志内容
     */
    public void fatal(String logMsg) {
        writeLog("fatal", LogConstant.FATAL, logMsg);
    }

    /**
     * 写系统日志
     *
     * @param level  日志级别
     * @param logMsg 日志内容
     */
    public void writeLog(int level, String logMsg) {
        writeLog(LogConstant.LEVE_MAP.get(String.valueOf(level)).toLowerCase(), level, logMsg);
    }

    /**
     * 写日志
     *
     * @param logFileName 日志文件名
     * @param level       日志级别
     * @param logMsg      日志内容
     */
    public void writeLog(String logFileName, int level, String logMsg) {
        if (logMsg != null && LogConstant.CFG_LOG_LEVEL.indexOf("" + level) >= 0) {
            StringBuffer sb = new StringBuffer(logMsg.length() + 100);
            sb.append("[");
            //日志级别
            sb.append(LogConstant.LEVE_MAP.get(String.valueOf(level)));
            sb.append("] ");
            //日志记录时间
            sb.append(TimeUtil.getTime(TimePatternConstant.YYYYMMDDHHMMSS_PREFIX));
            sb.append(" [");
            sb.append(Thread.currentThread().getName());
            sb.append("] ");
            //日志内容
            sb.append(logMsg);
            sb.append("\n");
            logManger.addLog(logFileName, sb);

            //错误信息强制打印到控制台；若 CONSOLE_PRINT 配置为 true，也将日志打印到控制台
            if (LogConstant.ERROR == level || LogConstant.FATAL == level || LogConstant.CONSOLE_PRINT) {

                try {
                    String result = new String(sb.toString().getBytes(LogConstant.CFG_CHARSET_NAME), LogConstant.CFG_CHARSET_NAME);
                    System.out.println(result);
                } catch (UnsupportedEncodingException e) {
                    System.out.println(LogConfig.getStackTraceInfo(e));
                }
            }
        }

    }

}
