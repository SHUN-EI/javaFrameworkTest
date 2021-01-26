package com.mo.netty.splitpacket;

/**
 * Created by mo on 2021/1/26
 * 自定义协议包
 */
public class MessageProtocol {

    /**
     * 定义一次发送包体长度
     */
    private int lenght;

    /**
     * 一次发送包体内容
     */
    private byte[] content;

    public int getLenght() {
        return lenght;
    }

    public void setLenght(int lenght) {
        this.lenght = lenght;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }
}
