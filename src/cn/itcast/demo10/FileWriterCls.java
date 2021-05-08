package cn.itcast.demo10;

import java.io.FileWriter;
import java.io.IOException;

/*
 * io 下 Writer类 所有字符输出流的超类 -- 子类 FileWriter
 * 写文本文件,必须要运行一个方法,flush()
 * write()
 *  write(int c) 写一个字符
 *  write(char[] c) 写字符数组
 *  write(char[] c ,int ,int) 字符数组的一部分,开始索引,写几个
 *  write(String s) 写入字符串
 */
public class FileWriterCls {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("c:\\a.txt");

        //写一个字符
        fw.write(100);
        fw.flush();

        //写一个字符数组
        char[] c = {'a','b','c','d','e'};
        fw.write(c);
        fw.flush();

        //写字符数组的一部分
        fw.write(c,2,2);
        fw.flush();

        //写字符串
        fw.write("hello");
        fw.flush();

        //关闭资源
        fw.close();
    }
}
