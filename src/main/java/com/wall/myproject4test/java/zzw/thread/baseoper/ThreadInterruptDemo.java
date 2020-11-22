package com.wall.myproject4test.java.zzw.thread.baseoper;


/**
* @Description: interrupt方法
* @Author: zhang.zw
* @Date: 2020/11/23
*/
public class ThreadInterruptDemo {
    private static int i;

    //interrupt(jvm)
    //while
    //线程处于阻塞状态下的情况下(中断才有意义）
    //thread.join
    //wait
    //Thread.sleep

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            //Thread.currentThread().isInterrupted() 默认是false
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        Thread.sleep(5000);
        // 其实就是修改线程维护的一个内部属性interrupt，默认值为false，调用方法后改为true
        t1.interrupt();
    }
}
