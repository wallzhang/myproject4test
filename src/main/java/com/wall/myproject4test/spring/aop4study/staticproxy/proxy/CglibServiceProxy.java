package com.wall.myproject4test.spring.aop4study.staticproxy.proxy;

import com.wall.myproject4test.spring.aop4study.staticproxy.service.StarManDemoImpl;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibServiceProxy implements MethodInterceptor {

    private StarManDemoImpl starManDemo;

    public CglibServiceProxy(StarManDemoImpl starManDemo) {
        this.starManDemo = starManDemo;
    }

    /**
     * 给外界暴露的创建代理对象的方法
     * @return
     */
    public StarManDemoImpl createProxy(){
        Enhancer enhancer = new Enhancer();
        // 指定父类
        enhancer.setSuperclass(StarManDemoImpl.class);
        // 指定回调方法
        enhancer.setCallback(this);
        // 创建对象代理对象
        return (StarManDemoImpl) enhancer.create();
    }
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("before...");
        String msg = (String) method.invoke(starManDemo, objects[0]);
        System.out.println("after...");
        return msg.toUpperCase();
    }
}
