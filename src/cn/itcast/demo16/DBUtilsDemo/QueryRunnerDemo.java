package cn.itcast.demo16.DBUtilsDemo;

import cn.itcast.demo15.JDBCUtils.JDBCUtilsDemo;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @program: HelloWorld
 * @description: 使用QueryRunner类,实现对数据表的增删改
 * update(Connection con,String sql,Object...param)
 * Object...param --- 可变参数Object类型,sql语句出现？占位符
 * 数据库连接对象使用自定义的工具类传递进来
 * @author: Mr.Huang
 * @create: 2021-05-15 21:11
 **/

public class QueryRunnerDemo {
    private static Connection con = JDBCUtilsDemo.getConnection();
    //1.创建QueryRunner类对象
    public static QueryRunner qr = new QueryRunner();
    public static void main(String[] args) throws Exception{
        //insert();
        update();
    }
    /**
     * @Description: 定义方法,使用QueryRunner类的方法update向数据表添加数据
     * @Param:
     * @return:
     * @Author: Mr.Huang
     * @Date: 2021/5/15
     *
     */
    public static void insert() throws SQLException {

        String sql = "INSERT INTO zhangwu (id,zname,zmoney) VALUES (?,?,?)";

        // 将三个？占位符的实际参数写在数组中
        Object[] params = {9,"体育用品",289.32};

        //2.调用QueryRunner类方法update
        int row = qr.update(con,sql,params);
        System.out.println(row);

        DbUtils.closeQuietly(con);
    }
    
    /**
     * @Description: 定义方法,使用QueryRunner类的方法update向数据表修改数据
     * @Param: 
     * @return: 
     * @Author: Mr.Huang
     * @Date: 2021/5/15
     */
    public static void update() throws SQLException{
        String sql = "UPDATE zhangwu SET zname=?,zmoney=? WHERE id=?";

        //定义数组存储占位符参数
        Object[] params = {"买游戏币支出",23.2,7};

        //2.调用QueryRunner类方法update
        int row = qr.update(con,sql,params);
        System.out.println(row);

        DbUtils.closeQuietly(con);
    }
}
