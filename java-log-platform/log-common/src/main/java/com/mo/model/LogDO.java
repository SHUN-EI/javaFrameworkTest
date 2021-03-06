package com.mo.model;

import com.alibaba.fastjson.JSON;
import lombok.Builder;
import lombok.Data;

/**
 * Created by mo on 2021/5/19
 */
@Builder
@Data
public class LogDO {

    /**
     * rid（requestId）：⼀次请求的唯⼀标示，⽣成后⼀直传递到调⽤结束
     */
    private String rid;
    /**
     * sid（sessionId）：⽤户会话相关，涉及登陆时存在，不登陆的操作为空 sid
     */
    private String sid;
    /**
     * tid（terminalId）：同⼀个终端的请求标示，可以理解为同⼀个设备。可能对应多个⽤户的多次请 求
     */
    private String tid;
    /**
     * 请求来源
     */
    private String from;
    /**
     * 日志记录信息
     */
    private String message;
    /**
     * IP地址
     */
    private String ip;
    /**
     * 访问路径
     */
    private String url;

    /**
     * 日志访问时间戳
     */
    private Long timestamp;

    /**
     * @return
     */
    @Override
    public String toString() {
        //生成日志信息的时候记录系统当前时间
        this.setTimestamp(System.currentTimeMillis());
        return JSON.toJSONString(this);
    }
}
