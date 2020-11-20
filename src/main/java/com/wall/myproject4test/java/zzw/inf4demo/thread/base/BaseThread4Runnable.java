package com.wall.myproject4test.java.zzw.inf4demo.thread.base;

public class BaseThread4Runnable implements Runnable{
    @Override
    public void run() {
        System.out.println(BaseThread4Runnable.class.getSimpleName() + "  run !!!!");
        System.out.println("当前线程："+Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new BaseThread4Runnable());
        thread.start();
    }
}
