package com.mo.designPattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mo on 2020/11/23
 * 消息发布者
 */
public class Subject {

    private List<Observer> observers = new ArrayList<>();

    /**
     * 新增观察者
     *
     * @param observer
     */
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    /**
     * 删除观察者
     *
     * @param observer
     */
    public void deleteObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyAllObserver() {
        observers.forEach(o -> o.update());
    }

}
