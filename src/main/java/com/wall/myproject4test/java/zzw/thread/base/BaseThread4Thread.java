package com.wall.myproject4test.java.zzw.thread.base;


/** 
* @Description: Thread 
* @Author: zhang.zw
* @Date: 2020/11/20 
*/
public class BaseThread4Thread extends Thread{

    @Override
    public void run() {
        System.out.println(BaseThread4Thread.class.getSimpleName() + " run!!!");
        System.out.println("当前线程："+Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        new BaseThread4Thread().start();
    }
}
