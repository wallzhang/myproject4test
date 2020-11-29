package com.wall.myproject4test.java.zzw.thread.extend;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
* @Description: 死锁发生条件
 * 1. 互斥，共享资源 X 和 Y 只能被一个线程占用；
 * 2. 占有且等待，线程 T1 已经取得共享资源 X，在等待共享资源 Y 的时候，
 * 不释放共享资源 X；
 * 3. 不可抢占，其他线程不能强行抢占线程 T1 占有的资源；
 * 4. 循环等待，线程 T1 等待线程 T2 占有的资源，线程 T2 等待线程 T1 占
 * 有的资源，就是循环等待。
 *
 * 模拟并发发生情况，两个账户同时进行存值取值操作，首先这边需要模拟账户
* @Author: zhang.zw
* @Date: 2020/11/29 
*/
public class ThreadDeadLock {
    public static void main(String[] args) {
//       new  ThreadDeadLock().demo1();
//       new  ThreadDeadLock().dealDemo1();
       new  ThreadDeadLock().dealDemo2();
    }

    /**
     * 模拟死锁条件2.占有且等待
     */
    private void demo1(){
        BaseUser user1 = new BaseUser("张三",100);
        BaseUser user2 = new BaseUser("李四",100);
        // 模拟张三一直往李四账户存1块钱
        new Thread(()->{
            while (true){
                synchronized (user1){
                    synchronized (user2){
                        if(user1.getAccount() >=1){
                            user1.delAccount(1);
                            user2.addAccount(1);
                            System.out.println("张三往李四账户存1块钱");
                        }else {
                            System.out.println("张三没钱了");
                            break;
                        }
                    }
                }

            }
        },"张三打钱").start();
        // 模拟李四一直往张三账户存2块钱
        new Thread(()->{
            while (true){
                synchronized (user2) {
                    synchronized (user1) {
                        if (user2.getAccount() >=2) {
                            user1.addAccount(2);
                            user2.delAccount(2);
                            System.out.println("李四往张三账户存2块钱");
                        }else {
                            System.out.println("李四没钱了");
                            break;
                        }
                    }
                }
            }
        },"李四打钱").start();
    }

    
    /** 
    * @Description:新建分配类，类内提供同步锁方法,统一对资源进行管理
    * @Author: zhang.zw
    * @Date: 2020/11/29 
    */
    private void dealDemo1(){
        BaseUser user1 = new BaseUser("张三",100);
        BaseUser user2 = new BaseUser("李四",100);
        Allocator allocator = new Allocator();
        // 模拟张三一直往李四账户存1块钱
        new Thread(()->{
            while (true){
                if(allocator.apply(user1,user2)){
                    try {
                        synchronized (user1){
                            synchronized (user2){
                                if(user1.getAccount() >=1){
                                    user1.delAccount(1);
                                    user2.addAccount(1);
                                    System.out.println("张三往李四账户存1块钱");
                                }else {
                                    System.out.println("张三没钱了");
                                    break;
                                }
                            }
                        }
                    }finally {
                        allocator.free(user1,user2);
                    }
                }
            }
        },"张三打钱").start();
        // 模拟李四一直往张三账户存2块钱
        new Thread(()->{
            while (true){
                if(allocator.apply(user2,user1)) {
                    try {
                        synchronized (user2) {
                            synchronized (user1) {
                                if (user2.getAccount() >=2) {
                                    user1.addAccount(2);
                                    user2.delAccount(2);
                                    System.out.println("李四往张三账户存2块钱");
                                }else {
                                    System.out.println("李四没钱了");
                                    break;
                                }
                            }
                        }
                    }finally {
                        allocator.free(user2,user1);
                    }
                }
            }
        },"李四打钱").start();
    }

    /**
     * @Description:利用重入锁的tryLock方法
     * @Author: zhang.zw
     * @Date: 2020/11/29
     */
    private void dealDemo2(){
        BaseUser user1 = new BaseUser("张三",20);
        BaseUser user2 = new BaseUser("李四",20);
        Lock lock1 = new ReentrantLock();
        Lock lock2 = new ReentrantLock();

        Lock lock3 = new ReentrantLock();
        Lock lock4 = new ReentrantLock();
//        Allocator allocator = new Allocator();
        // 模拟张三一直往李四账户存1块钱
        new Thread(()->{
            while (true){
                if(lock1.tryLock()){
                    if(lock2.tryLock()){
                        if(user1.getAccount() >=1){
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            user1.delAccount(1);
                            user2.addAccount(1);
                            System.out.println("张三往李四账户存1块钱");
                        }else {
                            System.out.println("张三没钱了");
                            break;
                        }
                    }
                }
            }
        },"张三打钱").start();
        // 模拟李四一直往张三账户存2块钱
        new Thread(()->{
            while (true){
                if(lock3.tryLock()){
                    if(lock4.tryLock()){
                        if (user2.getAccount() >=2) {
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            user1.addAccount(2);
                            user2.delAccount(2);
                            System.out.println("李四往张三账户存2块钱");
                        }else {
                            System.out.println("李四没钱了");
                            break;
                        }
                    }
                }
            }
        },"李四打钱").start();
    }
}
