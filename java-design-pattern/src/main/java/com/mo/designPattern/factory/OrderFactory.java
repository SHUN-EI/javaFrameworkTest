package com.mo.designPattern.factory;

/**
 * Created by mo on 2020/11/20
 * 抽象工厂模式-超级工厂，定义同个产品族的其他相关子工厂
 */
public interface OrderFactory {

    PayFactory createPay();

    RefundFactory createRefund();
}
