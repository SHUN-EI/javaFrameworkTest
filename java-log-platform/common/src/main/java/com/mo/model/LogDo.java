package com.mo.model;

import com.alibaba.fastjson.JSON;
import lombok.Data;

/**
 * Created by mo on 2021/5/19
 * ⽇志信息对象
 */
@Data
public class LogDo {
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
     *
     * @return
     */
    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
