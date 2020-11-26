package com.mo.designPattern.command;


/**
 * Created by mo on 2020/11/26
 */
public class ConcreteCommand implements Command {

    private Receiver receiver;

    /**
     * 对哪个receiver类进⾏命令处理
     */
    public ConcreteCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        System.out.println("ConcreteCommand———— execute");
        receiver.doSomething();
    }
}
