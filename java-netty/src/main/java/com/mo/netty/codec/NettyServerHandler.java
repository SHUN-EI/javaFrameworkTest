package com.mo.netty.codec;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * Created by mo on 2021/1/25
 */
public class NettyServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //System.out.println("收到客户端发送的消息String：" + msg.toString());
        System.out.println("收到客户端发送的消息Object：" + msg.toString());
        //发送数据
        //ctx.writeAndFlush("测试String编解码，server给客户端发送数据");

        //给客户端发回一个long数据
        //ctx.writeAndFlush(2000L);

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
