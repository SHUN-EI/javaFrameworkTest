package com.mo.designPattern.factory.method;

import com.mo.designPattern.factory.PayFactory;
import com.mo.designPattern.factory.wechat.WechatPay;

/**
 * Created by mo on 2020/11/20
 */
public class WechatPayFactory implements PayMethodFactory {

    @Override
    public PayFactory getPay() {
        return new WechatPay();
    }
}
