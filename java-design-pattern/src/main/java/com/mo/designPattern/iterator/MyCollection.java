package com.mo.designPattern.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mo on 2020/11/26
 */
public class MyCollection implements ICollection {

    private List list = new ArrayList();

    @Override
    public void add(Object obj) {
        list.add(obj);
    }

    @Override
    public void remove(Object obj) {
        list.remove(obj);
    }

    @Override
    public Iterator iterator() {
        return new ConcreteIterator(list);
    }
}
