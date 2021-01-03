package com.netty.simple;

import com.netty.util.Print;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.util.HashSet;
import java.util.Set;

public class NettyServer {
    public static Set<SocketChannel> scs = new HashSet<>();
    public static void main(String[] args) {
        final EventLoopGroup bossGroup = new NioEventLoopGroup();
        final EventLoopGroup workerGroup = new NioEventLoopGroup(3);
        final ServerBootstrap boot = new ServerBootstrap();
        try {
            boot.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 128)
                    .childOption(ChannelOption.SO_KEEPALIVE, true)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel sc) throws Exception {
                            scs.add(sc);
                            Print.eprintlnTN("有新的client加入  client-hash:"+ sc.hashCode());
                            sc.pipeline().addLast(new NettyServerHandler());
                        }
                    });
            System.err.println("Server is ready....");

            final ChannelFuture cf = boot.bind(8888).sync();
            cf.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
