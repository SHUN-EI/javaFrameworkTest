package com.mo.netty.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by mo on 2021/1/18
 * BIO 模型
 */
public class SocketServer {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9000);

        while (true) {
            System.out.println("等待连接....");

            //阻塞方法
            Socket clientSocket = serverSocket.accept();
            System.out.println("有客户端连接了....");

            //单线程
            //handler(clientSocket);

            //多线程
            new Thread(()-> {
                try {
                    handler(clientSocket);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();

        }
    }

    private static void handler(Socket clientSocket) throws IOException {
        byte[] bytes = new byte[1024];

        System.out.println("准备读取数据 read....");

        //接收客户端的数据，阻塞方法，没有数据可读的时候就阻塞
        int read = clientSocket.getInputStream().read(bytes);
        System.out.println("read数据完毕....");

        if (read != -1) {
            System.out.println("接收到客户端的数据是： " + new String(bytes, 0, read));
        }

        clientSocket.getOutputStream().write("Hello Client".getBytes());
        clientSocket.getOutputStream().flush();

    }

}
