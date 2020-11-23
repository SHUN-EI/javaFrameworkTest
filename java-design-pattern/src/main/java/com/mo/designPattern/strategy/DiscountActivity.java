package com.mo.designPattern.strategy;

/**
 * Created by mo on 2020/11/23
 */
public class DiscountActivity extends Strategy {

    private double rate;

    public DiscountActivity(double rate) {
        this.rate = rate;
    }

    @Override
    public double computePrice(ProductOrder productOrder) {
        //实际情况下会有一系列的复杂计算
        return productOrder.getOldPrice() * rate;
    }
}
