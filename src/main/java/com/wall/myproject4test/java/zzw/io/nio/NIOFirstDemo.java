package com.wall.myproject4test.java.zzw.io.nio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;


/** 
* @Description: NIO Demo
* @Author: zhang.zw
* @Date: 2020/12/15 
*/
public class NIOFirstDemo {
    public static void main(String[] args) {
        try {
            FileInputStream in = new FileInputStream(new File("D://test.txt"));
            FileOutputStream out = new FileOutputStream(new File("D://test_copy2.txt"));
            // NIO
            FileChannel fin = in.getChannel();
            FileChannel fout = out.getChannel();
            // 初始化一个缓冲区
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            // 读取数据到缓冲区
            fin.read(byteBuffer);
            // 标识从读到写
            byteBuffer.flip();
            fout.write(byteBuffer);
            // 重置缓存
            byteBuffer.clear();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
