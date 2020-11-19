package com.mo.juc.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by mo on 2020/8/25
 */
public class MyLockTest {

    private int num = 0;

    //使⽤lock，每个对象都是有锁，只有获得这个锁才可以进⾏对应的操作
    Lock lock = new ReentrantLock();

    public void add1() {
        lock.lock();
        try {
            num++;
        } finally {
            lock.unlock();
        }
    }

    //使⽤synchronized，和上述是⼀个操作，这个是保证⽅法被锁住⽽已，上述的是代码块被锁住
    public synchronized void add2() {
        num++;
    }

}
