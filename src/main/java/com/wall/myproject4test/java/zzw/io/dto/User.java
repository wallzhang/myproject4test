package com.wall.myproject4test.java.zzw.io.dto;

import java.io.Serializable;

/**
* @Description:
* @Author: zhang.zw
* @Date: 2020/12/2
*/
public class User implements Serializable {

    private static final long serialVersionUID = 5067879031385797458L;
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
