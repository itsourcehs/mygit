package cn.itcast.demo15;

import java.sql.*;
import java.util.Scanner;

/**
 * @program: HelloWorld
 * @description: java程序实现用户登录,用户名和密码,数据库检查,
 * 防止注入攻击:
 *  Statement接口的实现类,作为执行SQL语句,返回结果集
 *  它有一个子接口PreparedStatement (SQL预编译存储,多次高效的执行SQL)
 *  PreparedStatement的实现类数据库的驱动中,如何获取接口的实现类
 *
 *  Connection数据库连接对象的方法:  PreparedStatement preparedStatement(String sql)
 * @author: Mr.Huang
 * @create: 2021-05-15 12:39
 **/

public class JDBCDemo2 {
    public static void main(String[] args) throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/mybase";
        String username = "root";
        String password = "root";
        Connection cn = DriverManager.getConnection(url,username,password);

        //Statement stat =  cn.createStatement();下面更好的实现方式

        Scanner sc = new Scanner(System.in);
        String user  = sc.nextLine();
        String pass = sc.nextLine();

        //执行SQL语句,数据表,查询用户名和密码,如果存在,登录成功,不存在则登录失败
        String sql = "SELECT * FROM zhangwu WHERE username=? AND PASSWORD=?";
        /**Connection数据库连接对象的方法:  PreparedStatement preparedStatement(String sql)
         * 方法中参数,SQL语句中的参数全部采用？占位符
         */
        PreparedStatement pst = cn.prepareStatement(sql);
        System.out.println(sql);
        //调用pst对象方法set,设置问号占位符上的参数
        pst.setObject(1,user);
        pst.setObject(2,pass);
        //调用方法执行SQL,获取结果集 不再需要传入sql 上面已经预编译好了
        ResultSet rs = pst.executeQuery();
        while (rs.next()){
            System.out.println(rs.getString("username")+"  "+
                    rs.getString("password"));
        }
    }
}
