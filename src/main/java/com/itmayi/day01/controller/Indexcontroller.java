package com.itmayi.day01.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@RestController
//扫包只能扫当前类
public class Indexcontroller {

    /**
     * 在微服务的情况下，基本上都在类上加
     * @RequestController
     * 修饰的类下的所有方法，全部都是返回json
     * 格式，这样的话，不用在方法上加Response
     */
    @RequestMapping("/index")
    public String index(){

        return "每特教育，这是我的第一个SpringBoot项目";
    }

    /**
     * @EnableAutoConfiguration
     *
     * 作用开启自动装配，去加载整个jar包依赖信息。
     * 装配到Spring日勇气中。
     */
/*
    public static void main(String[] args) {
        //告诉SpringBoot程序的入口
        SpringApplication.run(Indexcontroller.class, args);
    }
*/

}
