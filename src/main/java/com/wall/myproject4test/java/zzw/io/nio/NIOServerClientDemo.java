package com.wall.myproject4test.java.zzw.io.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class NIOServerClientDemo {
    public static void main(String[] args) {
        try {
            SocketChannel socketChannel =SocketChannel.open();
            // 设置为非阻塞
//            socketChannel.configureBlocking(false);
            socketChannel.connect(new InetSocketAddress("localhost",8080));
//            if(socketChannel.isConnectionPending()){
//                socketChannel.finishConnect();
//            }
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            byteBuffer.put("Hello ,I'm NIO Client01".getBytes());
            byteBuffer.flip();
            socketChannel.write(byteBuffer);
//            // 客户端关闭后服务端没法读报错
//            System.in.read();
            // 读取服务端返回数据
            byteBuffer.clear();
            socketChannel.read(byteBuffer);
            System.out.println("收到服务器消息:"+new String(byteBuffer.array()));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
