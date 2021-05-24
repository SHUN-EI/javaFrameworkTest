package com.mo.service;

import com.mo.aspect.LogInfo;
import com.mo.filter.LogFilter;
import com.mo.model.LogDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by mo on 2021/5/24
 */
@Service
public class OrderService {

    private static final Logger logger = LoggerFactory.getLogger("kafka");

    @LogInfo
    public String addOrder() {

        LogDO logDO = LogFilter.threadLocal.get();
        logDO.setMessage("OrderService: addOrder");
        logger.info(logDO.toString());
        return "下单成功";
    }
}
