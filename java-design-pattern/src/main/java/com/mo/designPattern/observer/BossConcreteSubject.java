package com.mo.designPattern.observer;

/**
 * Created by mo on 2020/11/23
 */
public class BossConcreteSubject extends Subject {

    public void doSomething() {
        System.out.println("老板完成自己的工作");

        //还有其他操作
        System.out.println("视察公司工作情况");
        super.notifyAllObserver();
    }
}
