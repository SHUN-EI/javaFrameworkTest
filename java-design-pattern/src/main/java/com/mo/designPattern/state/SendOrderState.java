package com.mo.designPattern.state;

/**
 * Created by mo on 2020/11/28
 */
public class SendOrderState implements  State {

    @Override
    public void handle() {
        System.out.println("订单已经发货");
        System.out.println("调用短信服务，告诉用户已经发货");
        System.out.println("更新物流信息\n");
    }
}
