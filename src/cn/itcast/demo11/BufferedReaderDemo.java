package cn.itcast.demo11;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @program: HelloWorld
 * @description: 字符输入流缓冲流
 * java.io.BufferedReader - 继承于Reader
 * 方法: read() 读取单个字符,字符数组
 * 它的构造方法: 可以传递任意的字符输入流
 *  FileReader InputStreamReader
 *  自己特有的功能: String readLine() 读取文本行
 *  该方法读取到流末尾,返回null   readLine()方法返回的有效字符,没有\r\n
 * @author: Mr.Huang
 * @create: 2021-05-10 09:11
 **/

public class BufferedReaderDemo {
    public static void main(String[] args) throws IOException {
        int lineNumber = 0;
        //创建字符输入流缓冲流对象,构造方法传递字符输入流,包装文件
        BufferedReader bfr = new
                BufferedReader(new FileReader("c:\\a.txt"));
        //调用readLine,循环读取文本行,结束条件 readLine()返回null
        String line = null;
        while ((line = bfr.readLine()) != null){
            lineNumber++;
            System.out.println(lineNumber+" "+line);
        }
        bfr.close();
    }
}
