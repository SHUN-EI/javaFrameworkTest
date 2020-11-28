package com.mo.designPattern.memento;

/**
 * Created by mo on 2020/11/28
 * 状态管理者
 */
public class RoleStateCaretaker {

    private RoleStateMemento memento;

    public RoleStateMemento getMemento() {
        return memento;
    }

    public void setMemento(RoleStateMemento memento) {
        this.memento = memento;
    }
}
