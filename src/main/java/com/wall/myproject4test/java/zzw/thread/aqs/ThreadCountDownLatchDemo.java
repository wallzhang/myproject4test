package com.wall.myproject4test.java.zzw.thread.aqs;

import java.util.concurrent.CountDownLatch;


/** 
* @Description: 可以模拟1000个线程并发的场景
* @Author: zhang.zw
* @Date: 2020/11/26 
*/
public class ThreadCountDownLatchDemo implements Runnable{

    static CountDownLatch countDownLatch = new CountDownLatch(1);

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++){
            new Thread(new  ThreadCountDownLatchDemo()).start();
        }
        countDownLatch.countDown();
    }

    @Override
    public void run() {
        try {
            countDownLatch.await();
            // 具体操作逻辑
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
