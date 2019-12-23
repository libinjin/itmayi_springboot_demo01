package com.itmayi.day01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class FTLIndexController {


    @RequestMapping("/ftlIndex")
    public String ftlIndex(Map<String, Object> map) {
        map.put("name", "libin");
        map.put("age", 21);
        map.put("sex", "0");
        return "ftlIndex";
    }

}
