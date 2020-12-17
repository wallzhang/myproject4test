package com.wall.myproject4test.java.zzw.io.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class NIOServerSocketDemo {
    public static void main(String[] args) {
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            // 默认是false阻塞IO
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.socket().bind(new InetSocketAddress(8080));
            while (true){
                SocketChannel socketChannel = serverSocketChannel.accept();

                if(socketChannel != null){
                    // 代表有人连接过来
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                    socketChannel.read(byteBuffer);
                    System.out.println(new String(byteBuffer.array()));

                    // 把消息返回给客户端
                    Thread.sleep(5000);
                    byteBuffer.flip();
                    socketChannel.write(byteBuffer);
                }else {
                    Thread.sleep(5000);
                    System.out.println("没有人连接过来!");
                }

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
