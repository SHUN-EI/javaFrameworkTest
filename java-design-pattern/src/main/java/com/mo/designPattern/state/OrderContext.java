package com.mo.designPattern.state;

/**
 * Created by mo on 2020/11/28
 */
public class OrderContext {

    private State state;

    public OrderContext() {
    }

    public void setState(State state) {
        this.state = state;
        System.out.println("订单状态变更!!");
        this.state.handle();
    }
}
