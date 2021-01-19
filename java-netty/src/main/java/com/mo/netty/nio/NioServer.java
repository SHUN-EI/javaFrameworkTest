package com.mo.netty.nio;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by mo on 2021/1/18
 * NIO 模型
 */
public class NioServer {

    static List<SocketChannel> channelList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        // 创建NIO ServerSocketChannel,与BIO的serverSocket类似
        ServerSocketChannel socketChannel = ServerSocketChannel.open();
        socketChannel.socket().bind(new InetSocketAddress(9000));

        // 设置ServerSocketChannel为非阻塞
        socketChannel.configureBlocking(false);
        System.out.println("服务启动成功");

        while (true) {
            // 非阻塞模式accept方法不会阻塞，否则会阻塞
            // NIO的非阻塞是由操作系统内部实现的，底层调用了linux内核的accept函数
            SocketChannel channel = socketChannel.accept();
            if (channel != null) {
                //若有客户端进行连接
                System.out.println("连接成功");
                //设置与客户端正在连接的SocketChannel为非阻塞
                channel.configureBlocking(false);
                //保存客户端连接在 channelList中
                channelList.add(channel);
            }

            // 遍历连接进行数据读取
            Iterator<SocketChannel> iterator = channelList.iterator();
            while (iterator.hasNext()) {
                SocketChannel skChannel = iterator.next();
                ByteBuffer byteBuffer = ByteBuffer.allocate(128);

                // 非阻塞模式read方法不会阻塞，否则会阻塞
                int read = skChannel.read(byteBuffer);

                if (read > 0) {
                    System.out.println("接收到的消息:" + new String(byteBuffer.array()));
                } else if (read == -1) {
                    //如果客户端断开，把 socket 从集合中去掉
                    iterator.remove();
                    System.out.println("客户端断开连接");
                }
            }
        }

    }

}
