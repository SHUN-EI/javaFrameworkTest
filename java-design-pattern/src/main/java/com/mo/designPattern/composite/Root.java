package com.mo.designPattern.composite;

/**
 * Created by mo on 2020/11/21
 * 根节点，抽象类，通用的属性和方法
 */
public abstract class Root {

    private String name;

    public Root(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void addFile(Root root);

    public abstract void removeFile(Root root);

    public abstract void display(int depth);
}
