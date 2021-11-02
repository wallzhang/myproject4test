package com.wall.myproject4test.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class JsoupTest {

    public static void main(String[] args) {
        try {
            // 建立连接
            Document get = Jsoup.connect("https://cl684ee1d9b9dcad.xyz/read.php?tid=48242").get();
            // 获取网页源代码
            System.out.println(get.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
