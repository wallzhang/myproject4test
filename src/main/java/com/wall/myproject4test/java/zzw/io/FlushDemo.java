package com.wall.myproject4test.java.zzw.io;


import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

/**
* @Description: 校验缓冲的flush方法的作用
* @Author: zhang.zw
* @Date: 2020/12/2
*/
public class FlushDemo {
    public static void main(String[] args) {
        try {
            // 不关闭out输出流，会发现数据没有存到对应的t2.txt文件上
            // 因为缓冲区默认大小为8kb，到不了不会执行flush方法，（刷盘）。
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("D://t2.txt"));
            out.write("Hello world".getBytes());
            // 处理方案 1.手动执行flush 2.关闭流
//            out.flush();
//            out.close();
        }catch (Exception e){

        }
    }
}
