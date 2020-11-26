package com.mo.designPattern.command;

/**
 * Created by mo on 2020/11/26
 */
public class Main {
    public static void main(String[] args) {
        //创建接收者
        Receiver receiver = new Receiver();
        //创建命令对象，设定它的接收者
        ConcreteCommand concreteCommand = new ConcreteCommand(receiver);
        //创建请求者，把命令对象设置进去
        Invoker invoker = new Invoker(concreteCommand);
        //执行方法
        invoker.action();

        //创建接收者,这里是空调
        ConditionReceiver receiver1 = new ConditionReceiver();
        //创建命令对象，设定它的接收者
        Command onCommand = new OnCommand(receiver1);
        Command offCommand = new OffCommand(receiver1);
        Command coolCommand = new CoolCommand(receiver1);
        Command warmCommand = new WarmCommand(receiver1);
        //创建请求者，把命令对象设置进去
        AppInvoker appInvoker = new AppInvoker();
        appInvoker.setOnCommand(onCommand);
        appInvoker.setOffCommand(offCommand);
        appInvoker.setCoolCommand(coolCommand);
        appInvoker.setWarmCommand(warmCommand);

        appInvoker.on();
        System.out.println();
        appInvoker.cool();
        System.out.println();
        appInvoker.warm();
        System.out.println();
        appInvoker.off();
        System.out.println();

    }

}
