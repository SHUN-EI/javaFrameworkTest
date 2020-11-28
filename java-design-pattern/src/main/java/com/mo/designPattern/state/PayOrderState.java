package com.mo.designPattern.state;

/**
 * Created by mo on 2020/11/28
 */
public class PayOrderState implements State {

    @Override
    public void handle() {
        System.out.println("新订单已经支付");
        System.out.println("调用商户客服务，订单已经支付");
        System.out.println("调用物流服务，未发货\n");
    }
}
