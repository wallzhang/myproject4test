package com.wall.myproject4test.java.zzw.io.nio;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
* @Description: NIO ReadDemo
* @Author: zhang.zw
* @Date: 2020/12/15 
*/
public class NIOReadDemo {
    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream(new File("D://test.txt"))){
            // 建立通道
            FileChannel channel = in.getChannel();
            // 读取数据
            // 分配缓存区大小
            ByteBuffer bf = ByteBuffer.allocate(1024);
//            Byte[] bytes = new Byte[1024];
//            ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
//            while (channel.read(bf)!=-1){
//
//            }
            int rs = channel.read(bf);
            System.out.println(new String(bf.array()));
//            if(rs == -1){
//
//            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
