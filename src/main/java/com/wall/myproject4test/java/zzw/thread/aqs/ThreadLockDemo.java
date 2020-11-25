package com.wall.myproject4test.java.zzw.thread.aqs;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
* @Description: 重入锁测试
* @Author: zhang.zw
* @Date: 2020/11/24
*/
public class ThreadLockDemo {
    /**
     * 重入锁
     */
    static Lock lock = new ReentrantLock();
    public static int count = 0;

    public static void incr(){
        try {
            lock.lock();
            Thread.sleep(1000);
            decr();
            count++;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public static void decr(){
        try {
            lock.lock();
            Thread.sleep(1000);
            count--;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000; i++){
            new Thread(ThreadLockDemo::incr).start();
        }
        Thread.sleep(6000);
        System.out.println("result:"+count);
    }
}
