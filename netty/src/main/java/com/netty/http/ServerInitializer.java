package com.netty.http;

import com.netty.util.Print;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

public class ServerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel sc) {
        //HttpServerCodec 是netty框架提供的处理http请求的编码解码器
        sc.pipeline().addLast("MyHttpServerCodec",new HttpServerCodec())
                //添加自定义Handler
                .addLast(new HttpServerHandler());

    }
    //自定义Handler
    class HttpServerHandler extends SimpleChannelInboundHandler<HttpObject>{
        @Override
        protected void channelRead0(ChannelHandlerContext chx, HttpObject httpObject) throws Exception {
            if (httpObject instanceof HttpRequest) {

                        Print.eprintlnTN("pipeline hashCode:"+ chx.pipeline().hashCode()
                                + " HttpServerHandler hashCode" + this.hashCode());

                HttpRequest httpRequest = (HttpRequest) httpObject;
                if(httpRequest.getUri().equals("/favicon.ico")){
                    return;
                }
                Print.printlnTN("httpObject 类型=" + httpObject.getClass());
                Print.eprintlnTN("客户端地址：" + chx.channel().remoteAddress() );

                final ByteBuf byteBuf = Unpooled.copiedBuffer("hello,我是服务器", CharsetUtil.UTF_8);
                //构建一个httpResponse
                final DefaultFullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, byteBuf);
                response.headers().set(HttpHeaderNames.CONTENT_TYPE,"text/plain;charset=utf-8");
                response.headers().set(HttpHeaderNames.CONTENT_LENGTH,byteBuf.readableBytes());
                chx.writeAndFlush(response);
            }
        }
    }
}
