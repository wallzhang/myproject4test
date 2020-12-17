package com.wall.myproject4test.java.zzw.io.nio;


import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
* @Description: MMP 
* @Author: zhang.zw
* @Date: 2020/12/16 
*/
public class NIOMMPDemo {
    public static void main(String[] args) throws IOException {

        FileChannel inChannel = FileChannel.open(Paths.get("D://test.txt"), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("D://test3_copy.txt"),
                StandardOpenOption.READ,StandardOpenOption.WRITE,StandardOpenOption.CREATE);

        MappedByteBuffer in = inChannel.map(FileChannel.MapMode.READ_ONLY,0,inChannel.size());
        MappedByteBuffer out = outChannel.map(FileChannel.MapMode.READ_WRITE,0,inChannel.size());

        byte[] bytes = new byte[in.limit()];
        in.get(bytes);
        out.put(bytes);
        inChannel.close();
        outChannel.close();
    }
}
