package com.mo.designPattern.state;

/**
 * Created by mo on 2020/11/28
 */
public class NewOrderState implements State {

    @Override
    public void handle() {
        System.out.println("新订单，未支付");
        System.out.println("调用商户客服务，有新订单\n");
    }
}
