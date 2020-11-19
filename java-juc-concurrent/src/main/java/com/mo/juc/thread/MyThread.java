package com.mo.juc.thread;

import java.util.concurrent.*;

/**
 * Created by mo on 2020/8/25
 */
public class MyThread extends Thread implements Runnable, Callable {

    @Override
    public Object call() throws Exception {
        System.out.println(Thread.currentThread().getName());
        return null;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }

    /**
     * 线程创建方法7：通过Lambda表达式去创建线程
     * @param args
     */
    public static void main(String[] args) {
        new Thread(()-> System.out.println("通过Lambda表达式去创建线程 "+Thread.currentThread().getName())).start();
    }

    //创建多个线程
    public static void main8(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            executorService.execute(new MyThread());
        }
        executorService.shutdown();
    }


    /**
     * 线程创建方法6：通过Executors线程池去创建线程
     *
     * @param args
     */
    public static void main7(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(() -> System.out.println("通过Executors线程池去创建线程 " + Thread.currentThread().getName()));
        executorService.shutdown();
    }


    /**
     * 线程创建方法5:实现Callable接口,并实现call()方法，
     * 结合FutureTask类包装Callable对象，创建线程
     *
     * @param args
     */
    public static void main6(String[] args) {
        MyThread thread = new MyThread();
        FutureTask<Object> task = new FutureTask<>(thread);

        Thread myThread = new Thread(task);
        myThread.setName("我的线程,通过实现Callable去实现多线程");
        myThread.start();
    }

    /**
     * 线程创建方法4:通过FutureTask类去创建线程
     * <p>
     * FutureTask继承了Runnable，可以放在Thread中启动执行
     *
     * @param args
     */
    public static void main5(String[] args) {
        FutureTask futureTask = new FutureTask<>(() -> {
            System.out.println("通过FutureTask类去创建线程 " + Thread.currentThread().getName());
            return null;
        });

        //FutureTask继承了Runnable，可以放在Thread中启动执行
        Thread thread = new Thread(futureTask);
        thread.setName("我的线程,通过实现FutureTask类去创建线程");
        thread.start();
    }

    /**
     * 线程创建方法3：使用匿名内部类
     * 匿名内部类可使用Lambda表达式
     *
     * @param args
     */
    public static void main4(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("通过匿名内部类去创建线程 " + Thread.currentThread().getName());
            }
        });
        thread.setName("我的线程，使用匿名内部类");
        thread.start();
    }

    /**
     * 线程创建方法2：实现 Runnable 接口，并实现run 方法(java是单继承、多实现的)
     * Thread类也实现了Runnable
     *
     * @param args
     */
    public static void main3(String[] args) {
        Thread thread = new Thread(new MyThread());
        thread.setName("我的线程，implements Runnable");
        thread.start();
    }

    /**
     * 线程创建方法1：继承Thread 并重写父类的run()方法
     *
     * @param args
     */
    public static void main2(String[] args) {
        MyThread thread = new MyThread();
        thread.setName("我的线程, extends Thread");
        thread.start();
    }

}
