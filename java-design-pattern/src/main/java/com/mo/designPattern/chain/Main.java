package com.mo.designPattern.chain;

/**
 * Created by mo on 2020/11/26
 */
public class Main {
    public static void main(String[] args) {
        RiskControlManager firstRiskControlManager = new FirstRiskControlManager("初级风控");
        RiskControlManager secondRiskControlManager = new SecondRiskControlManager("中级风控");
        RiskControlManager thirdRiskControlManager = new ThirdRiskControlManager("高级风控");

        //形成调用链
        firstRiskControlManager.setSuperior(secondRiskControlManager);
        secondRiskControlManager.setSuperior(thirdRiskControlManager);

        Request request = new Request();
        request.setRequestType(RequestType.TRANSFER.name());
        request.setMoney(10000);
        firstRiskControlManager.handlerRequest(request);
    }

}
