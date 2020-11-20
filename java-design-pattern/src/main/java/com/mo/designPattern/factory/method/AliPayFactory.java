package com.mo.designPattern.factory.method;

import com.mo.designPattern.factory.PayFactory;
import com.mo.designPattern.factory.ali.AliPay;

/**
 * Created by mo on 2020/11/20
 */
public class AliPayFactory implements PayMethodFactory {

    @Override
    public PayFactory getPay() {
        return new AliPay();
    }
}
