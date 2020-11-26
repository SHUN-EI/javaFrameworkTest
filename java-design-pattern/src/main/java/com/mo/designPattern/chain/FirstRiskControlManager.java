package com.mo.designPattern.chain;

import java.net.SocketTimeoutException;

/**
 * Created by mo on 2020/11/26
 */
public class FirstRiskControlManager extends RiskControlManager {

    public FirstRiskControlManager(String name) {
        super(name);
    }

    /**
     *  1000元以内可以直接处理
     * @param request
     */
    @Override
    public void handlerRequest(Request request) {
        if (RequestType.valueOf(request.getRequestType())!=null && request.getMoney()<=1000){
            System.out.println("普通操作，输入支付密码即可");
            System.out.println(name+": "+request.getRequestType()+", 金额:"+request.getMoney()+"处理完成");
        }else {

            //下个级别策略进行处理
            if (superior!=null){
                superior.handlerRequest(request);
            }
        }
    }
}
