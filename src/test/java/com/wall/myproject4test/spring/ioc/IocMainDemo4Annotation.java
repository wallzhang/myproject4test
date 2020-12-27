package com.wall.myproject4test.spring.ioc;

import com.wall.myproject4test.spring.ioc4study.annotation.Conf4Ioc;
import com.wall.myproject4test.spring.ioc4study.model.UserDemo;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class IocMainDemo4Annotation {

    @Test
    public void fun1(){
        ApplicationContext app = new AnnotationConfigApplicationContext(Conf4Ioc.class);
        System.out.println(app.getBean("zs"));
        System.out.println(app.getBean("ls"));
        System.out.println(app.getBean(UserDemo.class));

    }
}
