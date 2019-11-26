package com.itmayi.multiDataSource.test2.service;

import com.itmayi.multiDataSource.test2.mapper.UseTest02Mapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class UserTest02Service {

    @Resource
    private UseTest02Mapper useTest02Mapper;

    @Transactional(transactionManager = "test2TransactionManager")
    public int addUser(String name, Integer age){
        int add = useTest02Mapper.insert(name, age);
        return add;
    }
}
