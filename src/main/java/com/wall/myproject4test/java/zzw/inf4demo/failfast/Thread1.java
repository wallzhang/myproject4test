package com.wall.myproject4test.java.zzw.inf4demo.failfast;

import java.util.Iterator;
import java.util.List;

public class Thread1 extends Thread{

    List list ;
    public Thread1(List list) {
        this.list = list;
    }

    @Override
    public void run() {
        while (true){
            // 循环list获取值
            for (Iterator iterator = list.iterator();iterator.hasNext();){
                iterator.next();
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
