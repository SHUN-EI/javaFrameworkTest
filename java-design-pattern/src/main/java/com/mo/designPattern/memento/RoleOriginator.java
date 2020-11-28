package com.mo.designPattern.memento;

/**
 * Created by mo on 2020/11/28
 * 发起者，Originator 和 Memento属性类似
 */
public class RoleOriginator {


    /**
     * 生命力，会下降
     */
    private int live = 100;

    /**
     * 攻击力，会上涨
     */
    private int attack = 50;

    public void display() {
        System.out.println("开始=========");
        System.out.println("生命力：" + live);
        System.out.println("攻击力：" + attack);
        System.out.println("结束=========");
    }

    public void fight() {
        //攻击力会上涨
        this.attack = attack + 2;
        //打架生命力会下降
        this.live = live - 10;
    }

    /**
     * 保存快照，存储状态
     *
     * @return
     */
    public RoleStateMemento saveState() {
        return new RoleStateMemento(live, attack);
    }

    /**
     * 恢复
     */
    public void recoveryState(RoleStateMemento roleStateMemento) {
        this.attack = roleStateMemento.getAttack();
        this.live = roleStateMemento.getLive();
    }

    public int getLive() {
        return live;
    }

    public void setLive(int live) {
        this.live = live;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }
}
