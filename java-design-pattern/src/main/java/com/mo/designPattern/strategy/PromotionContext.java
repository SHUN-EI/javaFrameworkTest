package com.mo.designPattern.strategy;

/**
 * Created by mo on 2020/11/23
 */
public class PromotionContext {

    private Strategy strategy;

    public PromotionContext(Strategy strategy) {
        this.strategy = strategy;
    }

    public double executeStrategy(ProductOrder productOrder) {
        return strategy.computePrice(productOrder);
    }
}
