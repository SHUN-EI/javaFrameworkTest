package com.mo.netty.splitpacket;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

/**
 * Created by mo on 2021/1/26
 */
public class NettyClientHandler extends SimpleChannelInboundHandler<MessageProtocol> {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        for (int i = 0; i < 20; i++) {
            String msg = "你好，我是客户端发送的数据";
            //创建协议包对象
            MessageProtocol protocol = new MessageProtocol();
            protocol.setLenght(msg.getBytes(CharsetUtil.UTF_8).length);
            protocol.setContent(msg.getBytes(CharsetUtil.UTF_8));
            ctx.writeAndFlush(protocol);
        }

    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, MessageProtocol messageProtocol) throws Exception {

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
