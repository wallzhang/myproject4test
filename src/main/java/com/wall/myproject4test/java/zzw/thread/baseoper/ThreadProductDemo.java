package com.wall.myproject4test.java.zzw.thread.baseoper;

import java.util.Queue;


/**
* @Description: 生产者
* @Author: zhang.zw
* @Date: 2020/11/22
*/
public class ThreadProductDemo implements Runnable{

    private Queue<String> bags;
    private int size;

    public  ThreadProductDemo(Queue<String> queue, int size) {
        this.bags = queue;
        this.size = size;
    }

    @Override
    public void run() {
        int i = 0;
        while (true){
            i++;
            synchronized (bags){
                while (bags.size() == size){
                    System.out.println("生产者包裹已经满了！！");
                    // 阻塞队列
                    try {
                        bags.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("生产者生产:bags"+i);
                bags.add("bags"+i);
                // 唤醒处于阻塞状态下的消费者
                bags.notifyAll();
            }
        }
    }
}
