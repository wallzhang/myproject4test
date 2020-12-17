package com.wall.myproject4test.java.zzw.io.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIOReaderAndWriteDemo {
    public static void main(String[] args) {
        try {
            FileInputStream fin = new FileInputStream("D://test.txt");
            FileOutputStream fout = new FileOutputStream("D://test_copy.txt");

            FileChannel channel = fin.getChannel();
            FileChannel channel2 = fout.getChannel();

            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            while (true){
                System.out.println("come in");
                int r = channel.read(byteBuffer);
                if(r == -1){
                    break;
                }

                byteBuffer.flip();
                channel2.write(byteBuffer);
                byteBuffer.clear();
            }

        }catch (Exception e){

        }
    }
}
