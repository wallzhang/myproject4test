package com.wall.myproject4test.spring.aop4study.aspectj;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspectj {

    @Before("execution(* com.wall.myproject4test.spring.aop4study.aspectj.*.*(..))")
    public void aspectj(){
        System.out.println("before....");
    }
}
