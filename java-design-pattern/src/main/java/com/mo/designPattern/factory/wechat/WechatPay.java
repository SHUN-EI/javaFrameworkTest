package com.mo.designPattern.factory.wechat;

import com.mo.designPattern.factory.PayFactory;

/**
 * Created by mo on 2020/11/20
 * 微信支付
 */
public class WechatPay implements PayFactory {

    @Override
    public void unifiedorder() {
        System.out.println("微信支付支付 统一下单接口");
    }
}
