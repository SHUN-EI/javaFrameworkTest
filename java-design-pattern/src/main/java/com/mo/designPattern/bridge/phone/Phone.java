package com.mo.designPattern.bridge.phone;

import com.mo.designPattern.bridge.color.Color;

/**
 * Created by mo on 2020/11/21
 * 抽象角色,手机
 */
public abstract class Phone {

    /**
     * 通过组合的方式来桥接其他行为
     */
    protected Color color;

    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * 手机的方法
     */
    public abstract void run();
}
