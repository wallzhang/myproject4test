package com.wall.myproject4test.java.zzw.thread.base;

import java.util.concurrent.*;

public class BaseThread4Callable implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("当前线程："+Thread.currentThread().getName());
        Thread.sleep(10000);
        return "Hello Wall";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService= Executors.newFixedThreadPool(1);
        Future<String> future=executorService.submit(new BaseThread4Callable());
        //future.get 是一个阻塞方法
        System.out.println(Thread.currentThread().getName()+"-"+future.get());
    }
}
