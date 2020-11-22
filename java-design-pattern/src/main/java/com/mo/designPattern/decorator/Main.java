package com.mo.designPattern.decorator;

/**
 * Created by mo on 2020/11/22
 */
public class Main {

    public static void main(String[] args) {
        //选个自行车
        Bike bike = new BigBike();

        //搭配个RSC防爆胎
        bike = new RSCBikeDecorator(bike);

        //搭配个喇叭
        bike = new SuonaBikeDecorator(bike);

        System.out.println(bike.getDescription() + ", 价格:" + bike.getPrice());
    }
}
