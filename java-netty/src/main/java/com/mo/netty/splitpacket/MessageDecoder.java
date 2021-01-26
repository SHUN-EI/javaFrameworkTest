package com.mo.netty.splitpacket;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * Created by mo on 2021/1/26
 * 自定义消息解码器
 */
public class MessageDecoder extends ByteToMessageDecoder {

    private int length = 0;

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf byteBuf, List<Object> list) throws Exception {
        System.out.println();
        System.out.println("MessageDecoder 的decode 方法被调用 ");

        //需要将得到二进制字节码-> MessageProtocol 数据包(对象)
        System.out.println(byteBuf);

        if (byteBuf.readableBytes() >= 4) {
            if (length == 0) {
                length = byteBuf.readInt();
            }

            if (byteBuf.readableBytes() < length) {
                System.out.println("当前可读数据不够，继续等待....");
                return;
            }

            byte[] content = new byte[length];
            if (byteBuf.readableBytes() >= length) {
                byteBuf.readBytes(content);

                //封装成MessageProtocol对象，传递到下一个handler业务处理
                MessageProtocol protocol = new MessageProtocol();
                protocol.setLenght(length);
                protocol.setContent(content);
                list.add(protocol);
            }
            //消息读完之后，让长度重新置为0
            length = 0;
        }

    }
}
