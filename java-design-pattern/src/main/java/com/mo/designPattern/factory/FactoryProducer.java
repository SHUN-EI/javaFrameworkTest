package com.mo.designPattern.factory;

import com.mo.designPattern.factory.ali.AliOrderFactory;
import com.mo.designPattern.factory.wechat.WechatOrderFactory;

/**
 * Created by mo on 2020/11/20
 */
public class FactoryProducer {

    public static OrderFactory getFactory(String type) {

        if (type.equalsIgnoreCase("WECHAT")) {
            return new WechatOrderFactory();
        } else if (type.equalsIgnoreCase("ALI")) {
            return new AliOrderFactory();
        }

        return null;
    }
}
