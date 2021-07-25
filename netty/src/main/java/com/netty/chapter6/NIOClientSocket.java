package com.netty.chapter6;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

public class NIOClientSocket {

    public static void main(String[] args) throws IOException {
        final SocketChannel socketChannel = SocketChannel.open();
        System.out.println("客户端 socketChannel hashcode:" + socketChannel.hashCode());
        socketChannel.configureBlocking(false);
        final InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1", 6666);
        //是非阻塞的
        if (!socketChannel.connect(inetSocketAddress)) {
            while (!socketChannel.finishConnect()) {
                System.out.println("如果客户端没有连接上服务端，客户端也不会阻塞connect这里，可以去做其他工作");
            }
        }
        //连接到服务端了
        final Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("请输入你要发送的信息");
            String msg = scanner.next();
            final ByteBuffer buffer = ByteBuffer.wrap(msg.getBytes());
            System.out.println("客户端buffer:" + buffer.hashCode());
            //将buffer数据写入buffer
            socketChannel.write(buffer);
        }
    }
}
