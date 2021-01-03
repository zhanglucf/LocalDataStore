package com.netty.simple;

import com.netty.util.Nap;
import com.netty.util.Print;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

import java.util.concurrent.TimeUnit;

import static com.netty.util.Print.eprintlnTN;

/**
 * 由workerGroup中的线程池轮询调用NettyServerHandler中的方法
 */
public class NettyServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        eprintlnTN(" NettyServerHandler ");
        ByteBuf buf = (ByteBuf) msg;
        eprintlnTN("客户端发送消息是:" + buf.toString(CharsetUtil.UTF_8));
//        eprintlnTN("客户端地址:" + ctx.channel().remoteAddress());
//        eprintlnTN("开始处理任务");
        //如果任务比较耗时，所有的线程均被阻塞
//        new Nap(30000);
//        eprintlnTN("处理任务完成");
//        eprintlnTN("-----------");

        /*
            如何实现异步任务？

            下面为实现异步任务的方式一：放到ctx->pipeline->channel->eventLoop  的taskQueue中

            需要注意：下面的异步任务1和异步任务2会被workGroup线程池
            中的某一个线程执行，所以只有异步任务2执行结束才会执行异步任务2
        ctx.channel().eventLoop().execute(() -> {
            eprintlnTN("异步任务1开始");
            new Nap(10000);
            eprintlnTN("异步任务1完成");
            ctx.writeAndFlush(Unpooled.copiedBuffer("异步任务1完成", CharsetUtil.UTF_8));
        });

        ctx.channel().eventLoop().execute(() -> {
            eprintlnTN("异步任务2开始");
            new Nap(10000);
            eprintlnTN("异步任务2完成");
            ctx.writeAndFlush(Unpooled.copiedBuffer("异步任务2完成", CharsetUtil.UTF_8));
        });
         */
        /*
            实现异步任务方式二：定时任务  放到ctx->pipeline->channel->eventLoop 的taskQueue中 scheduledTaskQueue中

            需要注意的是：两个定时任务中ctx.writeAndFlush() 以及channelReadComplete中的ctx.writeAndFlush()消息最后会合并
            然后发给client端
        ctx.channel().eventLoop().schedule(() -> {
            eprintlnTN("定时任务1开始");
            eprintlnTN("定时任务1完成");
            ctx.writeAndFlush(Unpooled.copiedBuffer("定时任务1完成", CharsetUtil.UTF_8));
        },10, TimeUnit.SECONDS);

        ctx.channel().eventLoop().schedule(() -> {
            eprintlnTN("定时任务2开始");
            eprintlnTN("定时任务2完成");
            ctx.writeAndFlush(Unpooled.copiedBuffer("定时任务2完成", CharsetUtil.UTF_8));
        },10, TimeUnit.SECONDS);
         */
        /*
            非当前Reactor线程调用channel的方法

            childHandler->initChannel方法中把不同的client socketChannel维护起来
            然后根据需要，取出，使用
         */

        NettyServer.scs.stream()
                .filter(sc -> sc.pipeline().channel().hashCode() != ctx.channel().hashCode())
                .forEach(sc->{
                    sc.pipeline().channel().writeAndFlush(Unpooled.copiedBuffer("channel:"+ctx.channel().hashCode() + "推送了广播消息", CharsetUtil.UTF_8));
                });
        eprintlnTN(" NettyServerHandler 2");

    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(Unpooled.copiedBuffer("hello 客户端", CharsetUtil.UTF_8));
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}