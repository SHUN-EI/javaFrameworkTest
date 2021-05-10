package com.mo.log.log;


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
    public StringBuffer stringBufferA;

    /**
     * 缓存B
     */
    public StringBuffer stringBufferB;

    public char getCurrLogBuff() {
        return currLogBuff;
    }

    public void setCurrLogBuff(char currLogBuff) {
        this.currLogBuff = currLogBuff;
    }

    public StringBuffer getStringBufferA() {
        return stringBufferA;
    }

    public void setStringBufferA(StringBuffer stringBufferA) {
        this.stringBufferA = stringBufferA;
    }

    public StringBuffer getStringBufferB() {
        return stringBufferB;
    }

    public void setStringBufferB(StringBuffer stringBufferB) {
        this.stringBufferB = stringBufferB;
    }
}
