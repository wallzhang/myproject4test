package com.wall.myproject4test.spring.ioc4study.factory;

import com.wall.myproject4test.spring.ioc4study.model.UserDemo;


/** 
* @Description: 动态工厂 
* @Author: zhang.zw
* @Date: 2020/12/24 
*/
public class DynamicFactoryDemo {
    public UserDemo getInstance(){
        return new UserDemo();
    }
}
