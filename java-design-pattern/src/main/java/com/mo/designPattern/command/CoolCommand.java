package com.mo.designPattern.command;

/**
 * Created by mo on 2020/11/26
 */
public class CoolCommand implements Command {

    /**
     * 对哪个receiver 进行命令处理
     */
    private ConditionReceiver receiver;

    public CoolCommand(ConditionReceiver receiver) {
        this.receiver = receiver;
    }

    /**
     * 必须实现一个命令的调用
     */
    @Override
    public void execute() {
        System.out.println("CoolCommand -> execute");
        receiver.cool();
    }
}
