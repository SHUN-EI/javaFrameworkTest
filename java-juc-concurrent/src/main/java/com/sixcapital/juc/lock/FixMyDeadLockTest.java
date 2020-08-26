package com.sixcapital.juc.lock;

/**
 * Created by mo on 2020/8/26
 */
public class FixMyDeadLockTest {

    private static String localA = "localA";

    private static String localB = "localB";

    public void methodA() {
        synchronized (localA) {
            System.out.println("⽅法A中获得了锁A" + Thread.currentThread().getName());

            //让出CPU执⾏权，不释放锁
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        synchronized (localB) {
            System.out.println("⽅法A中获得了锁B" + Thread.currentThread().getName());
        }
    }

    public void methodB() {
        synchronized (localB) {
            System.out.println("⽅法B中获得了锁B" + Thread.currentThread().getName());

            //让出CPU执⾏权，不释放锁
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        synchronized (localA) {
            System.out.println("⽅法B中获得了锁A" + Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        System.out.println("主线程运⾏开始运行:" + Thread.currentThread().getName());

        FixMyDeadLockTest fixMyDeadLockTest = new FixMyDeadLockTest();

        for (int i = 0; i < 10; i++) {
            new Thread(() -> fixMyDeadLockTest.methodA()).start();
            new Thread(() -> fixMyDeadLockTest.methodB()).start();
        }

        System.out.println("主线程运⾏结束:" + Thread.currentThread().getName());
    }
}
