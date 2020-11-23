package com.mo.designPattern.flyweight;

/**
 * Created by mo on 2020/11/23
 * 抽象享元⻆⾊：为具体享元⻆⾊规定了必须实现的方法,外部状态就是以参数的形式通过此⽅法传⼊
 */
public abstract class CloudWebSite {

    public abstract void run(Company company);
}
