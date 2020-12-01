package com.wall.myproject4test.java.zzw.io;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
* @Description: IO流读取，写入picture
* @Author: zhang.zw
* @Date: 2020/12/1
*/
public class InputStreamDemo {
    public static void main(String[] args) throws IOException {
        // 读取D盘图片复制黏贴
        // 因为是图片不是文本所以用fileInputStream
        // JDK1.7写法流的新建放在try条件内，后面可以不需要手动关闭流
        // try (FileInputStream in = new FileInputStream("D:\\test.png");FileOutputStream out = new FileOutputStream("D:\\test_copy.png")){
        // }
        FileInputStream in = null;
        FileOutputStream out = null;
        try {

            in = new FileInputStream("D:\\test.png");
            // 根据源码可以了解到文件不存在的时候会调用new File方法新建文件
            out = new FileOutputStream("D:\\test_copy.png");
            int len = 0;
            // read方法源码显示，最后一位读取完毕后显示-1
            // 先把输入流数据通过read方法后写入到输出流，但是有个问题，会导致频繁的IO,不推荐使用
            //            while ((len = in.read()) != -1){
            //                out.write(len);
            //            }
            // 推荐写法，利用数组做缓存，如下所示byte的数组大小为1024，
            // 假设文件大小为3000字节大小，用了这个方法则只需要做3次IO
            byte[] bytes = new byte[1024];
            while ((len = in.read(bytes)) != -1){
                out.write(bytes,0,len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            // 使用流千万要注意必须关闭流
            in.close();
            out.close();
        }
    }
}
