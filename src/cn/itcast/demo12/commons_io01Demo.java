package cn.itcast.demo12;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * @program: HelloWorld
 * @description: FileUtils工具类
 * @author: Mr.Huang
 * @create: 2021-05-11 23:54
 **/

public class commons_io01Demo {
    public static void main(String[] args) {

    }

    /**
     * @Description: FileUtils工具类的方法
     * static String readFileToString(File src) 读取文本内容,返回字符串
     * @Param:
     * @return:
     * @Author: Mr.Huang
     * @Date: 2021/5/11
     */
    public static void fuc() throws IOException{
        String s = FileUtils.readFileToString(new File("c:\\a.txt"));//文件存在
        System.out.println(s);
    }

    /**
     * @Description: FileUtils工具类的方法
     * static void writeStringToFile(File src,String date) 将字符串写到文件中
     * @Param:
     * @return:
     * @Author: Mr.Huang
     * @Date: 2021/5/11
     */
    public static void fuc1() throws IOException{
        FileUtils.writeStringToFile(new File("c:\\b.txt"),"我爱...");
    }
    
    /**
     * @Description: FileUtils工具类的方法
     * static void copyFile(File src,File desc)
     * 复制文件
     * @Param:
     * @return: 
     * @Author: Mr.Huang
     * @Date: 2021/5/12
     */
    public static void fuc2() throws IOException{
        FileUtils.copyFile(
                new File("c:\\k.jpg"),
                new File("d:\\k.jpg"));

    }

    /**
     * @Description: FileUtils工具类的方法
     * static void copyDirectoryToDirectory(File src,File desc)
     * 复制文件夹
     * @Param:
     * @return:
     * @Author: Mr.Huang
     * @Date: 2021/5/12
     */
    public static void fuc3() throws IOException{
        FileUtils.copyDirectoryToDirectory(
                new File("d:\\demo"),new File("c:\\")
        );
    }

}
