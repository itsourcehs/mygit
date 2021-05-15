package cn.itcast.demo17.JDBCUtilsDemo;

import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;

/**
 * @program: HelloWorld
 * @description: 使用DBCP实现数据库的连接池
 * 连接池配置,自定义类
 * 最基本四项完整
 * 对于数据库连接池其他配置均自定义
 * @author: Mr.Huang
 * @create: 2021-05-16 00:23
 **/

public class JDBCUtils {
    //创建BasicDataSource类对象
    private static BasicDataSource dataSource = new BasicDataSource();

    //定义静态方法返回BasicDataSource类对象
    public static DataSource getDataSource(){
        //有实现接口的建议方法返回接口类型,而不是实现类的类型
        return dataSource;
    }

    //静态代码块,对象BasicDataSource对象中的配置,自定义
    static {
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/mybase");
        dataSource.setUsername("root");
        dataSource.setPassword("root");

        //对连接池中的连接数量配置
        dataSource.setInitialSize(10); //初始化的连接数
        dataSource.setMaxActive(8); //最大连接数
        dataSource.setMaxIdle(5); //最大空闲数
        dataSource.setMinIdle(1); //最小空闲数
    }
}
