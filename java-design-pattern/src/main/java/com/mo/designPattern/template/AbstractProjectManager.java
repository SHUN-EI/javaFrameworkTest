package com.mo.designPattern.template;

/**
 * Created by mo on 2020/11/23
 * 抽象类
 */
public abstract class AbstractProjectManager {


    /**
     * 定义模板方法，声明final，防止子类覆盖他，更改顺序，流程是一样复用
     */
    public final void processProject() {
        review();
        design();
        coding();
        test();
        online();
    }

    /**
     * 各个项目都需要评审,具体方法
     */
    public void review() {
        System.out.println("项目需求评审");
    }

    /**
     * 各个项目都需要设计，具体方法
     */
    public void design() {
        System.out.println("UI UE进行设计");
    }

    /**
     * 抽象方法，由就具体子类进行实现，编码耗时不一样
     */
    public abstract void coding();

    /**
     * 抽象方法，由就具体子类进行实现，测试有多种，自动化测试、安全测试、压力测试、手工测试
     */
    public abstract void test();

    /**
     * 抽象方法，由就具体子类进行实现，上线有全量发布，灰度发布，停机发布
     */
    public abstract void online();
}
