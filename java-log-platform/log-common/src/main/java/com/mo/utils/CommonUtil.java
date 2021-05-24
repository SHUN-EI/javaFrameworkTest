package com.mo.utils;

import javax.servlet.http.HttpServletRequest;
import java.util.Random;

/**
 * Created by mo on 2021/5/24
 */
public class CommonUtil {

    private static final String ALL_CHAR_NUM = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    /**
     * 生成指定长度随机字母和数字
     *
     * @param length
     * @return
     */
    public static String getStringNumRandom(int length) {
        //生成随机数字和字母
        Random random = new Random();
        StringBuilder saltString = new StringBuilder(length);
        for (int i = 1; i <= length; ++i) {
            saltString.append(ALL_CHAR_NUM.charAt(random.nextInt(ALL_CHAR_NUM.length())));
        }
        return saltString.toString();
    }


    /**
     * 获取访问设备终端
     *
     * @param userAgent
     * @return
     */
    public static String getDevice(String userAgent) {

        String[] terminals = {
                "iphone", "android", "touch", "ipad", "symbian", "htc", "palmos",
                "blackberry", "opera mini", "windows ce", "nokia", "fennec", "macintosh",
                "hiptop", "kindle", "mot", "webos", "samsung", "sonyericsson",
                "wap", "avantgo", "eudoraweb", "minimo", "netfront", "teleca", "windows nt"
        };

        userAgent = userAgent.toLowerCase();
        for (String terminal : terminals) {
            if (userAgent.indexOf(terminal) != -1) {
                return terminal;
            }
        }

        return userAgent;
    }

    /**
     * 获取ip的⽅法
     * @param request
     * @return
     */
    public static String getIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
