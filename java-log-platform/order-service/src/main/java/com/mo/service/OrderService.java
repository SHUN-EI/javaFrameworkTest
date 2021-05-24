package com.mo.service;

import com.mo.aspect.LogInfo;
import com.mo.filter.LogFilter;
import com.mo.model.LogDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by mo on 2021/5/24
 */
@Service
public class OrderService {

    private static final Logger logger = LoggerFactory.getLogger("kafka");

    @Autowired
    private RestTemplate restTemplate;

    @LogInfo
    public String addOrder() {

        LogDO logDO = LogFilter.threadLocal.get();
        logDO.setMessage("OrderService: addOrder");
        logger.info(logDO.toString());

        logDO.setMessage("before call user-service");
        logger.info(logDO.toString());

        String result = restTemplate.getForObject("http://java-log-platform-user-service/user/info", String.class);

        //模拟远程服务的调用
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        logDO.setMessage("after call user-service, result= " + result);
        logger.info(logDO.toString());

        return "下单成功";
    }
}
