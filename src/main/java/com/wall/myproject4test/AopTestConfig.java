package com.wall.myproject4test;

import com.wall.myproject4test.spring.aop4study.aspectj.WallService;
import com.wall.myproject4test.spring.aop4study.aspectj.impl.WallServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
//@ComponentScan("com.wall.myproject4test.spring.aop4study.*")
@ComponentScan
public class AopTestConfig {

    public static void main(String[] args) {
        ApplicationContext app = new AnnotationConfigApplicationContext(AopTestConfig.class);
        WallServiceImpl wallService = app.getBean(WallServiceImpl.class);
        wallService.fun1();
    }
}
