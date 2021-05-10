package com.mo.log.log;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by mo on 2021/5/11
 * 日志结构类
 */
public class LogItem {

    /**
     * 不包含后缀的文件名
     **/
    public String logFileName = "";
    /**
     * 包括路径的完整日志名称
     */
    public String fullLogFileName = "";
    /**
     * 当前日志文件大小
     */
    public long currLogSize = 0;

    /**
     * 下次日志输出到文件时间
     */
    public long nextWriteTime = 0;
    /**
     * 上次写入时的日期
     */
    public String lastPCDate = "";
    /**
     * 当前已缓存大小
     */
    public long currCacheSize = 0;

    /**
     * 当前正在使用的日志缓存
     */
    public char currLogBuff = 'A';

    /**
     * 缓存A
     */
    public List<StringBuffer> stringBufferA = new ArrayList<>();

    /**
     * 缓存B
     */
    public List<StringBuffer> stringBufferB = new ArrayList<>();

    public char getCurrLogBuff() {
        return currLogBuff;
    }

    public void setCurrLogBuff(char currLogBuff) {
        this.currLogBuff = currLogBuff;
    }

    public List<StringBuffer> getStringBufferA() {
        return stringBufferA;
    }

    public void setStringBufferA(List<StringBuffer> stringBufferA) {
        this.stringBufferA = stringBufferA;
    }

    public List<StringBuffer> getStringBufferB() {
        return stringBufferB;
    }

    public void setStringBufferB(List<StringBuffer> stringBufferB) {
        this.stringBufferB = stringBufferB;
    }

    public String getLogFileName() {
        return logFileName;
    }

    public void setLogFileName(String logFileName) {
        this.logFileName = logFileName;
    }

    public String getFullLogFileName() {
        return fullLogFileName;
    }

    public void setFullLogFileName(String fullLogFileName) {
        this.fullLogFileName = fullLogFileName;
    }

    public long getCurrLogSize() {
        return currLogSize;
    }

    public void setCurrLogSize(long currLogSize) {
        this.currLogSize = currLogSize;
    }

    public long getNextWriteTime() {
        return nextWriteTime;
    }

    public void setNextWriteTime(long nextWriteTime) {
        this.nextWriteTime = nextWriteTime;
    }

    public String getLastPCDate() {
        return lastPCDate;
    }

    public void setLastPCDate(String lastPCDate) {
        this.lastPCDate = lastPCDate;
    }

    public long getCurrCacheSize() {
        return currCacheSize;
    }

    public void setCurrCacheSize(long currCacheSize) {
        this.currCacheSize = currCacheSize;
    }
}
