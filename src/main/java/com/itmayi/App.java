package com.itmayi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableAsync;


/*@ComponentScan("com.itmayi")
@EnableAutoConfiguration*/

//相当于@ComponentScan和@EnableAutoConfiguration
//相当于扫当前包com.itmayi
/**
 *
 * 加上@SpringBootApplication
 * 这是第种中启动方式加上扫包
 * 扫包优化：就是启动优化
 * 扫包核心：同级包，递归遍历包下子类，
 * 能影响到启动项目时间
 */
@SpringBootApplication
@EnableAsync//开启异步扫描
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
