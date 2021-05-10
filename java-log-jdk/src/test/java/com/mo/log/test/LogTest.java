package com.mo.log.test;

import com.mo.log.log.LogItem;
import org.junit.Test;

/**
 * Created by mo on 2021/5/11
 */
public class LogTest {

    @Test
    public void logBufferTest() {
        LogItem logItem = new LogItem();
        StringBuffer sb = new StringBuffer();
        sb.append("test");

        logItem.setStringBufferA(sb);
        //读取缓存
        StringBuffer readBuffer = null;
        //缓冲队列
        StringBuffer currentBuffer = logItem.stringBufferA;
        if ('A' == logItem.currLogBuff) {
            logItem.currLogBuff = 'B';
            currentBuffer = logItem.getStringBufferB();
            readBuffer = logItem.getStringBufferA();
            logItem.setStringBufferA(null);
        } else {
            logItem.currLogBuff = 'A';
            currentBuffer = logItem.getStringBufferA();
            readBuffer = logItem.getStringBufferB();
            logItem.setStringBufferB(null);
        }

        System.out.println("readBuffer:" + readBuffer);
    }
}
