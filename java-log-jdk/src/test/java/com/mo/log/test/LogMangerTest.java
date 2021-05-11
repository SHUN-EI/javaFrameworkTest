package com.mo.log.test;

import com.mo.log.model.LogManger;
import org.junit.Test;

/**
 * Created by mo on 2021/5/11
 */
public class LogMangerTest {

    @Test
    public void logMangerInstanceTest() {

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                LogManger logManger = LogManger.getInstance();
                System.out.println("创建的logManger对象为" + logManger);
            }).start();
        }
    }
}
