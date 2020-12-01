package com.wall.myproject4test.java.zzw.io;


import java.io.*;
import java.net.Socket;

/**
* @Description: 4中常见的IO来源
* @Author: zhang.zw
* @Date: 2020/12/1
*/
public class IO4SourceDemo {
    public static void main(String[] args) {
        // 磁盘IO
        FileInputStream in = null;
        try {
            in = new FileInputStream("D:\\test.txt");
            int i = 0;
            while ((i = in.read())!=-1){
                System.out.print((char)i);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 内存IO
        String str = "Hello world";
        ByteArrayInputStream in2 = new ByteArrayInputStream(str.getBytes());
        int j = 0;
        while ((j=in2.read())!= -1){
            System.out.print((char)j);
        }
        // 键盘IO
        // Scanner
        InputStream in3 = System.in;
        try {
            int k = 0;
            while ((k = in3.read())!= -1){
                System.out.print((char)k);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 网络IO
//        Socket socket;
//        socket.getInputStream();
//        socket.getOutputStream();
    }
}
