package com.mo.designPattern.proxy;

/**
 * Created by mo on 2020/11/22
 * Proxy,代理对象，增加了功能
 */
public class DigitalSellProxy implements DigitalSell {

    private DigitalSell digitalSellReal = new DigitalSellReal();

    @Override
    public void sell() {

        makeAddress();
        digitalSellReal.sell();
        makeAD();
    }

    private void makeAddress() {
        System.out.println("选择了一个人流量很高的地址 ");
    }

    private void makeAD() {
        System.out.println("投放广告");
    }
}
