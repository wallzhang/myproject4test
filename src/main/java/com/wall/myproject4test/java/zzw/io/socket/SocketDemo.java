package com.wall.myproject4test.java.zzw.io.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class SocketDemo {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost",8080);
            OutputStream out = socket.getOutputStream();
            out.write("Hello".getBytes("UTF-8"));
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
