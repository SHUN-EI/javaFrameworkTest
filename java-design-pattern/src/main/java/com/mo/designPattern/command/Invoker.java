package com.mo.designPattern.command;

/**
 * Created by mo on 2020/11/26
 */
public class Invoker {

    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    /**
     * 执⾏命令
     */
    public void action() {
        this.command.execute();
    }
}
