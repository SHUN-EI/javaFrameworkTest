package com.mo.designPattern.flyweight;

/**
 * Created by mo on 2020/11/23
 * 具体享元⻆⾊：实现抽象⻆⾊规定的⽅法
 * 如果存在内部状态，就负责为内部状态提供存储空间
 */
public class ConcreteWebSite extends CloudWebSite {

    private String category;

    public ConcreteWebSite(String category) {
        this.category = category;
    }

    @Override
    public void run(Company company) {

        System.out.println("网站分类是 " + category + ", 公司是" + company.getName());
    }
}
