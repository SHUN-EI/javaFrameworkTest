package com.mo.controller;

import com.mo.model.LogDO;
import org.apache.commons.lang3.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mo on 2021/5/20
 */
@RequestMapping("/user")
@RestController
public class UserController {

    private static Logger logger = LoggerFactory.getLogger("kafka");

    @GetMapping("/test")
    public Object test() {

        LogDO logDO = LogDO.builder()
                .rid(RandomUtils.nextLong(10000, 99999) + "")
                .sid("user")
                .tid("pc")
                .from("java:user")
                .message("user test request")
                .build();

        logger.info(logDO.toString());

        return logDO;

    }
}
