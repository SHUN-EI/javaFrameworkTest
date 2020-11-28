package com.mo.designPattern.memento;

/**
 * Created by mo on 2020/11/28
 * 快照，备忘录
 */
public class RoleStateMemento {

    /**
     * 生命力，会下降
     */
    private int live;

    /**
     * 攻击力，会上涨
     */
    private int attack;

    public RoleStateMemento(int live, int attack) {
        this.live = live;
        this.attack = attack;
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
