package com.mo.designPattern.bridge.phone;

import com.mo.designPattern.bridge.color.Color;

/**
 * Created by mo on 2020/11/21
 * 手机的实例化
 */
public class ApplePhone extends Phone {

    public ApplePhone(Color color) {
        super.setColor(color);
    }

    @Override
    public void run() {
        System.out.println("这是苹果手机");
        color.useColor();
    }
}
