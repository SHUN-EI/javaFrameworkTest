package com.mo.netty.splitpacket;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * Created by mo on 2021/1/26
 * 自定义消息编码器
 */
public class MessageEncoder extends MessageToByteEncoder<MessageProtocol> {

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, MessageProtocol msg, ByteBuf byteBuf) throws Exception {
        System.out.println("MessageEncoder 的 encode 方法被调用");
        byteBuf.writeInt(msg.getLenght());
        byteBuf.writeBytes(msg.getContent());
    }
}
