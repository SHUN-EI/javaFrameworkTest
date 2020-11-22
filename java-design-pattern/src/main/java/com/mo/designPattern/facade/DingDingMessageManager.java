package com.mo.designPattern.facade;

/**
 * Created by mo on 2020/11/22
 */
public class DingDingMessageManager implements IMessageManager {

    @Override
    public void pushMessage() {
        System.out.println("推送钉钉消息");
    }
}
