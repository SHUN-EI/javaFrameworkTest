package com.mo.designPattern.iterator;

/**
 * Created by mo on 2020/11/26
 * 抽象迭代器
 */
public interface Iterator {

    /**
     * 获取下个元素
     * @return
     */
    Object next();

    /**
     * 是否有下一个
     * @return
     */
    boolean hasNext();

    /**
     * 删除元素
     * @param obj
     * @return
     */
    Object remove(Object obj);
}
