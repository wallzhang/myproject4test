package com.wall.myproject4test.spring.aop4study.staticproxy.test;

import com.wall.myproject4test.spring.aop4study.staticproxy.proxy.BrokerManProxy;
import com.wall.myproject4test.spring.aop4study.staticproxy.service.StarManDemoImpl;

public class TestDemo1 {

    public static void main(String[] args) {
        StarManDemoImpl starManDemo = new StarManDemoImpl();
        BrokerManProxy brokerManProxy = new BrokerManProxy(starManDemo);
        String res =  brokerManProxy.doSomething("ni hao");
        System.out.println(res);
    }
}
