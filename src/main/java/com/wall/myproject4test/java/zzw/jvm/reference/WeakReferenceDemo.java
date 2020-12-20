package com.wall.myproject4test.java.zzw.jvm.reference;

import com.wall.myproject4test.java.zzw.jvm.Person;

import java.lang.ref.WeakReference;

/**
* @Description:  弱引用
* @Author: zhang.zw
* @Date: 2020/12/17
*/
public class WeakReferenceDemo {
    public static void main(String[] args) throws InterruptedException {

        Person person = new Person();
        WeakReference wp = new WeakReference(person);

        System.out.println("第一次GC前:" +person);
        System.out.println("第一次GC前:" +wp.get());
        // 进行第一从GC
        System.gc();
        // 等待10S
        Thread.sleep(10000);
        System.out.println("第一次GC后:" +person);
        System.out.println("第一次GC后:" +wp.get());
        // 将强应用擦除
        person = null;
        System.gc();
        Thread.sleep(10000);
        System.out.println("第二次GC后:" +person);
        System.out.println("第二次GC后:" +wp.get());
    }
}
