package com.wall.myproject4test.java.zzw.thread.base;

import java.util.concurrent.TimeUnit;

/**
 * 腾讯课堂搜索【咕泡学院】
 * 官网：www.gupaoedu.com
 * 风骚的Mic 老师
 * create-date: 2019/11/20-17:32
 */
public class ThreadStatusDemo {

    public static void main(String[] args) {
        //TIME_WAITING
        new Thread(()->{
            while(true){
                try {
                    TimeUnit.SECONDS.sleep(100);
                    System.out.println("Time_Wating_Demo");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"Time_Wating_Demo").start();
        //WAITING
        new Thread(()->{
            while(true){
                synchronized (ThreadStatusDemo.class){
                    try {
                        ThreadStatusDemo.class.wait(); //等待阻塞
                        System.out.println("Wating");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"Wating").start();
        new Thread(new BlockedDemo(),"Blocked-Demo-01").start();
        new Thread(new BlockedDemo(),"Blocked-Demo-02").start();
    }
    static class BlockedDemo extends  Thread{
        public void run(){
            synchronized (BlockedDemo.class){
                while(true){ //死循环
                    try {
                        TimeUnit.SECONDS.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

