package com.mo.designPattern.chain;

/**
 * Created by mo on 2020/11/26
 * 风控级别抽象类
 */
public abstract class RiskControlManager {

    protected String name;

    /**
     * 更严格的风控策略
     */
    protected RiskControlManager superior;

    public RiskControlManager(String name) {
        this.name = name;
    }

    /**
     * 设置更严格的风控策略
     *
     * @param manager
     */
    public void setSuperior(RiskControlManager manager) {
        this.superior = manager;
    }

    /**
     * 处理请求
     *
     * @param request
     */
    public abstract void handlerRequest(Request request);

}
