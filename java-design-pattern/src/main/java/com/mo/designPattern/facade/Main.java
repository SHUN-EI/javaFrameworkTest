package com.mo.designPattern.facade;

/**
 * Created by mo on 2020/11/22
 */
public class Main {

    public static void main(String[] args) {

        IMessageManager messageManager = new MessageFacade();
        messageManager.pushMessage();
    }
}
