package com.wall.myproject4test.java.zzw.inf4demo.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ReflectSingle4HomeWork {

    public static void main(String[] args) throws Exception {
        // 1.已知字节码对象(class),如何找到指定的Method
        // 需要注意:指定方法名，如果带有参数也需要指定参数名
        Class clazz = Class.forName(SingleDemo.class.getName());
        Method method = clazz.getDeclaredMethod("getInstance");
        SingleDemo singleDemo1 = (SingleDemo) method.invoke(SingleDemo.class);
        System.out.println(singleDemo1);
        System.out.println("分割线===================");
        // 2.已知实例对象,通过反射机制进行对象的创建
        // 先获取构造器,但是需要小心对象的构造方法是否是私有的，私有的话需要进行设置setAceessable（true），取消修饰符判断
        Class clazz2 = Class.forName(clazz.getName());
        Constructor constructor = clazz2.getDeclaredConstructor();
        constructor.setAccessible(true);
        Thread.sleep(1000);
        System.out.println(constructor.newInstance());

    }

}
