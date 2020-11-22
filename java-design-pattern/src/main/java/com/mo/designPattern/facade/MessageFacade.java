package com.mo.designPattern.facade;

/**
 * Created by mo on 2020/11/22
 */
public class MessageFacade implements IMessageManager {


    private  IMessageManager wechatMessageManager=new WechatMessageManager();
    private  IMessageManager dingDingMessageManager=new DingDingMessageManager();
    private  IMessageManager mailMessageManager=new MailMessageManager();
    private  IMessageManager smsMessageManager=new SmsMessageManager();


    @Override
    public void pushMessage() {
        wechatMessageManager.pushMessage();
        dingDingMessageManager.pushMessage();
        mailMessageManager.pushMessage();
        smsMessageManager.pushMessage();
    }
}
