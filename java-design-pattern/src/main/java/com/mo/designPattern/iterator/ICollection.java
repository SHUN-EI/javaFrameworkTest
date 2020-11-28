package com.mo.designPattern.iterator;

/**
 * Created by mo on 2020/11/26
 */
public interface ICollection {

    void add(Object obj);

    void remove(Object obj);

    Iterator iterator();
}
