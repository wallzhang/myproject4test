package com.wall.myproject4test.java.zzw.inf4demo.reflect;

public class SingleDemo {


    private static SingleDemo singleDemo;
    private SingleDemo() throws Exception {
//        if(SingleDemo.singleDemo != null){
//            throw new Exception("单例已存在，不允许反射获取单例") ;
//        }
    };

    public static SingleDemo getInstance() throws Exception {
        if(singleDemo == null){
            singleDemo = new SingleDemo();
        }
        return singleDemo;
    }
}
