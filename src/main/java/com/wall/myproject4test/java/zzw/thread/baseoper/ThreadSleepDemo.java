package com.wall.myproject4test.java.zzw.thread.baseoper;


/**
* @Description: sleep方法,知识点
 * 1.线程的调度算法(不同的系统里，cpu竞争有很多种策略)
 * a.linux 使用时间片算法，每次线程执行分配一个时间片，如果到了时间线程还没有结束，则将线程阻塞，把cpu分配给其他线程
 * b.window 使用抢占式算法，当前线程获取CPU之后，只有主动放弃，其他线程才能获得CPU
* @Author: zhang.zw
* @Date: 2020/11/22
*/
public class ThreadSleepDemo extends Thread{

    public static void main(String[] args) {
        System.out.println("startTime:" +  System.currentTimeMillis());
        new Thread(()->{
            try {
                Thread.sleep(3000);
                System.out.println("endTime:" +  System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
