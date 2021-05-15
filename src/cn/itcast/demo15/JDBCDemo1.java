package cn.itcast.demo15;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @program: HelloWorld
 * @description: 查询数据表获取结果集
 * @author: Mr.Huang
 * @create: 2021-05-15 01:42
 **/

public class JDBCDemo1 {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/mybase";
        String username = "root";
        String password = "root";
        Connection cn = DriverManager.getConnection(url,username,password);

        Statement stat =  cn.createStatement();

        String sql = "SELECT * FROM zhangwu";

        /**执行查询语句 executeQuery(String sql) --
         * 返回ResultSet接口的实现类,实现类在mysql驱动中
         */
        ResultSet rs = stat.executeQuery(sql);

        /**
         * 处理结果集
         * ResultSet接口方法 boolean next() 返回
         * true,有结果集 返回false没有结果集
         */
        while (rs.next()){
            //获取每列数据,使用ResultSet接口方法getXXX
            System.out.println(rs.getInt("id")+"  "+
                    rs.getString("zname")+"  "+
                    rs.getDouble("zmoney"));
        }

        //
        rs.close();
        stat.close();
        cn.close();
    }
}
