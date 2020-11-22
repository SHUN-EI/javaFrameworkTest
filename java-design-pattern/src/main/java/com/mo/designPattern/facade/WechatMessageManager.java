package com.mo.designPattern.facade;

/**
 * Created by mo on 2020/11/22
 */
public class WechatMessageManager implements IMessageManager {

    @Override
    public void pushMessage() {
        System.out.println("推送微信消息");
    }
}
