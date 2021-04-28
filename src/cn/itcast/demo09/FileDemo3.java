package cn.itcast.demo09;

import java.io.File;

/*
 * File类的获取功能
 */
public class FileDemo3 {
    public static void main(String[] args) {
        fuc2();
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


    /*
     * File类获取功能补充
     * String list 获取路径中的文件和文件夹名,返回String类型的数组
     * File listFiles 和上面方法一样,返回一个File类型的数组
     */
    public static void fuc2(){
        File fp = new File("c:\\");
        /*String[] strArr = fp.list();
        for(String str : strArr){
            System.out.println(str);
        }

         */

        /*
         * File listFiles 常用
         */
        File[] file = fp.listFiles();
        for(File f : file){
            System.out.println(f);
        }

    }
}
