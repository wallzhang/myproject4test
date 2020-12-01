package com.wall.myproject4test.java.zzw.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamDemo {
    public static void main(String[] args) {
        FileInputStream fileInputStream = null;
        try {
            // 构造器支持String Name 和file，其实本质上都是传File，可以点开源码进行查看
            fileInputStream = new FileInputStream("D:\\test.txt");
            // read方法可以查源码，这边我直接粘出来,会从inputStream里一个个读取字节，最终为-1时读取结束
            // 所以这边我们需要做一个遍历
            /**
             * Reads a byte of data from this input stream. This method blocks
             * if no input is yet available.
             *
             * @return     the next byte of data, or <code>-1</code> if the end of the
             */
            int i = 0;
            System.out.println("------------------------start");
            while ((i = fileInputStream.read())!=-1){
                System.out.print((char) i);
            }
            System.out.println("");
            System.out.println("------------------------end");
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

        }
    }
}
