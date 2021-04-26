package cn.itcast.demo09;

import java.io.File;

/*
 * 三种重载形式
 * 掌握
 */
public class FileDemo1 {
    public static void main(String[] args) {
        fuc1(); // c:\windows
        fuc2();
    }

    /*
     * File(String pathname)
     * 将路径封装成File类型对象
     */
    public static void fuc(){
        File fp = new File("C:\\Users\\Administrator\\IdeaProjects\\HelloWorld\\README.txt");
        System.out.println(fp);
    }

    /*
     * File(String parent,String child)
     * 字符串的父路径 字符串的子路径
     */
    public static void fuc1(){
        File fp = new File("c:","windows");
        System.out.println(fp);
    }

    /*
     * File(File parent,String child)
     * 字符串的父路径 字符串的子路径
     */
    public static void fuc2(){
        File parent = new File("d:");
        File fp = new File(parent,"eclipse");
        System.out.println(fp);
    }







}
