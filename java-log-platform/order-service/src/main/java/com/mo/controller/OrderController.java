package com.mo.controller;

import com.mo.aspect.LogInfo;
import com.mo.filter.LogFilter;
import com.mo.model.LogDO;
import com.mo.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mo on 2021/5/20
 */
@RequestMapping("/order")
@RestController
public class OrderController {

    private static Logger logger = LoggerFactory.getLogger("kafka");

    @Autowired
    private OrderService orderService;

    @LogInfo
    @GetMapping("/addOrder")
    public Object addOrder() {

        LogDO logDO = LogFilter.threadLocal.get();
        logDO.setMessage("OrderController: addOrder");
        logger.info(logDO.toString());

        String order = orderService.addOrder();
        return order;
    }

    @GetMapping("/test")
    public Object test() {

        return "This is nginx forward test";
    }

    @GetMapping("/test-old")
    public Object testOld() {

        LogDO logDo = LogDO.builder()
                .rid(System.currentTimeMillis() + "")
                .sid("user")
                .tid("windows")
                .from("java:order")
                .message("I am from order")
                .build();

        logger.info(logDo.toString());
        return logDo;
    }
}
