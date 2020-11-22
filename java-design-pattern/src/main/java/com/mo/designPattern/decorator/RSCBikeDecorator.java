package com.mo.designPattern.decorator;

/**
 * Created by mo on 2020/11/22
 * RSC 是防爆胎的缩写，
 * 具体装饰者组件 ConcreteDecorator
 */
public class RSCBikeDecorator extends BikeDecorator {

    private String description = "增加一个防爆胎";

    private Bike bike;

    public RSCBikeDecorator(Bike bike) {
        this.bike = bike;
    }

    @Override
    public String getDescription() {
        return bike.getDescription() + "," + description;
    }

    @Override
    public int getPrice() {
        return bike.getPrice() + 100;
    }
}
