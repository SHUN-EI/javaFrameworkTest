package com.mo.designPattern.bridge.color;

/**
 * Created by mo on 2020/11/21
 */
public class RedColor implements Color {

    @Override
    public void useColor() {
        System.out.println(" 颜色是红色");
    }
}
