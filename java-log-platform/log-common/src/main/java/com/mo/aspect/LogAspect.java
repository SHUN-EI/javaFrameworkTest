package com.mo.aspect;

import com.mo.filter.LogFilter;
import com.mo.model.LogDO;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by mo on 2021/5/24
 * 日志切面
 */
@Aspect
@Component
public class LogAspect {

    private static final Logger logger = LoggerFactory.getLogger("kafka");

    @Pointcut("@annotation(com.mo.aspect.LogInfo)")
    public void log() {
    }


    /**
     * 环绕通知
     *
     * @return
     */
    @Around(value = "log()")
    public Object arround(ProceedingJoinPoint point) {

        try {
            MethodSignature signature = (MethodSignature) point.getSignature();
            //获取className
            String className = point.getTarget().getClass().getSimpleName();
            //获取methodName
            String methodName = signature.getName();

            //获取日志对象
            LogDO logDO = LogFilter.threadLocal.get();
            logDO.setMessage("before: " + className + "." + methodName);
            logger.info(logDO.toString());

            //切面放行，让方法执行
            Object proceed = point.proceed();

            logDO.setMessage("after: " + className + "." + methodName);
            logger.info(logDO.toString());

            return proceed;
        } catch (Throwable e) {
            e.printStackTrace();
            return null;
        }
    }
}
