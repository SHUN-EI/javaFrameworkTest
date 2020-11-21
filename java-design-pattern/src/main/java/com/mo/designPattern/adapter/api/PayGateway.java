package com.mo.designPattern.adapter.api;

/**
 * Created by mo on 2020/11/21
 */
public interface PayGateway {

    /**
     * 统一下单
     */
    void unifiedorder();

    /**
     * 退款
     */
    void refund();

    /**
     * 查询支付状态
     */
    void query();

    /**
     * 发红包
     */
    void sendRedPack();
}
