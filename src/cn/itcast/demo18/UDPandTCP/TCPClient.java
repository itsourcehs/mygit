package cn.itcast.demo18.UDPandTCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @program: HelloWorld
 * @description: TCP客户端
 * 和服务器实现数据交换
 * 实现TCP客户端的类 -- java.net.Socket
 *
 * 构造方法: Socket(String host,int port) 传递服务器ip和端口号
 *      注意: 构造方法只要运行,就会和服务器建立链接,连接失败则会抛出异常
 *    OutputStream getOutputStream() -- 返回套接字的输出流
 *    作用: 将数据输出到服务器
 *
 *    InputStream getInputStream() -- 返回套接字的输入流
 *    作用: 从服务端读取数据
 *
 *    客户端与服务端数据交换,必须使用套接字对象Socket中的获取的IO流,自己new流对象不行
 * @author: Mr.Huang
 * @create: 2021-05-16 15:12
 **/

public class TCPClient {
    public static void main(String[] args) throws IOException {
        //1.创建Socket对象,连接服务器
        Socket socket = new Socket("127.0.0.1",8888);

        //2.通过客户端的套接字对象Socket方法,获取字节输出流,将数据写向服务器
        OutputStream out = socket.getOutputStream();
        out.write("服务器Ok".getBytes());

        //3.读取服务器发出的数据,使用socket套接字对象中的字节输出流
        InputStream in = socket.getInputStream();
        byte[] data = new byte[1024];
        int len = in.read(data);
        System.out.println(new String(data,0,len));

        //4.关闭资源
        socket.close();
    }

}
