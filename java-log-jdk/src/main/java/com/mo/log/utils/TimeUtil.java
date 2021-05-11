package com.mo.log.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by mo on 2021/5/11
 */
public class TimeUtil {

    public static String getTime(String pattern) {

        //获取当前时间，JDK8时间日期处理类
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        String format = formatter.format(now);

        return format;

    }
}
