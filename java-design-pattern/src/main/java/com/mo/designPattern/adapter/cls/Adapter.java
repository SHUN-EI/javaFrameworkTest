package com.mo.designPattern.adapter.cls;

/**
 * Created by mo on 2020/11/21
 */
public class Adapter extends OldModule implements TargetModule {

    /**
     * 新的方法，和OldModule的类方法不一样
     */
    @Override
    public void methodB() {
        System.out.println("Adapter methodB");
    }

    /**
     * 新的方法，和OldModule的类方法不一样
     */
    @Override
    public void methodC() {
        System.out.println("Adapter methodC");
    }
}
