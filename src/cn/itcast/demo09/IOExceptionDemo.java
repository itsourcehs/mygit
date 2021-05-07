package cn.itcast.demo09;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * IO流的异常处理
 * 细节:
 *  1.保证流对象变量,作用域足够
 *  2.catch里面,怎么处理异常
 *      2.1 输入异常信息 getMessage
 *      2.2 停下程序,重新尝试 throw new RuntimeException
 * 3.如果流对象创建失败了
 *      3.1 new对象的时候失败了,没有占用系统资源,不需要关闭
 *      3.2 释放资源的时候,判断流对象是否为null
 *          3.1 流对象不是null,成功创建了对象,需要关闭资源
 *
 */
public class IOExceptionDemo {
    public static void main(String[] args) {
        FileOutputStream fos = null;
        try{
            new FileOutputStream("s:\\a.txt");
            fos.write(100);
        }catch (IOException ex ){
            System.out.println(ex);
            // 停下程序,重新尝试
            throw new RuntimeException("文件写入失败,请重试");
        }
        finally {
            try{
                if(fos!=null)
                    fos.close();
            }catch (IOException ex){
                System.out.println(ex);
                throw new RuntimeException("关闭资源失败");
            }
        }
    }
}
