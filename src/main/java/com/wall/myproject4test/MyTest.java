package com.wall.myproject4test;

import java.util.concurrent.TimeUnit;

public class MyTest {

    public static void main(String[] args) {
        String lockA = "lockA";
        String lockB = "lockB";
        new Thread(new HoldLockThread1(lockA, lockB), "ThreadA").start();
        new Thread(new HoldLockThread1(lockB, lockA), "ThreadB").start();
    }
}

class HoldLockThread1 implements Runnable {
    private String lockA;
    private String lockB;

    public HoldLockThread1(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA) {
            System.out.println(Thread.currentThread().getName() + "\t自己持有：" + lockA + "\t尝试获取：" + lockB);
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println(Thread.currentThread().getName() + "\t自己持有：" + lockA + "\t尝试获取：" + lockB);
            } catch (Exception e) {
                e.printStackTrace();
            }
            synchronized (lockB) {
                System.out.println(Thread.currentThread().getName() + "\t自己持有：" + lockB + "\t尝试获取：" + lockA);
            }
        }
    }
}