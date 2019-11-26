package com.itmayi.day01.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorController {


    @RequestMapping("/getUser")
    public String getUser(int i){

        int d = 1 / i;
        System.out.println("d:"+d);

        return "success";
    }

}
