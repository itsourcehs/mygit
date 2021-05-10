package cn.itcast.demo11;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @program: HelloWorld
 * @description: 字节输入流的缓冲流
 * java.io.BuffedInputStream - 继承于InputStream
 * 方法: read() 读取单个字节,读取字节数组
 * BuffedInputStream 的构造方法: 传递任意的字节输入流,传谁就对谁提高效率
 * @author: Mr.Huang
 * @create: 2021-05-09 23:09
 **/

public class BuffedInputStreamDemo {
    public static void main(String[] args) throws IOException {
        // 创建字节输入流的缓冲流对象,构造方法中传入字节输入流,包装文件
        BufferedInputStream bis = new
                BufferedInputStream(new FileInputStream("c:\\buffer.txt"));

        // 以字节数组的形式读取文件
        byte[] bytes = new byte[10];
        int len = 0;
        while ((len = bis.read()) != -1){
            System.out.print(new String(bytes,0,len)); //调用String构造方法将字符数组转为字符串
        }
        // 关闭外层缓冲流
        bis.close();
    }


}
