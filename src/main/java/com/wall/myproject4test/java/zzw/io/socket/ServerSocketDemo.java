package com.wall.myproject4test.java.zzw.io.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketDemo {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            Socket socket = serverSocket.accept();
            InputStream inputStream = socket.getInputStream();
            int len = 0;
            byte[] buffer = new byte[1024];
            if ((len=inputStream.read(buffer))!=-1){
                System.out.println(new String(buffer));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
