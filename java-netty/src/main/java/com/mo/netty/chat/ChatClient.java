package com.mo.netty.chat;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.util.Scanner;

/**
 * Created by mo on 2021/1/24
 */
public class ChatClient {

    public static void main(String[] args) throws InterruptedException {
        EventLoopGroup group = new NioEventLoopGroup();

        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {

                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            ChannelPipeline pipeline = socketChannel.pipeline();

                            //向pipeline加入编码器
                            pipeline.addLast("encoder", new StringEncoder());
                            //向pipeline加入解码器
                            pipeline.addLast("decoder", new StringDecoder());

                            pipeline.addLast(new ChatClientHandler());
                        }
                    });

            ChannelFuture channelFuture = bootstrap.connect("127.0.0.1", 9000).sync();
            //得到 channel
            Channel channel = channelFuture.channel();
            System.out.println("========" + channel.localAddress() + "========");

            //客户端需要输入信息， 创建一个扫描器
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNextLine()) {
                String msg = scanner.nextLine();

                //通过 channel 发送到服务器端
                channel.writeAndFlush(msg);
            }


//            //循环发送数据，容易导致数据粘包拆包问题
//            for (int i = 0; i < 20; i++) {
//                channel.writeAndFlush("hello，everyone !");
//            }

        } finally {
            group.shutdownGracefully();
        }
    }
}
