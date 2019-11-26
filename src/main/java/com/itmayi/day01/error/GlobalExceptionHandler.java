package com.itmayi.day01.error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 全局捕获异常案例
 * 1、捕获返回json格式的
 * 2、捕获返回页面
 */
@ControllerAdvice(basePackages="com.itmayi.day01")
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);


    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public Map<String, Object> errorResult(){
        Map<String, Object> errorResultMap = new HashMap<>();
        errorResultMap.put("errorCode", "500");
        errorResultMap.put("errorMsg", "系统错误");
        //可以使用lombok框架替换Log框架
        logger.info("errorMsg");
        return errorResultMap;
    }


}
