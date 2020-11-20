package com.mo.designPattern.factory.method;

import com.mo.designPattern.factory.PayFactory;

/**
 * Created by mo on 2020/11/20
 * 工厂方法模式
 */
public interface PayMethodFactory {

    PayFactory getPay();
}
