package com.netty.chapter6;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

public class NIOSocketServer {

    public static void main(String[] args) throws IOException {
        //创建一个ServerSocketChannel
        final ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //创建一个Selector
        final Selector selector = Selector.open();
        //监听端口6666
        serverSocketChannel.bind(new InetSocketAddress(6666));
        //设置为非阻塞
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        while (true) {
            if (selector.select(1000) == 0) {
//                System.out.println("服务器等待1秒，没有连接");
                continue;
            }
            //获取有事件发生的selectionKey集合
            final Set<SelectionKey> selectionKeys = selector.selectedKeys();
            final Iterator<SelectionKey> iterator = selectionKeys.iterator();
            if (iterator.hasNext()) {
                final SelectionKey selectionKey = iterator.next();
                //根据事件类型，分别做不同处理
                if (selectionKey.isAcceptable()) {
                    //selectionKeys反向获取channel
                    //方法执行到这里，说明确实有连接事件发生了，accept()方法不会阻塞在这里
                    final SocketChannel socketChannel = serverSocketChannel.accept();
                    System.out.println("有客户端和server建立了连接--- 客户端channel hashcode:" + socketChannel.hashCode());
                    //设置channel为非阻塞
                    socketChannel.configureBlocking(false);
                    //将客户端的channel注册到Selector,并绑定一个Buffer
                    socketChannel.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(1024));
                }
                if (selectionKey.isConnectable()) {

                }
                //发生了读的事件
                if (selectionKey.isReadable()) {
                    //selectionKeys反向获取channel
                    final SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                    final ByteBuffer buffer = (ByteBuffer) selectionKey.attachment();
                    System.out.println("attachment buffer:"+buffer.hashCode());
                    socketChannel.read(buffer);
                    System.out.println("from 客户端 " + new String(buffer.array(),0,buffer.position()));
                    //这里需要注意 和当前selectorKey 绑定的 buffer 每次用完需要 clear 否则下次用的时候里面有上次的数据
                    buffer.clear();
                }
                //手动从集合中移除当前selectorKey
                iterator.remove();
            }

        }
    }
}
