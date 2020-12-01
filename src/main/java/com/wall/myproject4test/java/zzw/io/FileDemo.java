package com.wall.myproject4test.java.zzw.io;


import java.io.*;

/**
* @Description: 基于File路径做递归获取目录下的所有文件
* @Author: zhang.zw
* @Date: 2020/12/1
*/
public class FileDemo {

    public static void main(String[] args) {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader bf = new BufferedReader(in);
        try {
            // 获取需要输入的路径
            String filePath = bf.readLine();
            File file = new File(filePath);
            readFiles(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readFiles(File file) {
        File[] files = file.listFiles();
        for (int i = 0;i<files.length;i++){
            if(files[i].isDirectory()&&files[i].exists()){
                readFiles(files[i]);
            }else {
                System.out.println(files[i].getName());
            }
        }
    }
}
