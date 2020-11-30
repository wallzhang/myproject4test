package com.wall.myproject4test.java.zzw.thread.finalJoin;

import java.time.LocalDateTime;

public class SynchronizedDemo implements Runnable {
    int x = 100;
    public synchronized void m1() {
        x= 1000;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("x=" + x +"     "+ LocalDateTime.now());
    }

    public synchronized void m2() {
        x= 2000;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        x= 2000;
    }

    public static void main(String[] args) {
        System.out.println("start:    " +  LocalDateTime.now());
        SynchronizedDemo sd = new SynchronizedDemo();
        new Thread(()->sd.m1( ) ).start();
        new Thread(()->sd.m2( ) ).start();
        System.out.println("执行顺序1");
//        sd.m2();
        System.out.println("执行顺序2");
        System.out.println("Main x=" + sd.x +"     |"+ LocalDateTime.now());
    }


    @Override
    public void run() {
        System.out.println("run");
        m1();
    }
}
