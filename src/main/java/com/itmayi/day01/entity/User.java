package com.itmayi.day01.entity;

import lombok.Data;

import java.io.Serializable;

@Data//相当于@Getter和@Setter
public class User implements Serializable {

    private Integer userId;

    private String name;

    private Integer age;


    public static void main(String[] args) {
        User user = new User();
        user.hashCode();
        user.equals(user);
    }
}
