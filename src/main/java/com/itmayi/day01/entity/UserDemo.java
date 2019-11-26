package com.itmayi.day01.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * 使用lombok虚拟生成get和set方法
 * 利用ASM动态修改字节码文件
 *
 */
@Slf4j//等同于Log
@Getter
@Setter
public class UserDemo {


    private String name;

    private Integer age;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    //生成get和set方法

/*
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }*/


    //lombok是在编译的时候修改字节码文件（底层使用字节码技术）
    //线上环境使用的是编译好的文件
    public static void main(String[] args) {
        UserDemo user = new UserDemo();
        user.setAge(10);
        user.setName("libin");
       log.info((user.toString()));
    }

}
