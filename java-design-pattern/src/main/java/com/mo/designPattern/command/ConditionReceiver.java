package com.mo.designPattern.command;

/**
 * Created by mo on 2020/11/26
 */
public class ConditionReceiver {

    public void on(){
        System.out.println("空调开启了");
    }

    public void off(){
        System.out.println("空调关闭了");
    }

    public void cool(){
        System.out.println("空调开始制冷");
    }

    public void warm(){
        System.out.println("空调开始制暖");
    }
}
