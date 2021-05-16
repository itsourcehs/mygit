package cn.itcast.demo18.UDPandTCP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @program: HelloWorld
 * @description: 数据发送端:  实现UDP协议的发送端
 * 实现封装数据的类 java.net.DatagramPacket 数据打包
 * 实现数据传输的类 java.net.DatagramSocket 发出
 *
 * 1.创建DatagramPacket对象,封装数据,接收端的地址和端口
 * 2.创建DatagramSocket
 * 3.调用DatagramPacket类方法send,发送数据包
 * 4.关闭资源 - DatagramSocket
 *
 *  DatagramPacket构造器: DatagramPacket(byte[] buf,int length,InetAddress,int port)
 *  DatagramSocket构造器: DatagramSocket() 方法: send(DatagramSocket d)
 * @author: Mr.Huang
 * @create: 2021-05-16 14:07
 **/

public class UDPSend {
    public static void main(String[] args) throws IOException {
        byte[] data = "你好UDP".getBytes();
        //创建InetAddress对象,封装ip地址
        InetAddress inet = InetAddress.getByName("127.0.0.1");
        DatagramPacket dp = new DatagramPacket(data, data.length,inet,6000);
        //创建DatagramSocket对象,数据包的发送和接收对象
        DatagramSocket ds = new DatagramSocket();
        //调用ds对象方法send,发送数据包
        ds.send(dp);

        ds.close();
    }
}
