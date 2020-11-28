package com.mo.designPattern.memento;

/**
 * Created by mo on 2020/11/28
 */
public class Main {

    public static void main(String[] args) {

        //发起者
        RoleOriginator role = new RoleOriginator();
        role.display();
        role.fight();
        role.display();

        System.out.println("保存上面的状态快照");
        //状态管理者
        RoleStateCaretaker caretaker = new RoleStateCaretaker();
        caretaker.setMemento(role.saveState());

        role.fight();
        role.fight();
        role.display();

        System.out.println("准备恢复快照");
        role.recoveryState(caretaker.getMemento());
        role.display();

    }
}
