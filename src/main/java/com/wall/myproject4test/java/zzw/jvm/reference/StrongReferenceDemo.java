package com.wall.myproject4test.java.zzw.jvm.reference;


import com.wall.myproject4test.java.zzw.jvm.Person;

/**
* @Description: 强引用
* @Author: zhang.zw
* @Date: 2020/12/17 
*/
public class StrongReferenceDemo {

    public static void main(String[] args) throws InterruptedException {
        Person person = new Person();
        // 通知系统进行GC
        System.gc();
        // 睡眠一阵子
        Thread.sleep(10000);
        System.out.println("gc 之后person:" + person);
    }
}
