package cn.itcast.demo15;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * @program: HelloWorld
 * @description: 实现加载properties配置文件
 * IO读取文件,键值对存储到集合
 * 从集合中以键值对方式获取数据库的连接信息,完成数据库的连接
 * @author: Mr.Huang
 * @create: 2021-05-15 14:07
 **/

public class PropertiesDemo {
    public static void main(String[] args) throws Exception{
        /*FileInputStream fis = new FileInputStream("db.properties");
        System.out.println(fis);*/

        //有效方法,采用类的加载器 返回InputStream类型的字节输入流
        InputStream in = PropertiesDemo
                .class
                .getClassLoader()
                .getResourceAsStream("db.properties");
        System.out.println(in);
        Properties pro = new Properties();
        pro.load(in);

        //获取集合中的键值对
        String driverClass = pro.getProperty("driverClass");
        String url = pro.getProperty("url");
        String username = pro.getProperty("username");
        String password = pro.getProperty("password");

        Class.forName(driverClass);
        Connection con = DriverManager.getConnection(url,username,password);
        System.out.println(con);
    }
}
