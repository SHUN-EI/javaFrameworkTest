package com.mo.designPattern.singleton;

/**
 * Created by mo on 2020/11/19
 * 单例设计模式 - 懒汉实现方式
 *
 * 单例设计模式的实现步骤
 * 私有化构造函数
 * 提供获取单例的⽅法
 */
public class SingletonLazy {

    //private static SignletonLazy instance;

    /**
     * 构造函数私有化
     */
    private SingletonLazy() {
    }

    /**
     * 单例对象的方法
     */
    public void process() {
        System.out.println("SignletonLazy对象方法调用成功");
    }

    /**
     * 第一种方式
     * 对外暴露一个方法获取类的对象
     * <p>
     * 线程不安全，多线程下存在安全问题
     */
    public static SingletonLazy getInstance1() {
        if (instance == null) {
            instance = new SingletonLazy();
        }
        return instance;
    }

    /**
     * 第二种实现方式
     * 通过加锁 synchronized 保证单例
     * <p>
     * 采用synchronized 对方法加锁有很大的性能开销
     * 解决办法：锁粒度不要这么大
     *
     * @return
     */
    public static synchronized SingletonLazy getInstance2() {
        if (instance == null) {
            instance = new SingletonLazy();
        }
        return instance;
    }

    //锁粒度虽然够小，但是没法完全保证线程安全问题
    public static SingletonLazy getInstance3_1() {
        if (instance == null) {
            //若A、B两个线程都通过非空判断，即到这里若A创建了对象实例，释放锁之后，B拿到锁后也会进入创建对象
            synchronized (SingletonLazy.class) {
                instance = new SingletonLazy();
            }
        }
        return instance;
    }

    /**
     * 第三种实现方式
     * <p>
     * DCL 双重检查锁定 （Double-Checked-Locking）,在多线程情况下保持高性能
     * <p>
     * 这是否安全，不是完全安全的，还是存在安全问题
     * <p>
     * instance = new SingletonLazy(); 并不是原子性操作
     * JVM创建对象的步骤是
     * 1、分配空间给对象
     * 2、在空间内创建对象
     * 3、将对象赋值给引用instance
     * <p>
     * 若JVM在指令重排的情况下，(JVM是不会知道应该按顺序去执行的)
     * 假如线程 1-》3-》2顺序，会把值写会主内存，其他线程就会读取到instance最新的值，但是这个是不完全的对象
     * (指令重排)
     *
     * @return
     */
    public static SingletonLazy getInstance3() {
        if (instance == null) {
            synchronized (SingletonLazy.class) {
                if (instance == null) {
                    instance = new SingletonLazy();
                }
            }
        }
        return instance;
    }

    /**
     * volatile是轻量级的synchronized，保证了共享变量的可⻅性，
     * 被volatile关键字修饰的变量，如果值发⽣了变化，其他线程⽴刻可⻅，避免出现脏读现象
     *
     * volatile与synchronized的区别
     * volatile：保证可⻅性，但是不能保证原⼦性
     * synchronized：保证可⻅性，也保证原⼦性
     *
     * volatile使⽤场景
     * 1、不能修饰写⼊操作依赖当前值的变量，⽐如num++、num=num+1,
     * 不是原⼦操作，⾁眼看起来 是，但是JVM字节码层⾯不⽌⼀步
     *
     * 2、由于禁⽌了指令重排，所以JVM相关的优化没了，效率会偏弱
     *
     * volatile是Java提供的关键字，它具有可见性和有序性，
     * 指令重排序是JVM对语句执行的优化，只要语句间没有依赖，那JVM就有权对语句进行优化
     * 禁止了指令重排
     */
    public static volatile SingletonLazy instance;

    public static SingletonLazy getInstance() {
        if (instance == null) {
            synchronized (SingletonLazy.class) {
                if (instance == null) {
                    instance = new SingletonLazy();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        SingletonLazy.getInstance().process();
    }

}
