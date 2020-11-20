package com.mo.designPattern.factory.ali;

import com.mo.designPattern.factory.RefundFactory;

/**
 * Created by mo on 2020/11/20
 */
public class AliRefund  implements RefundFactory {

    @Override
    public void refund() {
        System.out.println("支付宝 退款");
    }
}
