package com.mo.designPattern.factory;

/**
 * Created by mo on 2020/11/20
 */
public class Main {

    public static void main(String[] args) {

        OrderFactory factory = FactoryProducer.getFactory("ALI");

        factory.createPay().unifiedorder();

        factory.createRefund().refund();
    }
}
