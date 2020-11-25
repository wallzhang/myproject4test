package com.wall.myproject4test.basetest.demo;

import java.util.LinkedList;
import java.util.Queue;

public class TestCPDemo {
    public static void main(String[] args) {
        Queue<String> bags = new LinkedList<>();
        int size = 10;
        Thread t1 = new Thread(new ProducerDemo(bags,size),"Producer");
        Thread t2 = new Thread(new ConsumerDemo(bags,size),"Consumer");
        t1.start();
        t2.start();
    }
}
