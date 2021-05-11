package com.mo.log.test;

import com.mo.log.Log;
import org.junit.Test;

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

}
