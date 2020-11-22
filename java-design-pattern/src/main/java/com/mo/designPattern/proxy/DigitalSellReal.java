package com.mo.designPattern.proxy;

/**
 * Created by mo on 2020/11/22
 * RealProject ：真实对象
 */
public class DigitalSellReal implements  DigitalSell {

    @Override
    public void sell() {
        System.out.println("销售华为手机");
    }
}
