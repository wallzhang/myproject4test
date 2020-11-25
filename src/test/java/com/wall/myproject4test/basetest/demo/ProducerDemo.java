package com.wall.myproject4test.basetest.demo;

import java.util.Queue;

/**
* @Description: 生产者
* @Author: zhang.zw
* @Date: 2020/11/24
*/
public class ProducerDemo implements Runnable{
    private Queue<String> bags;
    private int size;

    public ProducerDemo(Queue<String> bags, Integer size) {
        this.bags = bags;
        this.size = size;
    }


    @Override
    public void run() {
        int i = 0;
        while (true){
            synchronized (bags){
                if(bags.size() == size){
                    System.out.println("包裹满了！！！");
                    // todo
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
                i++;
                System.out.println("生产者生产:bags"+i);
                bags.add("bags"+i);
                // 唤醒处于阻塞状态下的消费者
                bags.notifyAll();
            }

        }
    }
}
