package com.wall.myproject4test.spring.ioc4study.annotation;

import com.wall.myproject4test.spring.ioc4study.model.UserDemo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
* @Description: 基于注解实现bean配置
* @Author: zhang.zw
* @Date: 2020/12/24
*/
@Configuration
public class Conf4Ioc {

    @Bean(name = {"zs","ls"})
    public UserDemo getUserDemo(){
        UserDemo userDemo = new UserDemo();
        return userDemo;
    }
}
