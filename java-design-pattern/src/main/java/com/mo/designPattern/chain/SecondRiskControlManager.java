package com.mo.designPattern.chain;

/**
 * Created by mo on 2020/11/26
 */
public class SecondRiskControlManager extends RiskControlManager {

    public SecondRiskControlManager(String name) {
        super(name);
    }

    /**
     * 处理 1千到1万之间
     *
     * @param request
     */
    @Override
    public void handlerRequest(Request request) {
        if (RequestType.valueOf(request.getRequestType()) != null && request.getMoney() > 1000 && request.getMoney() < 10000) {
            System.out.println("稍大额操作，输入支付密码+短信验证码即可");

            System.out.println(name + ":" + request.getRequestType() + ", 金额:" + request.getMoney() + " 处理完成");

        } else {

            //下个级别策略进行处理
            if (superior!=null){
                superior.handlerRequest(request);
            }
        }
    }
}
