package com.itmayi.day01.entity;

import lombok.Data;

@Data//相当于@Getter和@Setter
public class User {

    private String name;

    private Integer age;


    public static void main(String[] args) {
        User user = new User();
        user.hashCode();
        user.equals(user);

    }
}
