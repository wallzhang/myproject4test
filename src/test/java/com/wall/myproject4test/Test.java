package com.wall.myproject4test;

import java.util.HashSet;
import java.util.Set;
import java.util.StringJoiner;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Test {
    public static void main(String[] args) {
//        int CAPACITY   = (1 << Integer.SIZE - 3) - 1;
//        System.out.println(CAPACITY);
//        System.out.println(536870913 & CAPACITY);
//        ReentrantReadWriteLock
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.print("foo");
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        System.out.print("ball");
        System.out.println("----------");
    }
}
