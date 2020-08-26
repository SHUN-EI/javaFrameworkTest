package com.sixcapital.juc.lock;

/**
 * Created by mo on 2020/8/26
 * <p>
 * 可重⼊锁：也叫递归锁，在外层使⽤锁之后，在内层仍然可以使⽤，并且不发⽣死锁
 */
public class MyReentrantLock {

    private boolean isLocked = false;

    //⽤于记录是不是重⼊的线程
    private Thread lockedOwner = null;

    //累计加锁次数，加锁⼀次累加1，解锁⼀次减少1
    private int lockedCount = 0;

    public synchronized void lock() throws InterruptedException {
        System.out.println("当前线程进⼊lock加锁 " + Thread.currentThread().getName());

        //获取当前线程
        Thread currentThread = Thread.currentThread();

        //判断是否是同个线程获取锁, 引⽤地址的⽐较
        while (isLocked && lockedOwner != currentThread) {
            System.out.println("当前线程进⼊wait等待 " + Thread.currentThread().getName());
            System.out.println("当前锁状态 isLocked = " + isLocked);
            System.out.println("当前count数量 lockedCount = " + lockedCount);

            //调用当前对象的wait()方法
            wait();
        }

        //进行加锁
        isLocked = true;
        lockedOwner = currentThread;
        lockedCount++;
    }

    public synchronized void unLock() {
        System.out.println("当前线程进⼊unlock解锁 " + Thread.currentThread().getName());

        //获取当前线程
        Thread currentThread = Thread.currentThread();

        //线程A加的锁，只能由线程A来解锁，其他线程不能解锁
        if (currentThread == lockedOwner) {
            lockedCount--;

            if (lockedCount == 0) {
                isLocked = false;
                lockedOwner = null;

                //唤醒对象锁池里面的一个线程
                notify();
            }
        }
    }

}
