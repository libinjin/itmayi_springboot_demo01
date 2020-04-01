package com.itmayi.day01.controller.redis;

import com.itmayi.ehcaheRedis.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {


    @Autowired
    private RedisUtil redisService;

    @RequestMapping("/setString")
    public String save(String key, String value) {

        redisService.setString(key, value);

        return "保存完毕";
    }


}
