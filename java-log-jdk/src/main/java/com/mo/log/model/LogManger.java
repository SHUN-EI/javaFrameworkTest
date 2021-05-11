package com.mo.log.model;

import com.mo.log.config.LogConfig;
import com.mo.log.constant.LogConstant;
import com.mo.log.constant.TimePatternConstant;
import com.mo.log.utils.TimeUtil;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * Created by mo on 2021/5/11
 * 日志管理类
 */
public class LogManger extends Thread {

    /**
     * 文件列表
     */
    private Map<String, LogItem> fileList = new ConcurrentHashMap<>();

    /**
     * 写入日志的时间间隔
     */
    public static long INTER_TIME = LogConfig.getConfigByLong("INTER_TIME", 1000l);

    /**
     * 单个文件的大小，默认为10m
     */
    public static long SINGLE_FILE_SIZE = LogConfig.getConfigByLong("SINGLE_FILE_SIZE", 10 * 1024 * 1024l);

    /**
     * 缓存大小,默认为1m
     */
    public static long CACHE_SIZE = LogConfig.getConfigByLong("CACHE_SIZE", 1024 * 1024l);

    /**
     * 是否运行多线程
     */
    public static boolean isRun = true;

    @Override
    public void run() {
        while (isRun) {
            System.out.println("测试");
        }
    }

    /**
     * 构造函数私有化
     */
    private LogManger() {
        this.setName("LogManger");
        this.start();
    }

    /**
     * volatile,保证线程的可见性，禁止指令重排
     */
    private volatile static LogManger logManger = null;

    /**
     * 单例模式获取，双重检查锁定 （Double-Checked-Locking）
     *
     * @return
     */
    public static LogManger getInstance() {
        if (logManger == null) {
            synchronized (LogManger.class) {
                if (logManger == null) {
                    logManger = new LogManger();
                }
            }
        }

        return logManger;
    }

    /**
     * 创建日志文件
     */
    private void createLogFile(LogItem logItem) {
        String extensionName = ".log";

        /**
         * 系统当前日期
         */
        String currentTime = TimeUtil.getTime(TimePatternConstant.SERIAL_YYMMDDHHMMSS_PREFIX);
        //判断日志root路径是否存在，不存在则先创建
        File rootDir = new File(LogConstant.CFG_LOG_PATH);
        if (!rootDir.exists() || !rootDir.isDirectory()) {
            rootDir.mkdirs();
        }

        //如果超过单个文件大小，则拆分文件
        if (logItem.fullLogFileName != null && logItem.fullLogFileName.length() > 0
                && logItem.currLogSize >= SINGLE_FILE_SIZE) {
            File oldFile = new File(logItem.fullLogFileName);
            if (oldFile.exists()) {
                String newFileName = LogConstant.CFG_LOG_PATH + "/" + logItem.lastPCDate + "/" + logItem.logFileName + "_" +
                        TimeUtil.getTime(TimePatternConstant.SERIAL_YYMMDDHHMMSS_PREFIX) + extensionName;

                File newFile = new File(newFileName);
                boolean flag = oldFile.renameTo(newFile);

                System.out.println("日志已自动备份为 " + newFile.getName() + (flag ? "Success!" : "Failure!"));
                //清空当前文件的大小
                logItem.fullLogFileName = "";
                logItem.currLogSize = 0;
            }
        }

        //创建文件
        if (logItem.fullLogFileName == null || logItem.fullLogFileName.length() <= 0
                || !currentTime.equals(logItem.lastPCDate)) {

            String newDir = LogConstant.CFG_LOG_PATH + "/" + currentTime;
            File file = new File(newDir);
            if (!file.exists()) {
                file.mkdirs();
            }

            logItem.fullLogFileName = newDir + "/" + logItem.getLogFileName() + extensionName;
            logItem.lastPCDate = currentTime;
            file = new File(logItem.getFullLogFileName());
            if (file.exists()) {
                logItem.currLogSize = file.length();
            } else {
                logItem.currLogSize = 0;
            }
        }
    }

    /**
     * 缓存的数据写入文件
     *
     * @return
     */
    public static int writeToFile(String filePath, List<StringBuffer> buffers) {
        int size = 0;

        File file = new File(filePath);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try (FileOutputStream outputStream = new FileOutputStream(filePath, true)) {

            for (int i = 0; i < buffers.size(); i++) {
                StringBuffer buffer = buffers.get(i);
                byte[] bytes = LogConfig.getByteByString(buffer.toString());
                size += bytes.length;
                outputStream.write(bytes);
                //清理缓存
                buffers.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return size;
    }

    /**
     * 添加日志到缓存
     *
     * @param fileName
     * @param messageLog
     */
    public void addLog(String fileName, StringBuffer messageLog) {
        LogItem logItem = fileList.get(fileName);

        if (null == logItem) {
            synchronized (LogManger.class) {
                if (null == logItem) {
                    LogItem log = new LogItem();
                    log.logFileName = fileName;
                    log.nextWriteTime = System.currentTimeMillis() + INTER_TIME;

                    //加入缓存
                    fileList.put(fileName, log);
                }
            }
        }

        char currLogBuff = logItem.currLogBuff;
        if (currLogBuff == 'A') {
            logItem.getStringBufferA().add(messageLog);
        } else {
            logItem.getStringBufferB().add(messageLog);
        }
    }
}
