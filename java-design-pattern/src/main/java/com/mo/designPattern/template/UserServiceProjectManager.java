package com.mo.designPattern.template;

/**
 * Created by mo on 2020/11/23
 */
public class UserServiceProjectManager extends  AbstractProjectManager {

    @Override
    public void coding() {
        System.out.println("开发耗时10天");
    }

    @Override
    public void test() {
        System.out.println("功能测试，压力测试,还有手工测试");
    }

    @Override
    public void online() {
        System.out.println("灰度发布，全量上线");
    }
}
