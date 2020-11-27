package com.wall.myproject4test.java.zzw.thread.pool;

import com.wall.myproject4test.java.zzw.thread.baseoper.ThreadConsumerDemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/** 
* @Description: 线程池
* @Author: zhang.zw
* @Date: 2020/11/26 
*/
public class ThreadPoolDemo implements Runnable{

    public static void main(String[] args) {
        // 线程数量固定的线程池,当创建的线程大于定义的值的时候，加入到等待队列
        ExecutorService executor = Executors.newFixedThreadPool(3);
        // 单个线程的线程池
        ExecutorService executor2 = Executors.newSingleThreadExecutor();
        // 可动态伸缩的线程池
        ExecutorService executor3 = Executors.newCachedThreadPool();
        // 可定时的线程池
        ExecutorService executor4 = Executors.newScheduledThreadPool(3);
        for (int i = 0; i < 1000; i++){
            executor.execute(new ThreadPoolDemo());
        }
    }
    @Override
    public void run() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
