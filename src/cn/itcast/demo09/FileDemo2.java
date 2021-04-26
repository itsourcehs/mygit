package cn.itcast.demo09;

import java.io.File;
import java.io.IOException;

/*
 * File类创建和删除功能 文件或目录 createNewFile
 * 文件已存在,返回false
 *
 * File创建文件夹 mkdir()
 * mkdirs() ----> 创建多层目录,推荐使用
 * 文件已存在,返回false
 *
 * File删除文件或者文件夹 delete()
 * 删除成功返回true 删除失败返回false
 * 删除后,不走回收站,直接从硬盘删除
 */
public class FileDemo2 {
    public static void main(String[] args) {

    }
    public static void fuc() throws IOException {
        File fp = new File("c:\\a.txt");
        boolean b = fp.createNewFile();
        System.out.println(b); // true
    }

    public static void fuc1(){
        File fp = new File("c:\\abc");
        boolean b = fp.mkdir();
        System.out.println(b); // true
    }

    public static void fuc2(){
        File fp = new File("c:\\abc");
        boolean b = fp.delete();
        System.out.println(b);
    }





}
