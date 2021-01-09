package com.wall.myproject4test.springboot.demo4autowired;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
* @Description: 测试类
* @Author: zhang.zw
* @Date: 2021/1/9
*/
public class JavaConfigMain {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(JavaConfig.class);
        System.out.println(ac.getBean(User4springboot.class));
    }

}
