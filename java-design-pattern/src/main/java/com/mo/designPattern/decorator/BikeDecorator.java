package com.mo.designPattern.decorator;

/**
 * Created by mo on 2020/11/22
 * 装饰者组件 Decorator
 */
public class BikeDecorator implements Bike {

    private String description = "我只是装饰器，啥都不表示，子类帮我传递";

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public int getPrice() {
        return 0;
    }
}
