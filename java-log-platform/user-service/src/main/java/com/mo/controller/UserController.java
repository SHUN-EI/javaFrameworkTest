package com.mo.controller;

import com.mo.aspect.LogInfo;
import com.mo.filter.LogFilter;
import com.mo.model.LogDO;
import org.apache.commons.lang3.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mo on 2021/5/20
 */
@RequestMapping("/user")
@RestController
public class UserController {

    private static Logger logger = LoggerFactory.getLogger("kafka");

    @LogInfo
    @GetMapping("/check")
    public Boolean check(@RequestParam("username") String username, @RequestParam("password") String password) {

        //check username and password

        LogDO logDO = LogFilter.threadLocal.get();
        logDO.setMessage("correct user");
        logger.info(logDO.toString());
        return true;
    }

    @LogInfo
    @GetMapping("/info")
    public String info() {
        LogDO logDO = LogFilter.threadLocal.get();
        logDO.setMessage("UserController: info");
        logger.info(logDO.toString());
        return "曹操";
    }

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
