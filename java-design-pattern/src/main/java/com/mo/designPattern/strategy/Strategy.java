package com.mo.designPattern.strategy;

/**
 * Created by mo on 2020/11/23
 * 策略抽象类
 */
public abstract class Strategy {

    /**
     * 根据简单订单对象，计算商品折扣后的价格
     * @param productOrder
     * @return
     */
    public abstract double computePrice(ProductOrder productOrder);
}
