package cn.itcast.demo12;

import java.io.*;
import java.util.Arrays;

/**
 * @program:  打印流: PrintStream PrintWriter
 * 打印流的特点: 1.该流不负责数据源,只负责数据目的 2.为其他输出流添加功能
 * 上面两个打印流的方法完全一致,构造方法 : 打印流的输出目的端
 * @description:
 * @author: Mr.Huang
 * @create: 2021-05-11 22:30
 **/

public class PrintWriterDemo {
    public static void main(String[] args) {
        
    }
    
    /**
     * @Description: 打印流,向File对象的数据目的写入数据
     * 方法: print println 原样输出
     * write方法走ASCll码表
     * @Param: 
     * @return: 
     * @Author: Mr.Huang
     * @Date: 2021/5/11
     */
    public static void fuc1() throws FileNotFoundException {
        File f = new File("c:\\1.txt");
        PrintWriter pw = new PrintWriter(f);
        pw.println(100);
        pw.write(100);
        pw.close();
    }
    
    /**
     * @Description: 打印流,输出目的,String文件名
     * @Param: 
     * @return: 
     * @Author: Mr.Huang
     * @Date: 2021/5/11
     */
    public static void fuc2() throws FileNotFoundException{
        PrintWriter pw = new PrintWriter("c:\\2.txt");
        pw.println(3.5);
        pw.close();
    }

    /**
     * @Description: 打印流,输出目的,是流对象
     * 可以是字节输出流,也可以是字符输出流
     * OutputStream Writer
     * @Param:
     * @return:
     * @Author: Mr.Huang
     * @Date: 2021/5/11
     */
    public static void fuc3() throws IOException{
//        FileOutputStream fos = new FileOutputStream("c:\\3.txt");
        FileWriter fw = new FileWriter("c:\\4.txt");
        PrintWriter pw = new PrintWriter(fw);
        pw.println("打印流");
        pw.close();
    }

    /**
     * @Description: 打印流可以开启自动刷新
     * 必须满足两个条件才能自动刷新 1.输出的数据必须是流对象,不能是file,String等其他对象
     * 2.必须调用println,printf,format三个方法中的其中一个
     * @Param:
     * @return:
     * @Author: Mr.Huang
     * @Date: 2021/5/11
     */
    public static void fuc4() throws IOException{
//        File f = new File("xxx.txt");
        FileOutputStream fos = new FileOutputStream("c:\\5.txt");
        PrintWriter pw = new PrintWriter(fos,true);

        pw.println("i");
        pw.println("love");
        pw.println("java");

        pw.close();
    }
}
