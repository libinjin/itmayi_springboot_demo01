package com.itmayi.multiDataSource.test1.mapper;

import com.itmayi.day01.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.cache.annotation.CacheConfig;

@CacheConfig(cacheNames = {"userCache"})
public interface UseTest01Mapper {


    @Select("select * from user where name = #{name}")
    User findByName(@Param("name") String name);

    @Select("SELECT userId ,NAME, AGE FROM user where userId=#{userId}")
    User getUser(@Param("userId") Integer userId);

    @Insert("insert into user(name, age) values(#{name}, #{age})")
    int insert(@Param("name") String name, @Param("age") Integer age);
}
