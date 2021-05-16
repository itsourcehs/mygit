package cn.itcast.demo18.TCPDemo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @program: HelloWorld
 * @description:
 * @author: Mr.Huang
 * @create: 2021-05-16 22:07
 **/

public class TCPThreadServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8000);
        while (true){
            /**实现多线程完成多个客户端上传图片:
             *      获取到一个客户端,开启一个新线程
             *      当一个客户端与服务端创建连接就开启一个线程
             */
            Socket socket = server.accept();
            new Thread(new Upload(socket)).start();
        }
    }
}
