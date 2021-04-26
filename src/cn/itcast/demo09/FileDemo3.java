package cn.itcast.demo09;

import java.io.File;

/*
 * File类的获取功能
 */
public class FileDemo3 {
    public static void main(String[] args) {
        fuc();
    }

    /*
     * String getName()
     * 返回路径中便是的文件或文件名
     * 获取路径中的最后部分的名字
     */
    public static void fuc(){
        File fp = new File("d:\\Dnf网盘辅助文件.txt");
        String name =fp.getName();
        System.out.println(name);
    }

    /*
     * long length()
     * 返回路径中表示的文件的字节数
     */
    public static void fuc1(){

    }
    /*
     * String getAbsoutePath()
     * File getAbsoluteFile() 推荐使用 返回File对象
     */
}
