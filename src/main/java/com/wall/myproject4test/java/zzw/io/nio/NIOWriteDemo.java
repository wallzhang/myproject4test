package com.wall.myproject4test.java.zzw.io.nio;

import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;


/** 
* @Description:  
* @Author: zhang.zw
* @Date: 2020/12/15 
*/
public class NIOWriteDemo {
    public static void main(String[] args) {
        try (FileOutputStream fileOutputStream = new FileOutputStream("D://test.txt")){
            FileChannel channel = fileOutputStream.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            byteBuffer.put("I'm NIO".getBytes());
            byteBuffer.flip();
            channel.write(byteBuffer);
        }catch (Exception e){

        }
    }
}
