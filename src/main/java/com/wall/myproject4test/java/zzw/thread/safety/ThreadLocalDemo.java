package com.wall.myproject4test.java.zzw.thread.safety;


/** 
* @Description: ThreadLocal 
* @Author: zhang.zw
* @Date: 2020/11/24 
*/
public class ThreadLocalDemo {
    public static final ThreadLocal<Integer> local=new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue(){
            return 0; //初始值
        }
    };
    public static final ThreadLocal<Integer> local1=new ThreadLocal<Integer>();
    public static void main(String[] args) {
        Thread[] threads=new Thread[5];
        //希望每个线程都拿到的是0
        for (int i = 0; i < 5; i++) {
            threads[i]=new Thread(()->{
//                num+=5;
                int num=local.get(); //拿到初始值
                local1.get();
                num+=5;
                local.set(num);
                System.out.println(Thread.currentThread().getName()+"->"+num);
            },"Thread-"+i);
        }
        for(Thread thread:threads){
            thread.start();
        }
    }
}
