package com.wall.myproject4test.java.zzw.thread.aqs;


import java.util.concurrent.CyclicBarrier;

/**
* @Description: 可循环屏障
* @Author: zhang.zw
* @Date: 2020/11/26 
*/
public class CyclicBarrierDemo extends Thread{

//    public CyclicBarrierDemo(String path1, CyclicBarrier cyclicBarrier) {
//    }

    @Override
    public void run() {
        System.out.println("最终汇总执行");
    }

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3,new  CyclicBarrierDemo());
        new DataImportThread("path1",cyclicBarrier).start();
        new DataImportThread("path2",cyclicBarrier).start();
        new DataImportThread("path3",cyclicBarrier).start();
        // 希望最终做一次汇总执行处理
    }
}
