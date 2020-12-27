package com.wall.myproject4test.spring.aop4study.staticproxy.test;


import com.wall.myproject4test.spring.aop4study.staticproxy.service.StarManDemo;
import com.wall.myproject4test.spring.aop4study.staticproxy.service.StarManDemoImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
* @Description: JDK代理
* @Author: zhang.zw
* @Date: 2020/12/27 
*/
public class JDKProxyDemo {

    public static void main(String[] args) {
        StarManDemo starManDemo = new StarManDemoImpl();
        StarManDemo proxy = (StarManDemo) Proxy.newProxyInstance(starManDemo.getClass().getClassLoader(),
                starManDemo.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("执行目标方法前。。。");
                        String msg = (String) method.invoke(starManDemo,args[0]);
                        System.out.println("执行目标方法后。。。");
                        return msg;
                    }
                });

        System.out.println(proxy.doSomething("hello wall"));
    }
}
