package com.netty.chapter5;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author zzh
 * @date 2021年07月23日
 */
public class ServerSockerChannel_ {

    public static void main(String[] args) throws IOException {

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        InetSocketAddress inetSocketAddress = new InetSocketAddress(7000);
        //绑定端口到SocketServer
        serverSocketChannel.socket().bind(inetSocketAddress);

        ByteBuffer[] byteBuffers = new ByteBuffer[2];
        byteBuffers[0] = ByteBuffer.allocate(5);
        byteBuffers[1] = ByteBuffer.allocate(3);
        //等待客户端连接
        SocketChannel accept = serverSocketChannel.accept();
        int mesageLength = 8;
        while (true){
            int byteRead = 0;
            while (byteRead < mesageLength){
                long read = accept.read(byteBuffers);
                byteRead += read;
                System.out.println("byteRead = " + byteRead);
                Arrays.asList(byteBuffers)
                        .stream()
                        .map(buffer -> "position=" + buffer.position() + ",limit=" +buffer.limit())
                        .forEach(System.out::println);
            }
            Arrays.asList(byteBuffers).forEach(Buffer::flip);
            long byteWrite  = 0;
            while (byteWrite < mesageLength){
                long write = accept.write(byteBuffers);
                byteWrite += write;
            }
            //将所有的buffer进行clear
            Arrays.asList(byteBuffers).forEach(Buffer::clear);
            System.out.println("byteRead:="+ byteRead + "  byteWrite:"+ byteWrite);
        }
    }
}
