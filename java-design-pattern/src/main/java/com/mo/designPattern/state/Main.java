package com.mo.designPattern.state;

/**
 * Created by mo on 2020/11/28
 */
public class Main {

    public static void main(String[] args) {

        OrderContext context = new OrderContext();
        context.setState(new NewOrderState());
        context.setState(new PayOrderState());
        context.setState(new SendOrderState());

    }
}
