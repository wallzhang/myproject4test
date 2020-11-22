package com.wall.myproject4test.java.zzw.thread.baseoper;


import java.util.LinkedList;
import java.util.Queue;


/**
* @Description: 测试生产者消费者
 * 1.wait和notify实现了什么（生产者消费者）
 * 一个线程改变了一个对象的值，另一个线程能够感知到变化然后做相应的处理
 * 2.为什么wait和notify需要配合synchronized关键字使用呢
 *   1)wait和notify是一种互斥关系，而synchronized是实现互斥的一种很好的实现方法。
 *   2)wait和notify用于多线程之间的通信,需要基于synchronized来实现通信
* @Author: zhang.zw
* @Date: 2020/11/22
*/
public class WaitNotifyDemo {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        int size = 10;
        Thread t1 = new Thread(new  ThreadProductDemo(queue,size));
        Thread t2 = new Thread(new ThreadConsumerDemo(queue,size));
        t1.start();
        t2.start();
    }
}
