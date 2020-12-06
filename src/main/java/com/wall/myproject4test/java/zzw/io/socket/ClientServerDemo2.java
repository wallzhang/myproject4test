package com.wall.myproject4test.java.zzw.io.socket;

import java.io.*;
import java.net.Socket;

public class ClientServerDemo2 {
    public static void main(String[] args) {
        final int DEFAULT_PORT = 8080;
        try {
            Socket socket = new Socket("localhost",DEFAULT_PORT);
            BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bf.write("我是客服端02发送的信息\n");
            bf.flush();
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String reply = br.readLine();
            System.out.println("收到server信息:"+reply);
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
