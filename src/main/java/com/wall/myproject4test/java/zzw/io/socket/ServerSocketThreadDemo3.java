package com.wall.myproject4test.java.zzw.io.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
* @Description: 使用线程池来解决BIO阻塞问题
* @Author: zhang.zw
* @Date: 2020/12/7
*/
public class ServerSocketThreadDemo3 {

    public static void main(String[] args) throws IOException {

        final int DEFAULT_PORT = 8080;
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(DEFAULT_PORT);
            ExecutorService executorService = Executors.newFixedThreadPool(5);
            while (true){
                Socket socket = serverSocket.accept();
                executorService.submit(new SocketThreadDemo(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }  finally {
//            serverSocket.close();
        }
    }
}
