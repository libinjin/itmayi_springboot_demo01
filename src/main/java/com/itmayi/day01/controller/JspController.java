package com.itmayi.day01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 这是jsp整合SpringBoot
 */
@Controller
public class JspController {

    @RequestMapping("/jspIndex")
    public String jspIndex(){
        System.out.println("调用jsp页面");
        return "index";
    }
}
