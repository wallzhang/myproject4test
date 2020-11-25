package com.wall.myproject4test.java.zzw.thread.aqs;


import java.util.concurrent.Semaphore;

/**
* @Description: 计时器
* @Author: zhang.zw
* @Date: 2020/11/26
*/
public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < 10; i++){
            new Thread(new SemaphoreCar(i,semaphore)).start();
        }
    }

    static class SemaphoreCar implements Runnable{
        int num;
        Semaphore semaphore;

        public SemaphoreCar(int num, Semaphore semaphore) {
            this.num = num;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire(); // 获取令牌
                System.out.println("第" + num + "辆车进车库了");
                semaphore.release();
                System.out.println("第" + num + "辆车走了");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}
