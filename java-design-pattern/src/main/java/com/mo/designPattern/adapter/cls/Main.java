package com.mo.designPattern.adapter.cls;

/**
 * Created by mo on 2020/11/21
 */
public class Main {

    public static void main(String[] args) {
        TargetModule module = new Adapter();
        module.methodA();
        module.methodB();
        module.methodC();
    }
}

