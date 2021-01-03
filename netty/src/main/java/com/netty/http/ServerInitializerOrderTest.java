package com.netty.http;

import com.netty.util.Print;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

public class ServerInitializerOrderTest extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel sc) {
        //HttpServerCodec 是netty框架提供的处理http请求的编码解码器
        sc.pipeline().addLast("HttpServerCodec",new HttpServerCodec())
                .addLast("Handler",new ServerHandler())
                .addLast("Handler2",new ServerHandler2())
                .addLast("Handler3",new ServerHandler3());

    }
    //自定义Handler
    class ServerHandler extends ChannelInboundHandlerAdapter {

        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            Print.eprintlnTN("--------------ServerHandler------------");
            super.channelRead(ctx, msg);
        }
    }

    //自定义Handler2
    class ServerHandler2 extends ChannelInboundHandlerAdapter {

        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            Print.eprintlnTN("--------------ServerHandler2------------");
            super.channelRead(ctx, msg);
        }
    }
    //自定义Handler3
    class ServerHandler3 extends ChannelInboundHandlerAdapter {

        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            Print.eprintlnTN("--------------ServerHandler3------------");
            super.channelRead(ctx, msg);
        }
    }
}
