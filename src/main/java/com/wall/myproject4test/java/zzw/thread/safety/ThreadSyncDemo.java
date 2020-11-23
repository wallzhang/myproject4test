package com.wall.myproject4test.java.zzw.thread.safety;


/**
* @Description: sync检测
* @Author: zhang.zw
* @Date: 2020/11/23
*/
public class ThreadSyncDemo {

    /**
     *  对象锁
     */
    private synchronized void demo(){}

    /**
     * 对象锁
     */
    private void demo1(){
        synchronized (this){
        }
    }

    /**
     * 类级别锁
     */
    private synchronized static void demo2(){}

    /**
     * 类级别锁
     */
    private void demo3(){
        synchronized (ThreadSyncDemo.class){
        }
    }

    public static void main(String[] args) {
        ThreadSyncDemo t1 = new ThreadSyncDemo();
        ThreadSyncDemo t2 = new ThreadSyncDemo();
        new Thread(()->{
            t1.demo1();
//            ThreadSyncDemo.demo2();
        }).start();
        new Thread(()->{
            t2.demo1();
//            ThreadSyncDemo.demo2();
        }).start();
    }
}
