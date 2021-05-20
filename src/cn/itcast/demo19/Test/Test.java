package cn.itcast.demo19.Test;

import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @program: HelloWorld
 * @description:
 * 调用Person方法,调用Student方法,调用Worker方法
 * 类不清楚,方法也不清楚
 * 通过配置文件实现此功能
 *  运行的类名和方法名,以键值对的形式写在文本中
 *  执行哪个类,读取配置文件即可
 *  实现步骤:
 *     1.准备配置文件,键值对
 *     2.IO流读取配置文件 Reader
 *     3.文件中的键值对存储到集合中 Properties
 *      集合保存的键值对,就是类名和方法名
 *     4.反射获取指定类的class文件对象
 *     5.class文件对象获取指定的方法
 *     6.运行方法
 * @author: Mr.Huang
 * @create: 2021-05-18 22:19
 **/

public class Test {
    public static void main(String[] args)  throws Exception{
        // 1.IO流读取配置文件
        FileReader fr = new FileReader("src/cn/itcast/demo19/Test/config.properties");
        /** 2.创建Properties集合对象
         *  2.1 调用集合对象方法load,传递流对象
         */
        Properties pro = new Properties();
        pro.load(fr);
        fr.close();

        // 3.通过键获得值
        String className = pro.getProperty("className");
        String methodName = pro.getProperty("methodName");

        // 4.反射获取指定类的class文件对象,并创建实例对象
        Class c = Class.forName(className);
        Object obj = c.newInstance();

        // 5.class文件对象获取指定的方法
        Method method = c.getMethod(methodName);

        // 6.运行方法
        method.invoke(obj);

    }
}
