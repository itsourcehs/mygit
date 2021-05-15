package cn.itcast.demo15;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @program: HelloWorld
 * @description: JDBC操作数据库的步骤
 * 1.注册驱动
 *  告知JVM使用的是哪一个数据库的驱动 -- jar包处理 - 选中jar包右键Add as Library
 * 2.获取链接
 *  使用JDBC中的类,完成对mysql数据库的链接
 * 3.获得语句执行平台
 *  通过链接对象获取对sql语句的执行者对象
 * 4.执行sql语句
 *  使用执行者对象,向数据库执行sql语句
 *  获取到数据库的执行后结果
 * 5.处理结果
 * 6.释放资源 -- - close()
 *
 * @author: Mr.Huang
 * @create: 2021-05-15 00:54
 **/

public class JDBCDemo {
    public static void main(String[] args) throws ClassNotFoundException,SQLException {
        /**1.注册驱动：最好的办法是采用反射技术,将驱动类加入到内存中
         * java.sql.DriverManager静态方法registerDriver(Driver driver)
         * Driver是个接口,参数传递,MySQL驱动程序中的实现类
         * DriverManager.registerDriver(new Driver());
         */
         Class.forName("com.mysql.jdbc.Driver");

        /**2.获得数据库的连接
         * java.sql.DriverManager静态方法getConnection(String url,String user,String password)
         * 返回为Connection接口的实现类,在mysql驱动程序中
         * url: jdbc:mysql://主机ip:3306/数据库名
         */
        String url = "jdbc:mysql://localhost:3306/mybase";
        String username = "root";
        String password = "root";
        Connection cn = DriverManager.getConnection(url,username,password);

        /**System.out.println(cn); com.mysql.jdbc.JDBC4Connection@30946e09*/

        /**3.获取到sql语句的执行者对象
         * cn对象调用方法 createStatement() -- 方法返回Statement接口的实现类对象
         * 获取Statement对象,将sql语句发送到数据库
         */
        Statement stat =  cn.createStatement();

        /**4.执行sql语句
         * 通过执行者对象调用方法执行sql语句,获取结果
         * executeUpdate(String sql) -- 返回 int,此方法只能用于执行insert update delete
         */
        String sql = "INSERT INTO zhangwu ( id,zname,zmoney)\n" +
                "VALUES\n" +
                "\t(8, '服装支出', 1000 )";
        int row = stat.executeUpdate(sql);
        System.out.println(row);

        /**6.释放资源 -- - close()*/
        stat.close();
        cn.close();
    }
}
