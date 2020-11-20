package com.wall.myproject4test.java.zzw.inf4demo.stringjoiner;

import java.util.StringJoiner;

/**
* @Description:  StringJoiner测试
* @Author: zhang.zw
* @Date: 2020/11/18
*/
public class StringJoiner4Test {
    public static void main(String[] args) {
        StringJoiner sj = new StringJoiner("");
        StringJoiner sj2 = new StringJoiner(",").add("张三").add("李四").add("王五");
        System.out.println("----------1");
        System.out.println(sj.length());
        System.out.println(sj2.length());
        System.out.println("-----------2");
        System.out.println(sj.toString());
        System.out.println(sj2.toString());
    }
}
