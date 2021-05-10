package com.mo.log.test;

import com.mo.log.log.LogItem;
import org.junit.Test;

import java.util.List;

/**
 * Created by mo on 2021/5/11
 */
public class LogTest {

    //当前的缓存队列
    List<StringBuffer> currentBuffer = null;

    @Test
    public void logBufferTest() {
        LogItem logItem = new LogItem();
        currentBuffer = logItem.getStringBufferA();

        //数据
        StringBuffer sb = new StringBuffer();
        sb.append("test");
        sb.append("这是数据测试");
        currentBuffer.add(sb);

        //缓冲队列
        List<StringBuffer> currentBuffer = logItem.stringBufferA;
        if ('A' == logItem.currLogBuff) {
            logItem.currLogBuff = 'B';
            currentBuffer.forEach(obj -> System.out.println("当前缓存的数据为" + obj));
            logItem.setStringBufferA(null);
            currentBuffer = logItem.getStringBufferB();
        } else {
            logItem.currLogBuff = 'A';
            currentBuffer.forEach(obj -> System.out.println("当前缓存的数据为" + obj));
            logItem.setStringBufferB(null);
            currentBuffer = logItem.getStringBufferA();
        }
    }
}
