package com.itmayi.day01.controller;

import com.itmayi.day01.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * SpringBoot异步调用技术
 */
@RestController
@Slf4j
public class MemberController {

    @Resource
    private MemberService memberService;

    //项目启动的时候就读取了配置文件
    @Value("${name}")
    private String name;

    @RequestMapping("/member")
    public Map<String, Object> getMember(){

        Map<String, Object> map = new HashMap<>();
        log.info("name:"+name);
        log.info("1");
        String add = memberService.addMember();
        log.info("4");
        map.put("add", add);
        return map;
    }

    public String getName() {
        return name;
    }
 }
