package com.wall.myproject4test.spring.aop4study.aspectj.impl;

import com.wall.myproject4test.spring.aop4study.aspectj.WallService;
import org.springframework.stereotype.Component;

@Component
public class WallServiceImpl implements WallService {
    @Override
    public void fun1() {
        System.out.println("fun1....");
    }

    @Override
    public String fun2() {
        System.out.println("fun2...");
        return "fun2";
    }

    @Override
    public String fun3(String name) {
        System.out.println("fun3...");
        return "fun3-" + name;
    }
}
