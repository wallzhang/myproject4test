package com.wall.myproject4test.spring.aop4study.staticproxy.test;

import com.wall.myproject4test.spring.aop4study.staticproxy.proxy.CglibServiceProxy;
import com.wall.myproject4test.spring.aop4study.staticproxy.service.StarManDemo;
import com.wall.myproject4test.spring.aop4study.staticproxy.service.StarManDemoImpl;

public class CglibProxyDemo {
    public static void main(String[] args) {
        StarManDemoImpl starManDemo = new StarManDemoImpl();
        StarManDemoImpl starManDemo1 = new CglibServiceProxy(starManDemo).createProxy();
        System.out.println(starManDemo1.doSomething("hell wall"));
    }
}
