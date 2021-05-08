package cn.itcast.demo10;

import java.io.FileReader;
import java.io.IOException;

/*
 * io 下 Reader 所有字符输入流的超类  专门读取文本文件
 * read()
 *  int read() 读取一个字符
 *  int read(char[] c) 读取字符数组
 * Reader -- 子类 FileReader
 *
 * 构造方法: 绑定数据源
 *  参数: File 类型对象  String 文件名
 */
public class FileReaderCls {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("c:\\a.txt");
        /*
        int len = 0;
        while ((len = fr.read()) != -1){
            System.out.print((char) len);

         */
        //读取字符数组
        char[] ch = new char[1024*10];
        int len = 0;
        while ((len = fr.read(ch)) != -1){
            System.out.println(new String(ch,0,len)); //
        }

        fr.close();
    }
}
