package com.mo.designPattern.observer;

/**
 * Created by mo on 2020/11/23
 * 消息的消费者
 */
public class EmployeeConcreteObserver implements  Observer{
    @Override
    public void update() {
        System.out.println("员工发现领导到来，暂停在线摸鱼，回归工作");
    }
}
