package com.wall.myproject4test.springboot.demo4autowired;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
* @Description: 测试类
* @Author: zhang.zw
* @Date: 2021/1/9 
*/
//@WallImportConfig
@WallImportConfig2
public class ImportMain {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(ImportMain.class);
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String name: beanDefinitionNames) {
            System.out.println(name);
        }
        System.out.println("-------------------------------");
        System.out.println(ac.getBean(User4springboot.class));

    }
}
