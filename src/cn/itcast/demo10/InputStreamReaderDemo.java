package cn.itcast.demo10;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * java.io.OutPutStreamWriter 继承 writer类
 * 字符输入流,读取文本文件
 * 字节 ---> 字符 的桥梁 将字节流转为字符流
 *
 * 读取的方法:
 *  read() 读取一个字符,读取字符数组
 *
 * OutputStreamWriter写文件,InputStreamReader读取文件
 *
 * InputStreamReader(InputStream in)接收所有的字节输入流
 *  字节输入流: FileInputStream
 * InputStreamReader(InputStream in,String charsetName) 第二个参数传递编码表名字
 *
 * 当需要更改文件编码时,需使用转换流,否则就使用子类
 */
public class InputStreamReaderDemo {
    public static void main(String[] args) {

    }
    /*
     * 转换流 InputStreamReader读取文件
     * 采用系统默认编码表,读取GBK文件
     */
    public static void readGBK() throws IOException {
        // 1.创建字节输入流,传递文本文件
        FileInputStream fis = new FileInputStream("c:\\gbk.txt");
        // 2.创建转换流对象,构造方法包装字节输入流
        InputStreamReader isr = new InputStreamReader(fis);
        // 3.读取文件,采用字符数组
        char[] ch = new char[1024];
        int len = isr.read(ch);
        System.out.println(new String(ch,0,len));
        // 4.关闭外层流资源
        isr.close();
    }

    /*
     * 转换流 InputStreamReader读取文件
     * 采用UTF-8编码表,读取utf文件
     */
    public static void readUTF() throws IOException{
        // 1.创建字节输入流,传递文本文件
        FileInputStream fis = new FileInputStream("c:\\utf.txt");
        // 2.创建转换流对象,构造方法包装字节输入流,同时指定编码表
        InputStreamReader isr = new InputStreamReader(fis,"UTF-8");
        // 3.读取文件,采用字符数组
        char[] ch = new char[1024];
        int len = isr.read(ch);
        System.out.println(new String(ch,0,len));
        // 4.关闭外层流资源
        isr.close();
    }
}
