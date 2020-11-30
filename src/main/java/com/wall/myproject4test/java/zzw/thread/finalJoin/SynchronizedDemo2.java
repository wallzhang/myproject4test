package com.wall.myproject4test.java.zzw.thread.finalJoin;

import java.util.concurrent.atomic.AtomicInteger;

public class SynchronizedDemo2 {
    static int count = 0;
    static AtomicInteger atomicInteger = new AtomicInteger();
    public static void incr(){
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count++;
        atomicInteger.getAndAdd(1);
    }

    public static void main(String[] args) throws InterruptedException {
        for(int i = 0; i < 1000; i++){
            new Thread(()->SynchronizedDemo2.incr()).start();
        }
        Thread.sleep(5000);
        System.out.println(count);
        System.out.println(atomicInteger.get());
    }
}
