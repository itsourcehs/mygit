package cn.itcast.demo11;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @program: HelloWorld
 * @description: 字节输出流的缓冲流
 * java.io.BuffedOutputStream 用于提高原有输出流的写入效率,BuffedOutputStream继承于OutputStream
 * 方法: 写入字节,写入字节数组
 * BuffedOutputStream 构造方法: 可以传递任意的字节输出流,传那个就对那个字节流提高效率
 * @author: Mr.Huang
 * @create: 2021-05-09 22:44
 **/

public class BuffedOutputStreamDemo {
    public static void main(String[] args)  throws IOException {
        // 1.创建字节输出流,绑定文件,传入字节输出流缓冲流对象的构造方法中
        BufferedOutputStream bos = new
                BufferedOutputStream(new FileOutputStream("c:\\buffer.txt"));

        // 2.写一个字节
        bos.write(55); // 7

        // 3.写字节数组,调用字符串方法将字符串转为字节数组
        byte[] bytes = "helloworld".getBytes();
        bos.write(bytes);

        bos.write(bytes,3,2); //从字节数组索引3开始写2个

        // 4.关闭外层缓冲流
        bos.close();

    }
}
