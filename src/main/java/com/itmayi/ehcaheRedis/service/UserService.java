package com.itmayi.ehcaheRedis.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.itmayi.day01.entity.User;
import com.itmayi.ehcaheRedis.util.EhCacheUtil;
import com.itmayi.ehcaheRedis.util.RedisUtil;
import com.itmayi.multiDataSource.test1.mapper.UseTest01Mapper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

@Service
public class UserService {

    private static final String CACHENAME_USERCACHE = "userCache";

    @Resource
    private EhCacheUtil ehCacheUtil;

    @Resource
    private RedisUtil redisUtil;

    @Resource
    private UseTest01Mapper useTest01Mapper;

    /**
     * 1、获取时，先从Ehcache中获取
     * 2、没有时，再从redis中获取
     * 3、再没有，从mysql中获取
     */
    public User getUserById(Integer userId){

        //key:类名称 - 方法名称 - id
        String key = this.getClass().getName() + "-" + Thread.currentThread().getStackTrace()[1].getMethodName()
                + "-id:" + userId;

        User user = (User) ehCacheUtil.get(CACHENAME_USERCACHE, key);

        if (user != null) {
            System.out.println("使用key:" + key + ",查询一级缓存 ehCache 获取到ehUser:" + JSONObject.toJSONString(user));
            return user;
        }
        String redisUserJson = redisUtil.getString(key);

        if(!StringUtils.isEmpty(redisUserJson)){

            User user1 = JSON.parseObject(redisUserJson, User.class);
            //同步一级缓存
            ehCacheUtil.put(CACHENAME_USERCACHE, key, user1);

            System.out.println("使用key:" + key + ",查询二级缓存 redis 获取到ehUser:" + JSONObject.toJSONString(user));

            return user1;
        }

        User user1 = useTest01Mapper.getUser(userId);

        if (user1 == null) {
            return null;
        }
        //更新一二级缓存
        String userJson = JSONObject.toJSONString(user1);
        redisUtil.setString(key, userJson);

        ehCacheUtil.put(CACHENAME_USERCACHE, key, user1);
        System.out.println("使用key:" + key + "，一级缓存和二级都没有数据,直接查询db" + userJson);

        return user1;
    }


    /**
     * 解决缓存穿透
     * 发送多个该id没有结果的请求
     * 查询系统崩溃
     * @return
     */
    public String getUser2(Integer userId){

        //key:类名称 - 方法名称 - id
        String key = this.getClass().getName() + "-" + Thread.currentThread().getStackTrace()[1].getMethodName()
                + "-id:" + userId;

        //限制id规则，如果id不在该规则中，就不让查询了

        String redisUserJson = redisUtil.getString(key);

        if(!StringUtils.isEmpty(redisUserJson)){
            return redisUserJson;
        }

        User user = useTest01Mapper.getUser(userId);
        //防止缓存穿透，再第一次请求为null后，就存放到redis中
        String resultUser = user == null?"${null}":JSONObject.toJSONString(user);
        redisUtil.setString(key, resultUser);

        System.out.println("使用key:" + key + "，一级缓存和二级都没有数据,直接查询db" + resultUser);

        return resultUser;
    }




}
