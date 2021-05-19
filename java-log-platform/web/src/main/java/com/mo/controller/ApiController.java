package com.mo.controller;

import com.mo.model.LogDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mo on 2021/5/19
 */
@RestController
@RequestMapping("/api")
public class ApiController {

    private static final Logger logger = LoggerFactory.getLogger(ApiController.class);

    @GetMapping("/test")
    public Object test() {

        LogDO logDo = LogDO.builder()
                .rid("requestId")
                .sid("user")
                .tid("pc")
                .from("nginx")
                .message("I am from nginx")
                .build();

        logger.info(logDo.toString());
        return logDo;
    }
}
