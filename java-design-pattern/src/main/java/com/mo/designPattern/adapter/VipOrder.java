package com.mo.designPattern.adapter;

/**
 * Created by mo on 2020/11/21
 */
public class VipOrder extends  PayGatewayAdapter {

    @Override
    public void unifiedorder() {
        System.out.println("vip用户，下单成功");
    }

    @Override
    public void refund() {
        System.out.println("vip用户，退款");
    }

    @Override
    public void sendRedPack() {
        System.out.println("vip用户，发红包");
    }
}
