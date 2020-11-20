package com.mo.designPattern.factory.simple;

import com.mo.designPattern.factory.PayFactory;
import com.mo.designPattern.factory.ali.AliPay;
import com.mo.designPattern.factory.wechat.WechatPay;

/**
 * Created by mo on 2020/11/20
 * 简单工厂模式
 */
public class PaySimpleFactory {

    /**
     * 根据参数 返回对应的支付对象
     *
     * @param payType
     * @return
     */
    public static PayFactory createPay(String payType) {
        if (payType == null) {
            return null;
        } else if (payType.equalsIgnoreCase("WECHAT_PAY")) {
            return new WechatPay();
        } else if (payType.equalsIgnoreCase("ALI_PAY")) {
            return new AliPay();
        }

        return null;
    }

    public static void main(String[] args) {
        PayFactory pay = PaySimpleFactory.createPay("WECHAT_PAY");
        pay.unifiedorder();
    }
}
