package com.mo.controller;

import com.mo.model.LogDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    @GetMapping("/test")
    public Object test() {

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
