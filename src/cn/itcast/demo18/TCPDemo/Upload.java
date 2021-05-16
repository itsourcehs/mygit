package cn.itcast.demo18.TCPDemo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.Socket;
import java.util.Random;

/**
 * @program: HelloWorld
 * @description:
 * @author: Mr.Huang
 * @create: 2021-05-16 22:04
 **/

public class Upload implements Runnable{
    private Socket socket;

    public Upload(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try{
            //客户端连接对象获取字节输入流,
            InputStream in = socket
                    .getInputStream();

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
        }catch (Exception ex){

        }
    }
}
