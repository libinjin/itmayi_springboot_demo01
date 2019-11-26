package com.itmayi.multiDataSource.test1.service;

import com.itmayi.multiDataSource.test1.mapper.UseTest01Mapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class UserTest01Service {

    @Resource
    private UseTest01Mapper useTest01Mapper;

    @Transactional(transactionManager = "test1TransactionManager")
    public int addUser(String name, Integer age){
        int add = useTest01Mapper.insert(name, age);
        return add;
    }


}
