package cn.itcast.demo18.TCPDemo;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

/**
 * @program: HelloWorld
 * @description: TCP图片上传服务器
 *      1.ServerSocket套接字对象,监听端口8000
 *      2.方法accept()获取客户端的连接对象
 *      3.客户端连接对象获取字节输入流,读取客户端发送过来的图片
 *      4.创建File对象,绑定上传文件夹
 *          判断文件夹是否存在,不存在则创建文件夹
 *      5.创建字节输出流,数据目的File对象所在文件夹
 *      6.字节流读取图片,字节流将图片写入到目的文件夹中
 *      7.将上传成功回写给客户端
 *      8.关闭资源
 * @author: Mr.Huang
 * @create: 2021-05-16 21:36
 **/

public class TCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8000);

        //方法accept()获取客户端的连接对象
        Socket socket = server.accept();

        //客户端连接对象获取字节输入流,
        InputStream in = socket.getInputStream();

        /**创建File对象
         * 不存在则创建文件夹
         */
        File upload = new File("d:\\upload");
        if(!upload.exists())
            upload.mkdirs();

        /**防止文件同名被覆盖,重新定义文件名字
         * 规则: 域名+毫秒值+6位随机数
         *
         */
        String filename = "itcast"+System
                .currentTimeMillis()+new Random()
                .nextInt(99999)+".jpg";

        //创建字节输出流,将图片写入到目的文件夹
        FileOutputStream fos = new FileOutputStream(upload+File
                .separator+filename);

        //读写字节数组
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = in.read(bytes))!= -1){
            //写
            fos.write(bytes,0,len);
        }

        /**通过客户端连接对象获取字节输出流
         * 上传成功回写给客户端
         */
        socket.getOutputStream().write("上传成功".getBytes());

        //关闭资源
        fos.close();
        socket.close();
        server.close();

    }
}
