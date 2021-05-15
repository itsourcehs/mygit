package cn.itcast.demo17.JDBCUtilsDemo;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;

import java.awt.*;
import java.sql.SQLException;
import java.util.List;

/**
 * @program: HelloWorld
 * @description: 测试写好的工具类
 * 提供的是一个DataSource接口的数据源
 * QueryRunner构造方法 --- QueryRunner(DataSource ds)
 *      接收DataSource接口的实现类
 *      然后调用方法update(),query(),无需传递Connection连接对象
 * @author: Mr.Huang
 * @create: 2021-05-16 00:36
 **/

public class QueryRunnerDemo {
    private static QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());

    public static void main(String[] args) {
        //insert();
        select();
    }

    /**
     * @Description: 对于数据表添加数据
     * @Param:
     * @return:
     * @Author: Mr.Huang
     * @Date: 2021/5/16
     */
    public static void insert(){
        String sql = "INSERT INTO zhangwu (zname,zmoney) VALUES (?,?)";
        Object[] params = {"水果",100.12};
        try {
            int row = qr.update(sql, params);
            System.out.println(row);
        }catch (SQLException ex){
            System.out.println(ex);
            throw new RuntimeException("数据库添加失败");
        }
    }

    /**
     * @Description: 数据查询
     * @Param:
     * @return:
     * @Author: Mr.Huang
     * @Date: 2021/5/16
     */
    public static void select() {
        String sql = "SELECT * FROM zhangwu";
        try {
            List<Object[]> list = qr.query(sql, new ArrayListHandler());

            for (Object[] objs : list) {
                for (Object obj : objs) {
                    System.out.print(obj+"\t");
                }
                System.out.println();
            }
        }catch (SQLException ex){
            System.out.println(ex);
            throw new RuntimeException("数据查询失败");
        }
    }

}
