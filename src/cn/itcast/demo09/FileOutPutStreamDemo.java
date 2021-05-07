package cn.itcast.demo09;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * FileOutPutStream构造方法
 * 参数: File 封装文件
 * String 字符串的文件名
 * 流对象使用步骤:
 * 创建流子类对象,绑定数据目的(如果文件存在将会直接覆盖,不存在将会新建)
 * 调用流方法write写
 * close释放资源
 */
public class FileOutPutStreamDemo {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new
                FileOutputStream("C:\\Users\\Administrator\\IdeaProjects\\HelloWorld\\README.txt");
        //流对象方法write输出数据到文件
        //写一个字节
        //fos.write(100);

        //写字节数组
        byte[] bytes = {65,66,67,68};
        //fos.write(bytes);

        /*写字符串 使用String类方法getBytes
        将字符串转换为字节数组,需要查询编码表
         */
        fos.write("hello".getBytes());

        //关闭资源
        fos.close();
    }
}
