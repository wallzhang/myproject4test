package com.wall.myproject4test.java.zzw.io.socket;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
* @Description: 把流程放到线程里做处理
* @Author: zhang.zw
* @Date: 2020/12/7
*/
public class SocketThreadDemo implements Runnable{
    Socket socket;

    public SocketThreadDemo(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
//            while (true){
                System.out.println("客服端:"+socket.getPort()+"已连接");
                BufferedReader bf = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String clientStr = bf.readLine();
                System.out.println("收到客户端请求:"+clientStr);
                Thread.sleep(15000); // 模拟服务端处理流程
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                bw.write("我已经收到"+socket.getPort()+"信息\n");
                bw.flush();
//            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
