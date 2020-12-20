package com.wall.myproject4test.java.zzw.jvm.reference;


import com.wall.myproject4test.java.zzw.jvm.Person;

import java.lang.ref.SoftReference;

/**
* @Description: 软引用
* @Author: zhang.zw
* @Date: 2020/12/17
*/
public class SoftReferenceDemo {

    public static void main(String[] args) throws InterruptedException {
        Person person = new Person();
        // 设置为软引用类型，
        SoftReference softReference = new SoftReference(person);
        // 释放强引用
        person = null;

        if(softReference!=null){
            person = (Person) softReference.get();
            System.out.println("软引用还未被回收");
            System.out.println(person);
        }else {
            System.out.println("软引用已被回收");
        }

        System.gc();
        person = null;
        Thread.sleep(10000);

        if(softReference!=null){
            person = (Person) softReference.get();
        }else {
            // GC由于内存资源不足，可能系统已回收了a的软引用，
            // 因此需要重新装载。
            person = new Person();
            softReference = new SoftReference(person);
        }
    }
}
