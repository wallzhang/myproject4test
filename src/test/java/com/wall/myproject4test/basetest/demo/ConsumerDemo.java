package com.wall.myproject4test.basetest.demo;

import java.util.Queue;

public class ConsumerDemo implements Runnable{
    private Queue<String> bags;
    private int size;

    public ConsumerDemo(Queue<String> bags, int size) {
        this.bags = bags;
        this.size = size;
    }

    @Override
    public void run() {
        while (true){
            synchronized (bags){
                if(bags.size()==0){
                    System.out.println("包裹为空阻塞");
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
                // 唤醒生产者
                bags.notifyAll();
            }
        }
    }
}
