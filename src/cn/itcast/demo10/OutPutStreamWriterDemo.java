package cn.itcast.demo10;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/*
 * java.io.OutPutStreamWriter 继承 writer类
 * 字符输出流,写文本文件
 * write()  字符,字符数组,字符串
 *
 * 字符 ---> 字节 的桥梁 将字符流转为字节流
 *
 * OutPutStreamWriter使用方法
 *  构造方法:
 *      OutPutStreamWriter(OutputStream out)接收所有的字节输出流
 *      字节输出流为: FileOutputStream
 *
 *      OutPutStreamWriter(OutputStream out,String charsetName) 第二个参数传递编码表名字 GBK UTF-8
 * OutputStream out -- 子类 FileWriter
 *
 * 当需要更改文件编码时,需使用转换流,否则就使用子类
 */
public class OutPutStreamWriterDemo {
    public static void main(String[] args) {

    }

    /*
     * 转换流对象 OutputStreamWriter写文本
     * 文本采用GBK的形式写入
     */
    public static void writrGBK() throws IOException{
        // 1.创建字节输出流,绑定数据文件
        FileOutputStream fos = new FileOutputStream("c:\\gbk.txt");
        // 2.创建转换流对象,构造方法绑定字节输出流使用GBK编码表
        OutputStreamWriter osw = new OutputStreamWriter(fos);
        // 3.转换流写数据
        osw.write("你好");
        // 4.关闭资源,只需要关闭外层流对象 osw
        osw.close();
    }

    /*
     * 转换流对象 OutputStreamWriter写文本
     * 文本采用UTF-8编码表的形式写入
     */
    public static void writrUTF() throws IOException{
        // 1.创建字节输出流,绑定数据文件
        FileOutputStream fos = new FileOutputStream("c:\\utf.txt");
        // 2.创建转换流对象,构造方法绑定字节输出流,并指定使用UTF-8编码表
        OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");
        // 3.转换流写数据
        osw.write("你好");
        // 4.关闭资源,只需要关闭外层流对象 osw
        osw.close();
    }
}
