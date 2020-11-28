package com.mo.designPattern.iterator;

/**
 * Created by mo on 2020/11/26
 */
public class Main {

    public static void main(String[] args) {
        ICollection collection = new MyCollection();

        collection.add("吕布");
        collection.add("刘备");
        collection.add("关羽");
        collection.add("张飞");
        collection.add("曹操");

        Iterator it = collection.iterator();

        while (it.hasNext()) {
            Object obj = it.next();
            System.out.println(obj);
        }
    }
}
