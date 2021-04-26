package cn.itcast.demo09;

import java.io.File;

/*
 * File类
 *  File对象操作系统内容
 *  File与系统无关,能够适应windows和linux
 */
public class FileDemo {
    public static void main(String[] args) {
        //File fp = new File();
        /*File的静态成员变量
        * 与系统有关的分隔符: pathSeparator
        * 与系统有关的名称分隔符 separator
        * */
        String se = File.pathSeparator;
        System.out.println(se); // ;

        se = File.separator;
        System.out.println(se); // \
    }
}
