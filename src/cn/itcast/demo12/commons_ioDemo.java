package cn.itcast.demo12;

import org.apache.commons.io.FilenameUtils;

/**
 * @program: HelloWorld
 * @description: io工具类 FilenameUtils
 * @author: Mr.Huang
 * @create: 2021-05-11 23:14
 **/

public class commons_ioDemo {
    public static void main(String[] args) {

    }

    /**
     * @Description: FilenameUtils类的方法
     * static boolean isExtension(String filename,String extension)
     * 判断文件名的后缀是不是extension
     * @Param:
     * @return:
     * @Author: Mr.Huang
     * @Date: 2021/5/11
     */
    public static void fuc2(){
        boolean b = FilenameUtils.isExtension("demo.java","java");
        System.out.println(b);
    }

    /**
     * @Description: FilenameUtils类的方法
     * static String getName(String filename)
     * 获取文件名
     * @Param:
     * @return:
     * @Author: Mr.Huang
     * @Date: 2021/5/11
     */
    public static void fuc1(){
        String name = FilenameUtils.getName("c:\\windows\\");
        System.out.println(name);
    }

    /**
     * @Description: FilenameUtils类的方法
     * static String getExtension(String filename)
     * 获取文件名的扩展名
     * @Param:
     * @return:
     * @Author: Mr.Huang
     * @Date: 2021/5/11
     */
    public static void fuc(){
        String name = FilenameUtils.getExtension("c:\\windows");
        System.out.println(name);
    }
}
