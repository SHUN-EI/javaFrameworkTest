package com.mo.designPattern.flyweight;

/**
 * Created by mo on 2020/11/23
 * 客户端⻆⾊：维护对所有享元对象的引⽤，⽽且还需要存储对应的外部状态
 */
public class Company {

    private String name;

    public Company() {
    }

    public Company(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
