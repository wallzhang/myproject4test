package com.wall.myproject4test.java.zzw.io.nio;

import java.io.IOException;
import java.nio.channels.Selector;

public class NIOSelectorServerDemo {

    static Selector selector;
//    final static int res = 3;
    public static void main(String[] args) {
        try {
            selector = Selector.open();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        res =5;
    }
}
