package com.mo.juc.lock;

/**
 * Created by mo on 2020/8/26
 */
public class MyReentrantLockTest {

    private MyReentrantLock reentrantLock = new MyReentrantLock();

    public void methodA() {
        //加锁建议在try⾥⾯，解锁建议在finally
        try {
            reentrantLock.lock();
            System.out.println("methodA⽅法被调⽤");
            methodB();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unLock();
        }
    }

    public void methodB() {
        try {
            reentrantLock.lock();
            System.out.println("methodB⽅法被调⽤");
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            reentrantLock.unLock();
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            //同⼀个线程，可以重复获取锁，不会死锁，这个就是可重⼊锁
            new MyReentrantLockTest().methodA();
        }
    }
}
