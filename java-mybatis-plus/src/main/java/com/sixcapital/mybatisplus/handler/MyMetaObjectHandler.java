package com.sixcapital.mybatisplus.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.Date;

/**
 * Created by mo on 2020/9/8
 */
@Slf4j
@Component// 一定不要忘记把处理器加到IOC容器中！
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert fill.....");
        this.strictInsertFill(metaObject, "create_time", LocalTime.class, LocalTime.now());
        this.strictUpdateFill(metaObject, "update_time", LocalTime.class, LocalTime.now());
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start update fill.....");
        this.strictUpdateFill(metaObject,"update_time",LocalTime.class,LocalTime.now());
    }
}
