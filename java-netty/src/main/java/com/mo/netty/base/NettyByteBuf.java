package com.mo.netty.base;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.util.CharsetUtil;

/**
 * Created by mo on 2021/1/22
 */
public class NettyByteBuf {

    public static void main(String[] args) {
        /**
         * 创建byteBuf对象，该对象内部包含一个字节数组byte[10]
         * 通过readerindex和writerIndex和capacity，将buffer分成三个区域
         * 已经读取的区域：[0,readerindex)
         * 可读取的区域：[readerindex,writerIndex)
         * 可写的区域: [writerIndex,capacity)
         */
        ByteBuf byteBuf = Unpooled.buffer(10);
        System.out.println("初始化的byteBuf=" + byteBuf);

        for (int i = 0; i < 8; i++) {
            byteBuf.writeByte(i);
        }
        System.out.println("writeByte 后byteBuf=" + byteBuf);

        for (int i = 0; i < 5; i++) {
            System.out.println(byteBuf.getByte(i));
        }
        System.out.println("getByte 后byteBuf=" + byteBuf);

        for (int i = 0; i < 5; i++) {
            System.out.println(byteBuf.readByte());
        }
        System.out.println("readByte 后byteBuf=" + byteBuf);


        //用Unpooled工具类创建ByteBuf
        ByteBuf buffer = Unpooled.copiedBuffer("Hello,ByteBuffer", CharsetUtil.UTF_8);
        //使用相关的方法
        if (buffer.hasArray()) {
            byte[] content = buffer.array();
            //将 content 转成字符串
            System.out.println(new String(content, CharsetUtil.UTF_8));
            System.out.println("buffer=" + buffer);

            System.out.println("readerIndex=" + buffer.readerIndex());
            System.out.println("writerIndex=" + buffer.writerIndex());
            System.out.println("capacity=" + buffer.capacity());
            System.out.println("byte=" + buffer.getByte(0));// 获取数组0这个位置的字符h的ascii码，h=104


            //可读的字节数
            int read = buffer.readableBytes();
            System.out.println("可读的字节数为 " + read);

            //使用for取出各个字节
            for (int i = 0; i < read; i++) {
                System.out.println((char) buffer.getByte(i));
            }

            //范围读取
            System.out.println(buffer.getCharSequence(0,6,CharsetUtil.UTF_8));
            System.out.println(buffer.getCharSequence(6,6,CharsetUtil.UTF_8));
        }
    }
}
