package com.mo.filter;


import com.mo.model.LogDO;
import com.mo.utils.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by mo on 2021/5/24
 */
@Order(1)
@Configuration
@WebFilter(filterName = "logFilter", urlPatterns = "/*")
public class LogFilter implements Filter {

    //被哪个app引⽤，当前from的⽇志记录就是当前app的名字
    @Value("${spring.application.name}")
    private String appName;
    //slf4j的好处，utils被其他项⽬引⽤时不会给对⽅的⽇志产⽣⼲扰
    private Logger logger = LoggerFactory.getLogger("kafka");


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest servletRequest = (HttpServletRequest) request;
        String rid = CommonUtil.getStringNumRandom(18);
        String tid = CommonUtil.getDevice(servletRequest.getHeader("User-Agent"));
        String ip = CommonUtil.getIpAddress(servletRequest);
        String url = "java: " + servletRequest.getRequestURI();

        LogDO logDO = LogDO.builder().rid(rid).sid("sid").tid(tid).from(appName)
                .ip(ip).url(url).message("I am filter").build();

        logger.info(logDO.toString());
        chain.doFilter(request, response);
    }
}
