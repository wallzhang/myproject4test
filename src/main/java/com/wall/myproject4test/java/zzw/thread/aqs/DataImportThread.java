package com.wall.myproject4test.java.zzw.thread.aqs;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * 腾讯课堂搜索【咕泡学院】
 * 官网：www.gupaoedu.com
 * 风骚的Mic 老师
 * create-date: 2019/11/28-16:03
 */
public class DataImportThread extends Thread{

    private String path;

    private CyclicBarrier cyclicBarrier;

    public DataImportThread(String path, CyclicBarrier cyclicBarrier) {
        this.path = path;
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        System.out.println("开始导入:"+path+" 位置的数据");
        try {
            cyclicBarrier.await(); //阻塞
            //TODO
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    /**
     * Hello world!
     *
     */
    public static class App implements Runnable
    {
        static CountDownLatch countDownLatch=new CountDownLatch(1);

        public static void main( String[] args ){
            for (int i = 0; i < 1000; i++) {
                new Thread(new App()).start();
            }
            countDownLatch.countDown();
        }
        @Override
        public void run() {
            try {
                countDownLatch.await();//阻塞 1000个线程调用了await方法
                //TODO
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //连接操作.
    }
}
