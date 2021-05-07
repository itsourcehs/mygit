package cn.itcast.demo10;

import java.io.FileInputStream;
import java.io.IOException;

/*
 * FileInputStream读取文件
 *  读取方法 int read(byte[] b) 读取字节数组
 *  数组作用 : 缓冲的作用 提高效率
 *  read返回int的含义: 读取到多少个有效的字节数
 */
public class InputStreamDemo01 {
    public static void main(String[] args) throws IOException {
        //1.创建字节输入流的子类对象
        FileInputStream fis = new FileInputStream("README.txt");
        //2.创建字节数组
        byte[] b = new byte[1024]; // 1k写法
        //3.定义变量接收read方法的返回值
        int len = 0;

        //4.使用循环的方式读取文件,循环结束的条件 方法返回-1时结束
        while ((len = fis.read(b)) != -1){
            //字符串构造方法 将字节
            System.out.print(new String(b,0,len));
        }
        //5.关闭资源
        fis.close();
    }
}
/***
 *         int len = fis.read(b);
 *         System.out.println(new String(b));
 *         System.out.println(len);
 *
 *         int len = fis.read(b);
 *         System.out.println(new String(b));
 *         System.out.println(len);
 *
 *         int len = fis.read(b);
 *         System.out.println(new String(b));
 *         System.out.println(len);
 *
 *         int len = fis.read(b);
 *         System.out.println(new String(b));
 *         System.out.println(len);
 **/