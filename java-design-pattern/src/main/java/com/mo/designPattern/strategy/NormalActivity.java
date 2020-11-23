package com.mo.designPattern.strategy;

/**
 * Created by mo on 2020/11/23
 */
public class NormalActivity extends  Strategy {

    @Override
    public double computePrice(ProductOrder productOrder) {
        return productOrder.getOldPrice();
    }
}
