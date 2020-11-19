package com.mo.juc.lock;

/**
 * Created by mo on 2020/8/26
 */
public class MyUnReentrantLockTest {
    private MyUnReentrantLock unReentrantLock = new MyUnReentrantLock();

    public void methodA() {
        //加锁建议在try⾥⾯，解锁建议在finally
        try {
            unReentrantLock.lock();
            System.out.println("methodA⽅法被调⽤");
            methodB();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            unReentrantLock.unLock();
        }
    }

    public void methodB() {
        try {
            unReentrantLock.lock();
            System.out.println("methodB⽅法被调⽤");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            unReentrantLock.unLock();
        }
    }

    public static void main(String[] args) {
        //同⼀个线程，重复获取锁失败，形成死锁，这个就是不可重⼊锁
        new MyUnReentrantLockTest().methodA();
    }
}
