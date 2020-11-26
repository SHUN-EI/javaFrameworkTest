package com.mo.designPattern.command;

/**
 * Created by mo on 2020/11/26
 */
public class AppInvoker {

    private Command onCommand;
    private Command offCommand;
    private Command coolCommand;
    private Command warmCommand;


    public void setOnCommand(Command onCommand) {
        this.onCommand = onCommand;
    }

    public void setOffCommand(Command offCommand) {
        this.offCommand = offCommand;
    }

    public void setCoolCommand(Command coolCommand) {
        this.coolCommand = coolCommand;
    }

    public void setWarmCommand(Command warmCommand) {
        this.warmCommand = warmCommand;
    }

    /**
     * 开机
     */
    public void on() {
        onCommand.execute();
    }

    /**
     * 关机
     */
    public void off() {
        offCommand.execute();
    }

    /**
     * 制冷
     */
    public void cool() {
        coolCommand.execute();
    }

    /**
     * 制热
     */
    public void warm() {
        warmCommand.execute();
    }
}
