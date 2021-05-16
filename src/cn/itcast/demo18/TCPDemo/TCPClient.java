package cn.itcast.demo18.TCPDemo;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @program: HelloWorld
 * @description: 实现TCP图片上传客户端
 * 实现步骤:
 *      1.Socket套接字连接服务器
 *      2.通过Socket获取字节输出流,写图片
 *      3.使用自己流对象,读取图片数据源
 *          FileInputStream
 *      4.读取图片,使用字节输出流,将图片写到服务器
 *          采用字节数组进行缓冲
 *      5.通过Socket套接字获取字节输入流
 *          读取服务器发回来的上传成功
 *      6.关闭资源
 * @author: Mr.Huang
 * @create: 2021-05-16 21:22
 **/

public class TCPClient {
    public static void main(String[] args) throws IOException {
        //1.Socket套接字连接服务器
        Socket socket = new Socket("127.0.0.1",8000);
        //2.通过Socket获取字节输出流,写图片
        OutputStream out = socket.getOutputStream();

        //3.使用自己流对象,读取图片数据源
        FileInputStream fis = new FileInputStream("c:\\4.jpg");
        //3.1读写字节数组
        int len = 0;
        byte[] bytes = new byte[1024];
        while ((len = fis.read(bytes))!= -1){
            //写
            out.write(bytes,0,len);
        }
        /**因为read()方法当读取完毕但没有到末尾会造成阻塞
         * 所以需要给服务器写终止序列
         */
        socket.shutdownOutput();

        //5.获取字节输入流,读取服务器发回来的上传成功
        InputStream in = socket.getInputStream();
        len = in.read(bytes);
        System.out.println(new String(bytes,0,len));

        //6.关闭资源
        fis.close();
        socket.close();
    }
}
