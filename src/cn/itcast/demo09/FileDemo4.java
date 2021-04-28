package cn.itcast.demo09;

import java.io.File;

/*
 * 文件过滤器
 * 遍历目录的时候,只获取满足条件的文件
 * 遍历目录方法 listFiles() 重载形式
 * listFiles(FileFilter filter)接口类型
 * 参数传递 FileFilter接口的实现类 ---自己写
 */
public class FileDemo4 {
    public static void main(String[] args) {
    File fp = new File("c:\\demo");
    File[] files = fp.listFiles(new MyFilter());
    for(File f : files){
        System.out.println(f);
        }

    }

    public FileDemo4(){
        //FileDemo4(); //Method call expected
    }
}
