package com.wall.myproject4test.java.zzw.inf4demo.failfast;

import java.util.List;

public class Thread2 extends Thread{
    private List list;

    public Thread2(List list){
        this.list = list;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("loop execute : " + i);
            try {
                Thread.sleep(5);
                list.add(i);
            }catch (Exception e){

            }
        }
    }
}
