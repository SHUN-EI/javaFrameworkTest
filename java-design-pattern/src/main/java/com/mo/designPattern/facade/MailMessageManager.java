package com.mo.designPattern.facade;

/**
 * Created by mo on 2020/11/22
 */
public class MailMessageManager implements IMessageManager {

    @Override
    public void pushMessage() {
        System.out.println("推送邮件消息");
    }
}
