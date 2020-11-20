package com.mo.designPattern.factory.ali;

import com.mo.designPattern.factory.PayFactory;

/**
 * Created by mo on 2020/11/20
 */
public class AliPay implements PayFactory {

    @Override
    public void unifiedorder() {
        System.out.println("支付宝支付 统一下单接口");
    }
}
