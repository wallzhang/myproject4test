package com.wall.myproject4test.java.zzw.thread.baseoper;

import java.util.Queue;


/** 
* @Description: 消费者
* @Author: zhang.zw
* @Date: 2020/11/22 
*/
public class ThreadConsumerDemo implements Runnable{

    private Queue<String> bags;
    private int size;

    public  ThreadConsumerDemo(Queue<String> queue, int size) {
        this.bags = queue;
        this.size = size;
    }

    @Override
    public void run() {
        while (true){
            synchronized (bags){
                while (bags.isEmpty()){
                    // 包裹为空，提示生产者生产
                    System.out.println("bags为空");
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
                String bagName = bags.remove();
                System.out.println("消费者消费:"+bagName);
                // 唤醒处于阻塞状态下的消费者
                bags.notifyAll();

            }
        }
    }
}
