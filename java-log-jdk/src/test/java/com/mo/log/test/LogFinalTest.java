package com.mo.log.test;

import com.mo.log.Log;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by mo on 2021/5/11
 */
public class LogFinalTest {

    @Test
    public void logFinalTest() {
        Log log = Log.getInstance();
        log.debug("测试debug");
        log.error("测试error");
        log.fatal("测试fatal");
    }

    private static Log log = Log.getInstance();
    private static String record_100_byte = "youfanmance Testing.youfanmance Testing.youfanmance Testing.youfanmance Testing.youfanmance Testing.";   //100字节
    private static String record_200_byte = "youfanmance Testing.youfanmance Testing.youfanmance Testing.youfanmance Testing.youfanmance Testing.youfanmance Testing.youfanmance Testing.youfanmance Testing.youfanmance Testing.youfanmance Testing.";   //200字节
    private static String record_400_byte = "youfanmance Testing.youfanmance Testing.youfanmance Testing.youfanmance Testing.youfanmance Testing.youfanmance Testing.youfanmance Testing.youfanmance Testing.youfanmance Testing.youfanmance Testing.youfanmance Testing.youfanmance Testing.youfanmance Testing.youfanmance Testing.youfanmance Testing.youfanmance Testing.youfanmance Testing.youfanmance Testing.youfanmance Testing.youfanmance Testing.";   //400字节
    private static AtomicInteger messageCount = new AtomicInteger(0);
    private static int count = 1000;  //基准数值
    private static int threadNum = 1;  //1,2,4,8,16,32

    /**
     * 日志性能和吞吐量测试
     */
    @Test
    public void logPerformanceTest() {
        try {
            final CountDownLatch latch = new CountDownLatch(threadNum);


            long startTime = System.currentTimeMillis();
            for (int i = 0; i < threadNum; i++) {
                new Thread(() -> {
                    while (messageCount.get() < count) {
                        log.info(record_400_byte);
                        messageCount.incrementAndGet();
                    }
                    latch.countDown();
                }).start();
            }
            latch.await();
            long endTime = System.currentTimeMillis();

            System.out.println("messageCount=" + messageCount.get() +
                    ", threadNum=" + threadNum +
                    ", costTime=" + (endTime - startTime) +
                    "ms, throughput=" + (1 * 1000 * messageCount.get() / (endTime - startTime)));
            System.exit(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
