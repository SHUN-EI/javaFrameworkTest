package com.mo.netty.splitpacket;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

/**
 * Created by mo on 2021/1/26
 */
public class NettyServerHandler extends SimpleChannelInboundHandler<MessageProtocol> {

    private int count;

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, MessageProtocol msg) throws Exception {
        System.out.println("====服务端接收到消息如下====");
        System.out.println("消息的长度= " + msg.getLenght());
        System.out.println("消息的内容= " + new String(msg.getContent(), CharsetUtil.UTF_8));

        System.out.println("服务端接收到消息包数量= " + (++this.count));


    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
