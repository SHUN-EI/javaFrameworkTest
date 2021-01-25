package com.mo.netty.codec;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * Created by mo on 2021/1/25
 */
public class NettyClientHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("收到服务器发送的消息:" + msg);

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("MyClientHandler发送数据");
        //发送数据，测试String编解码
        //ctx.writeAndFlush("测试String编解码，client给服务端发送数据");
        //发送数据，测试对象编解码
        ctx.writeAndFlush(new User(1,"关羽"));
    }
}
