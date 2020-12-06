package com.wall.myproject4test.java.zzw.io.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketThreadDemo2 {

    public static void main(String[] args) throws IOException {

        final int DEFAULT_PORT = 8080;
        ServerSocket serverSocket = null;
        serverSocket = new ServerSocket(DEFAULT_PORT);
        try {
            while (true){
                Socket socket = serverSocket.accept();
                System.out.println("客服端:"+socket.getPort()+"已连接");
                BufferedReader bf = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String clientStr = bf.readLine();
                System.out.println("收到客户端请求:"+clientStr);
                Thread.sleep(15000); // 模拟服务端处理流程
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                bw.write("我已经收到信息\n");
                bw.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
//            serverSocket.close();
        }
    }
}
