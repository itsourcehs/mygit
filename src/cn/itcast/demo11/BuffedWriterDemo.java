package cn.itcast.demo11;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @program: HelloWorld
 * @description: 字符输出流缓冲流
 * java.io.BuffedWriter - 继承于Writer
 * 方法: write() 写单个字符,字符数组,字符串
 * BuffedWriter的构造方法传递任意字符输出流,传谁就提高谁的效率
 *  FileWriter，OutputStreamWriter
 *  它的特有方法: void newLine() 写换行
 *      newLine() 方法具有平台无关性
 * @author: Mr.Huang
 * @create: 2021-05-10 09:02
 **/

public class BuffedWriterDemo {
    public static void main(String[] args) throws IOException {
        //创建字符输出流,封装文件
        FileWriter fw = new FileWriter("c:\\buffer.txt");
        BufferedWriter bfw = new BufferedWriter(fw);

        bfw.write("你好");
        bfw.newLine();
        bfw.flush();

        bfw.write("你好2");
        bfw.newLine();
        bfw.flush();

        bfw.write("你好3");
        bfw.flush();

        bfw.close();
    }
}
/*
 * bfw.write("你好".toCharArray()) 字符串方法就字符串变成字符数组
 */