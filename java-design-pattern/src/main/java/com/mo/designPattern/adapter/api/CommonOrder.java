package com.mo.designPattern.adapter.api;

/**
 * Created by mo on 2020/11/21
 */
public class CommonOrder extends PayGatewayAdapter {

    @Override
    public void unifiedorder() {
        System.out.println("普通用户，下单成功");
    }

    @Override
    public void refund() {
        System.out.println("普通用户,退款");
    }
}
