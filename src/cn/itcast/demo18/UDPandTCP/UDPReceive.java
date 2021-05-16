package cn.itcast.demo18.UDPandTCP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @program: HelloWorld
 * @description: 实现UDP数据包接收端
 * 实现封装数据的类 java.net.DatagramPacket 数据接收
 * 实现数据传输的类 java.net.DatagramSocket 接收数据包
 *
 * 1.创建DatagramSocket对象,绑定端口号
 *  要求和发送端口一致
 * 2.创建字节数组,接收发来的数据
 * 3.创建数据包对象DatagramPacket(byte[] , int length)
 * 4.调用DatagramSocket对象方法receive(DatagramPacket dp)
 * 5.拆包:
 *      发送的ip地址: 数据包对象DatagramPacket方法getAddress()
 *          - 获取到发送端的IP地址
 *          - 返回值是InetAddress对象
 *      接收到的字节个数: 数据包对象DatagramPacket方法getLength()
 *      发送方的端口: 数据包对象DatagramPacket方法getPort()
 * 6.关闭资源
 * @author: Mr.Huang
 * @create: 2021-05-16 14:28
 **/

public class UDPReceive {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket(6000);
        //创建字节数组
        byte[] data = new byte[1024*64];
        //创建数据包对象
        DatagramPacket dp = new DatagramPacket(data, data.length);
        //4.调用DatagramSocket对象方法receive
        ds.receive(dp);

        //获取到发送方的ip地址对象
        String ip = dp.getAddress().getHostAddress();

        //获取发送端的端口
        int port = dp.getPort();

        //获取接收到的字节个数
        int length = dp.getLength();
        System.out.println(new String(data,0,length)+"..."+ip+":"+port);

        ds.close();
    }
}
