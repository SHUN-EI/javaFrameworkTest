package com.mo.log.model;

import com.mo.log.config.LogConfig;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

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
