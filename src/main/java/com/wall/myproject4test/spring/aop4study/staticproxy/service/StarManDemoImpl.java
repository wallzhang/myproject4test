package com.wall.myproject4test.spring.aop4study.staticproxy.service;


/**
* @Description: 执行
* @Author: zhang.zw
* @Date: 2020/12/27
*/
public class StarManDemoImpl implements StarManDemo{
    @Override
    public String doSomething(String message) {
        System.out.println("做了点事情:" + message);
        return "hello";
    }
}
