package com.wall.myproject4test.java.zzw.thread.safety;

import java.time.LocalDateTime;


/** 
* @Description: volatile关键字(1.修饰的属性保证内存可见性，2.添加内存屏障，禁止指令重排序)
* @Author: zhang.zw
* @Date: 2020/11/23 
*/
public class ThreadVisableDemo {
    private volatile static boolean flag = false;
//    private static boolean flag = false;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("start->" + LocalDateTime.now());
        Thread t1 = new Thread(()->{
            int i = 0;
            while (!flag){
                try {
                    Thread.sleep(10);
                    i++;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("result:"+i);
        },"t1");
        t1.start();
        System.out.println("t1 start");
        Thread.sleep(1000);
        flag = true;
        System.out.println("end->" + LocalDateTime.now());
    }
}
