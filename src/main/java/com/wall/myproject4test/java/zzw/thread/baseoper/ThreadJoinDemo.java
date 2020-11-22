package com.wall.myproject4test.java.zzw.thread.baseoper;


/**
* @Description: 知识点，join方法。知识点
 * 1.join阻塞的是主线程ThreadJoinDemo不是子线程
 * 2.执行join后，thread1的执行结果对thread2可见
 * 3.底层源码调用了native方法wait，之后调用线程notify方法唤醒线程
* @Author: zhang.zw
* @Date: 2020/11/22
*/
public class ThreadJoinDemo {

    private static int i = 0;
    private static int j = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(()->{
            i = 1;
            j = 2;
        },"thread1");
        Thread thread2 = new Thread(()->{
            i = j + 2;
        },"thread2");

        // 开始执行
        thread1.start();
        // 保证t1的执行结果对t2可见 （阻塞）
        thread1.join();
        thread2.start();
        // 保证变量能正确完成赋值
        Thread.sleep(1000);
        System.out.println("i:" + i);
    }


}
