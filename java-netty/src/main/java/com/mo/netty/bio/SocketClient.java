package com.mo.netty.bio;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by mo on 2021/1/18
 */
public class SocketClient {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 9000);

        //向服务端发送数据
        socket.getOutputStream().write("Hello Server ".getBytes());
        socket.getOutputStream().flush();
        System.out.println("向服务端发送数据结束");

        byte[] bytes = new byte[1024];
        //接收服务端回传的数据
        socket.getInputStream().read(bytes);
        System.out.println("接收到服务端的数据: " + new String(bytes));
        socket.close();
    }
}
