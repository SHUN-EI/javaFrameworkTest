package com.sixcapital.juc.lock;

/**
 * Created by mo on 2020/8/26
 * 不可重⼊锁：若当前线程执⾏某个⽅法已经获取了该锁，那么在⽅法中尝试再次获取锁时，就会获取不到，线程被阻塞
 */
public class MyUnReentrantLock {

    private boolean isLocked = false;

    public synchronized void lock() throws InterruptedException {
        System.out.println("当前线程进⼊lock加锁 " + Thread.currentThread().getName());

        //判断是否已经被锁，如果被锁则当前请求的线程进⾏等待
        while (isLocked) {
            System.out.println("当前线程进⼊wait等待 " + Thread.currentThread().getName());

            //调用当前对象的wait()方法
            wait();
        }

        //进⾏加锁
        isLocked = true;
    }

    public synchronized void unLock() {
        System.out.println("当前线程进⼊unlock解锁 " + Thread.currentThread().getName());
        isLocked = true;

        //唤醒对象锁池里面的一个线程
        notify();
    }

}
