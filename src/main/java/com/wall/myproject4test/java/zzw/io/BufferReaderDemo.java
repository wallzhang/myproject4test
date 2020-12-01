package com.wall.myproject4test.java.zzw.io;

import java.io.BufferedReader;
import java.io.FileReader;


/** 
* @Description: 简单写写readline方法得了 
* @Author: zhang.zw
* @Date: 2020/12/2
*/
public class BufferReaderDemo {


    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("D://t2.txt"))){
            System.out.println(bufferedReader.readLine());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
