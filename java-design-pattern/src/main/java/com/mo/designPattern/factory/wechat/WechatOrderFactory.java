package com.mo.designPattern.factory.wechat;

import com.mo.designPattern.factory.OrderFactory;
import com.mo.designPattern.factory.PayFactory;
import com.mo.designPattern.factory.RefundFactory;

/**
 * Created by mo on 2020/11/20
 */
public class WechatOrderFactory implements OrderFactory {

    @Override
    public PayFactory createPay() {
        return new WechatPay();
    }

    @Override
    public RefundFactory createRefund() {
        return new WechatRefund();
    }
}
