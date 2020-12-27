package com.wall.myproject4test.spring.aop4study.staticproxy.service;


/**
* @Description: 执行
* @Author: zhang.zw
* @Date: 2020/12/27
*/
public class StarManDemo2Impl {

    public String doSomething(String message) {
        System.out.println("Cglib做了点事情:" + message);
        return "hello";
    }
}
