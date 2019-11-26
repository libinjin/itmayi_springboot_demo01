package com.itmayi.multiDataSource.controller;

import com.itmayi.multiDataSource.test1.service.UserTest01Service;
import com.itmayi.multiDataSource.test2.service.UserTest02Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class MultiDataSourceController {

    @Resource
    private UserTest01Service userTest01Service;

    @Resource
    private UserTest02Service userTest02Service;


    @RequestMapping("/addTest01")
    public Integer insertUserTest001(String name, Integer age){
        return userTest01Service.addUser(name, age);
    }

    @RequestMapping("/addTest02")
    public Integer insertUserTest002(String name, Integer age){
        return userTest02Service.addUser(name, age);
    }
}
