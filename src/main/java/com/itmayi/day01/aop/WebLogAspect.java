package com.itmayi.day01.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@Aspect
@Component
public class WebLogAspect {

    private static final Logger logger = LoggerFactory.getLogger(WebLogAspect.class);

    //pointCut要切入的地方
    @Pointcut("execution(* com.itmayi.day01.controller.*.*(..))")
    public void webLog(){
        System.out.println("--------------日志打印开始--------------");
    }

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {

        /**
         * 记录日志
         * 接收到请求，记录请求内容，记录最多半年数据
         * 迁移云备份到nosql
         */

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        HttpServletRequest request = attributes.getRequest();

        logger.info("URL:{}", request.getRequestURL().toString());
        logger.info("Http_method:{}", request.getMethod());
        logger.info("ip:{}", request.getRemoteAddr());

        Enumeration<String> enumn = request.getParameterNames();

        while (enumn.hasMoreElements()) {
            String name = enumn.nextElement();
            logger.info("name:{}, value:{}" + name, request.getParameter(name));
        }
    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret){

        logger.info("响应值："+ret);
    }

}
