package com.mo.designPattern.chain;

/**
 * Created by mo on 2020/11/26
 */
public class ThirdRiskControlManager extends RiskControlManager {

    public ThirdRiskControlManager(String name) {
        super(name);
    }

    /**
     * 处理 1万以上的
     *
     * @param request
     */
    @Override
    public void handlerRequest(Request request) {
        if (RequestType.valueOf(request.getRequestType()) != null && request.getMoney() >= 10000) {
            System.out.println("大额操作，输入支付密码+验证码+人脸识别 ");

            System.out.println(name + ":" + request.getRequestType() + ", 金额:" + request.getMoney() + " 处理完成");

        } else {
            //下个级别策略进行处理
            if (superior != null) {
                superior.handlerRequest(request);
            } else {
                System.out.println("处理异常");
            }
        }
    }
}
