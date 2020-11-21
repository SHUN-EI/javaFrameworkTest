package com.mo.designPattern.bridge;

import com.mo.designPattern.bridge.color.BlueColor;
import com.mo.designPattern.bridge.color.RedColor;
import com.mo.designPattern.bridge.phone.ApplePhone;
import com.mo.designPattern.bridge.phone.XiaoMiPhone;

/**
 * Created by mo on 2020/11/21
 */
public class Main {

    public static void main(String[] args) {
        ApplePhone applePhone = new ApplePhone(new BlueColor());
        applePhone.run();

        XiaoMiPhone xiaoMiPhone = new XiaoMiPhone(new RedColor());
        xiaoMiPhone.run();
    }
}
