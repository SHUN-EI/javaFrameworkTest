package com.mo.designPattern.strategy;

/**
 * Created by mo on 2020/11/23
 */
public class VoucherActivity extends Strategy {

    private double voucher;

    public VoucherActivity(double voucher) {
        this.voucher = voucher;
    }

    @Override
    public double computePrice(ProductOrder productOrder) {

        if (productOrder.getOldPrice() > voucher) {
            return productOrder.getOldPrice() - voucher;
        }
        return 0;
    }
}
