package com.mo.designPattern.factory.wechat;

import com.mo.designPattern.factory.RefundFactory;

/**
 * Created by mo on 2020/11/20
 */
public class WechatRefund implements RefundFactory {

    @Override
    public void refund() {
        System.out.println("微信支付 退款");
    }
}
