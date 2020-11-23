package com.mo.designPattern.strategy;

/**
 * Created by mo on 2020/11/23
 */
public class Main {

    public static void main(String[] args) {

        //简单订单对象
        ProductOrder productOrder = new ProductOrder(800, 1, 10);

        PromotionContext context;
        double finalPrice;

        //根据不同策略算出不同活动价格
        //没活动
        context = new PromotionContext(new NormalActivity());
        finalPrice = context.executeStrategy(productOrder);
        System.out.println("NormalActivity 的价格为 " + finalPrice);

        //折扣策略
        context = new PromotionContext(new DiscountActivity(0.8));
        finalPrice=context.executeStrategy(productOrder);
        System.out.println("DiscountActivity 的价格为 " + finalPrice);

        //优惠券策略
        context=new PromotionContext(new VoucherActivity(100));
        finalPrice=context.executeStrategy(productOrder);
        System.out.println("VoucherActivity 的价格为 " + finalPrice);

    }
}
