package com.mo.designPattern.decorator;

/**
 * Created by mo on 2020/11/22
 */
public class SuonaBikeDecorator extends BikeDecorator {

    private String description = "增加一个喇叭";

    private Bike bike;

    public SuonaBikeDecorator(Bike bike) {
        this.bike = bike;
    }

    @Override
    public String getDescription() {
        return bike.getDescription() + "," + description;
    }

    @Override
    public int getPrice() {
        return bike.getPrice() + 50;
    }
}
