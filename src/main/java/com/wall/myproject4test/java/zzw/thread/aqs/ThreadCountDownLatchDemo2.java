package com.wall.myproject4test.java.zzw.thread.aqs;

import java.util.concurrent.CountDownLatch;


/** 
* @Description: 计时器 
* @Author: zhang.zw
* @Date: 2020/11/26 
*/
public class ThreadCountDownLatchDemo2 {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);
//        countDownLatch.await();
        new Thread(()->{
            countDownLatch.countDown();  // 计数减一。倒计时
        }).start();;
        new Thread(()->{
            countDownLatch.countDown();
        }).start();;
        new Thread(()->{
            countDownLatch.countDown();
        }).start();;
        countDownLatch.await();  // 阻塞主线程
        System.out.println("执行完毕！");
    }
}
