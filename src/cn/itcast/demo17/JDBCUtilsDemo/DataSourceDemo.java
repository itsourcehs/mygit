package cn.itcast.demo17.JDBCUtilsDemo;

import org.apache.commons.dbcp.BasicDataSource;

import java.sql.Connection;

/**
 * @program: HelloWorld
 * @description: 连接池包中,BasicDataSource类 - 该实现类实现了数据源的规范接口 javax.sql.DataSource
 * @author: Mr.Huang
 * @create: 2021-05-16 00:01
 **/

public class DataSourceDemo {
    public static void main(String[] args) {
        //创建DataSource接口的实现类对象
        BasicDataSource dataSource =
                new BasicDataSource();
        //连接数据库的4个基本信息,通过对象方法setXX设置进来
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/mybase");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        try {
            //调用对象方法getConnection获取数据库的连接
            Connection con = dataSource.getConnection();
            System.out.println(con);
        }catch (Exception ex){
            ex.printStackTrace(); //给自己开发看的问题所在
            throw new RuntimeException("数据库连接失败"); //展示给用户看
        }
    }
}
