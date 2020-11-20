package com.wall.myproject4test.java.zzw.inf4demo.reflect;


import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Reflect4Single {

    public static void main(String[] args) throws Exception {
        SingleDemo singleDemo1 = SingleDemo.getInstance();
        System.out.println(singleDemo1);
        // 获取字节码对象
        Class clazz = Class.forName(SingleDemo.class.getName());
        // 反射破坏单例
//        Constructor constructor = clazz.getDeclaredConstructor();
//        constructor.setAccessible(true);
//        Thread.sleep(1000);
//        System.out.println(constructor.newInstance());
        // 反射获取调用方法
        Method method = clazz.getDeclaredMethod("getInstance");
        SingleDemo singleDemo2 = (SingleDemo) method.invoke(SingleDemo.class);
        System.out.println(singleDemo2);
    }
}
