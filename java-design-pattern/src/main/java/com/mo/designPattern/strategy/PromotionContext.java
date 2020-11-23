package com.mo.designPattern.strategy;

/**
 * Created by mo on 2020/11/23
 * 策略上下文
 */
public class PromotionContext {

    private Strategy strategy;

    public PromotionContext(Strategy strategy) {
        this.strategy = strategy;
    }

    /**
     * 根据策略计算最终的价格
     * @param productOrder
     * @return
     */
    public double executeStrategy(ProductOrder productOrder) {
        return strategy.computePrice(productOrder);
    }
}
