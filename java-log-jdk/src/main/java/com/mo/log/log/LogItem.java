package com.mo.log.log;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by mo on 2021/5/11
 */
public class LogItem {

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
}
