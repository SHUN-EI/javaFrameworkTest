package com.mo.netty.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.ExecutionException;

/**
 * Created by mo on 2021/1/20
 */
public class AioClient {

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        AsynchronousSocketChannel socketChannel = AsynchronousSocketChannel.open();
        socketChannel.connect(new InetSocketAddress("127.0.0.1", 9000)).get();
        socketChannel.write(ByteBuffer.wrap("Hello AIOServer".getBytes()));
        ByteBuffer byteBuffer = ByteBuffer.allocate(512);

        Integer read = socketChannel.read(byteBuffer).get();
        if (read != -1) {
            System.out.println("客户端收到信息: " + new String(byteBuffer.array(), 0, read));
        }

    }
}
