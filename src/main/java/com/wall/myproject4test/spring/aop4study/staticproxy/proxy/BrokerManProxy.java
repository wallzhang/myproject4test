package com.wall.myproject4test.spring.aop4study.staticproxy.proxy;

import com.wall.myproject4test.spring.aop4study.staticproxy.service.StarManDemo;


/**
* @Description:
* @Author: zhang.zw
* @Date: 2020/12/27
*/
public class BrokerManProxy {

    private StarManDemo starManDemo;

    public BrokerManProxy(StarManDemo starManDemo) {
        this.starManDemo = starManDemo;
    }

    public String doSomething(String message){
        System.out.println("执行方法前进行...");
        String resp = starManDemo.doSomething(message);
        System.out.println("执行方法后进行...");
        return resp;
    }
}
