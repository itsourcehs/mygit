package cn.itcast.demo15.JDBCUtils;

import cn.itcast.demo15.JDBCUtils.domain.ZhangWu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: HelloWorld
 * @description: JDBC读取数据表zhangwu,将每行数据封装到ZhangWu类的对象中
 * 很多个ZhangWu对象,存储到List集合
 * @author: Mr.Huang
 * @create: 2021-05-15 13:30
 **/

public class JDBCUtilsDemo1 {
    public static void main(String[] args) throws Exception {
        //1.使用JDBC工具类,直接获取数据库连接对象
        Connection con = JDBCUtilsDemo.getConnection();
        //2.使用连接对象获取数据库语句执行对象
        String sql = "SELECT * FROM zhangwu";
        PreparedStatement pst = con.prepareStatement(sql);

        //3.获得结果集
        ResultSet rs = pst.executeQuery();

        //创建集合对象
        List<ZhangWu> list = new ArrayList<ZhangWu>();
        //结果集处理
        while (rs.next()){
            //获取到每列数据,封装到ZhangWu对象中
            ZhangWu zw = new ZhangWu(rs.getInt("id"),
                    rs.getString("zname"),
                    rs.getDouble("zmoney"));
            //将封装的对象存储到集合中
            list.add(zw);
        }
        //遍历集合
        for(ZhangWu list_ele : list){
            System.out.println(list_ele);
        }
        //关闭
        JDBCUtilsDemo.close(con,pst,rs);
    }
}
