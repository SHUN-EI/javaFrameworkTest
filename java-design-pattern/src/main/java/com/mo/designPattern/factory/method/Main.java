package com.mo.designPattern.factory.method;

import com.mo.designPattern.factory.PayFactory;

/**
 * Created by mo on 2020/11/20
 */
public class Main {
    public static void main(String[] args) {
        PayMethodFactory aliPayFactory = new AliPayFactory();
        PayFactory aliPay = aliPayFactory.getPay();
        aliPay.unifiedorder();
    }

}
