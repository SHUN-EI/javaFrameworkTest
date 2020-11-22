package com.mo.designPattern.decorator;

/**
 * Created by mo on 2020/11/22
 * 具体的被装饰者，ConcreteComponent
 */
public class BigBike implements Bike {

    private String description = "大号自行车";

    @Override
    public String getDescription() {
        return description;
    }

    /**
     * 200元是大号自行车的价格
     * @return
     */
    @Override
    public int getPrice() {
        return 200;
    }
}
