package cn.itcast.demo10;

import java.io.FileInputStream;
import java.io.IOException;

/*
 * 字节输入流
 * java.io.InputStream 所有字节输入流的超类
 * 读取的方法:
 *  int read() 读取一个字节
 *  int read(byte[] b) 读取一定量的字节,存储到数组中
 *
 * InputStream 的子类 FileInputStream
 * FileInputStream 的构造方法: 为这个流对象绑定数据源
 *  参数: File 类型对象
 *       String 对象
 * 输入流读取文件的步骤
 *  1.创建字节输入流的子类对象
 *  2.调用读取方法read读取
 *  3.关闭资源
 *
 *  read()方法
 *      此方法每执行一次,就会自动读取下一字节
 *      返回值,返回的是读取到的字节,读取到结尾返回-1
 */
public class InputStreamDemo {
    public static void main(String[] args) throws IOException {
        //1.创建字节输入流的子类对象
        FileInputStream fis = new FileInputStream("README.txt");
        /*2.调用读取方法read读取
        int i = fis.read();
        System.out.println((char) i);
        System.out.println(i);

         */

        /*定义变量接收read方法的返回值
        * 使用循环的方式读取文件,循环结束的条件 方法返回-1时结束
        * */
        int len = 0;
        while ((len = fis.read()) != -1){
            System.out.print((char) len);
        }
        //3.关闭资源
        fis.close();
    }
}
/******
 * 多个read方法读取文件的方式并不可行
 * int i = fis.read();
   System.out.println(i);

   i = fis.read();
   System.out.println(i);

   i = fis.read();
   System.out.println(i);
 */
