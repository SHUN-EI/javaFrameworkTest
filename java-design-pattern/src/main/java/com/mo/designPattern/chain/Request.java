package com.mo.designPattern.chain;

/**
 * Created by mo on 2020/11/26
 */
public class Request {

    /**
     * 类别
     */
    private String requestType;

    /**
     * 金额
     */
    private int money;

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
