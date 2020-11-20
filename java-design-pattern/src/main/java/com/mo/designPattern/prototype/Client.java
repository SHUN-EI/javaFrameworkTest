package com.mo.designPattern.prototype;

/**
 * Created by mo on 2020/11/20
 */
public class Client {

    public static void main(String[] args) throws CloneNotSupportedException {
        Person p1 = new Person();
        p1.setAge(20);
        p1.setName("赵云");
        p1.getList().add("aaa");

        //浅拷贝
        Person p2 = p1.clone();
        p2.setName("张飞");
        p2.getList().add("bbb");

        System.out.println("person1=" + p1.getName() + ", age=" + p1.getAge()+", list="+p1.getList());
        System.out.println("person2=" + p2.getName() + ", age=" + p2.getAge()+", list="+p2.getList());

    }
}
