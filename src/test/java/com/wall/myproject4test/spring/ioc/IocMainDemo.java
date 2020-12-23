package com.wall.myproject4test.spring.ioc;

import com.wall.myproject4test.spring.ioc4study.model.UserDemo;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IocMainDemo {

    /**
     * ioc:
     * 1.非IOC
     */
    @Test
    public void fun1(){
        UserDemo userDemo = new UserDemo();
        userDemo.say();
    }

    /**
     * ioc:
     * 2.IOC方式获取bean通过ID
     *
     */
    @Test
    public void fun2(){
        // 容器初始化，调用无参构造函数
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 基于类名直接获取
        // UserDemo userDemo = app.getBean(UserDemo.class);
        // 基于配置文件内配置的id获取
        UserDemo userDemo = (UserDemo) app.getBean("userDemo");
        userDemo.say();
    }

    /**
     * ioc:
     * 2.IOC方式获取bean,通过name
     */
    @Test
    public void fun3(){
        // 容器初始化，调用无参构造函数
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 基于类名直接获取
        // UserDemo userDemo = app.getBean(UserDemo.class);
        // 基于配置文件内配置的name获取
        UserDemo userDemo = (UserDemo) app.getBean("userDemo2");
        userDemo.say();
    }
}
