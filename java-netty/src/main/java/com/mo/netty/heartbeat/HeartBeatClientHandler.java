package com.mo.netty.heartbeat;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * Created by mo on 2021/1/27
 */
public class HeartBeatClientHandler extends SimpleChannelInboundHandler<String> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println(" client received :" + msg);
        if (msg != null && msg.equals("idle close")) {
            System.out.println(" 服务端关闭连接，客户端也关闭");
            ctx.channel().closeFuture();
        }
    }
}
