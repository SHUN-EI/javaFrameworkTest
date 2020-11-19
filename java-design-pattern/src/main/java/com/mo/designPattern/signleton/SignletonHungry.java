package com.mo.designPattern.signleton;

/**
 * Created by mo on 2020/11/19
 * 单例设计模式 - 饿汉实现方式
 * <p>
 * 单例设计模式的实现步骤
 * 私有化构造函数
 * 提供获取单例的⽅法
 */
public class SignletonHungry {

    private static SignletonHungry instance = new SignletonHungry();

    /**
     * 构造函数私有化
     */
    private SignletonHungry() {
    }

    /**
     * 单例对象的方法
     */
    public void process() {
        System.out.println("SignletonLazy对象方法调用成功");
    }

    public static SignletonHungry getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        SignletonHungry.getInstance().process();
    }
}
