package cn.itcast.demo16.DBUtilsDemo;

import cn.itcast.demo15.JDBCUtils.JDBCUtilsDemo;
import cn.itcast.demo15.JDBCUtils.domain.ZhangWu;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @program: HelloWorld
 * @description: QueryRunner数据查询操作:
 *      调用QueryRunner类方法query(Connection con,String sql,ResultSetHandler r,Object..params)
 *      ResultSetHandler r --- 结果集的处理方式,传递ResultSetHanlder接口实现类
 *      Object..params --- SQL语句中的占位符
 *
 *      注意: query方法返回的是 T 泛型,具体是哪种类型取决于结果集处理方式的变化
 * @author: Mr.Huang
 * @create: 2021-05-15 22:00
 **/

public class QueryRunnerDemo1 {
    private static Connection con = JDBCUtilsDemo.getConnection();
    private static QueryRunner qr = new QueryRunner();
    private static String select_sql = "SELECT * FROM zhangwu";

    public static void main(String[] args) throws Exception {
        //ArrayHandler();
        //ArrayListHandler();
        //BeanHandler();
        //BeanListHandler();
        //ColumnListHandler();
        //ScalarHandler();
        //MapHandler();
        MapListHandler();
    }

    /**
     * 结果集的第一种处理方法,ArrayHandler
     * 将结果集的第一行存储到对象数组中 Object[]
     */
    public static void ArrayHandler() throws SQLException {
        /**调用方法query方法执行查询,
         * 传递链接对象,sql语句,结果集实现类对象
         * 返回: 对象数组
         */
        ArrayHandler ah = new ArrayHandler();
        Object[] result = qr.query(con,select_sql,ah);
        for(Object res : result){
            System.out.println(res);
        }
    }
    
    /**
     * @Description: 结果集的第二种处理方法,ArrayListHandler
     * @Param: 将结果集的每一行存储到对象数组中,将对象数组存储到List集合
     * @return: 
     * @Author: Mr.Huang
     * @Date: 2021/5/15
     */
    public static void ArrayListHandler() throws Exception{

        /**调用方法query方法执行查询,
         * 传递链接对象,sql语句,结果集实现类对象
         * 返回: List数组,数组类型是Object数组(每行记录是一个对象数组,存储到List)
         */
        ArrayListHandler alh = new ArrayListHandler();
        List<Object[]> result = qr.query(con,select_sql,alh);

        //遍历数组
        for(Object[] res : result){
            for(Object obj : res){
                System.out.print(obj+"\t");
            }
            System.out.println();
        }
    }

    /**
     * @Description: 结果集的第三种处理方法,BeanHandler
     * @Param: 将结果集的第一行封装成JavaBean对象
     * 调用方法query方法执行查询,
     * @return:
     * @Author: Mr.Huang
     * @Date: 2021/5/15
     */
    public static void BeanHandler() throws SQLException{
        /**
         * 调用方法,传递结果集实现类对象BeanHandler
         * BeanHandler(Clas<T> type)
         * 注意: 被封装成数据到JavaBean对象,ZhangWu类必须有空参构造
         */
        ZhangWu zw = qr.query(con,
                select_sql,
                new BeanHandler<ZhangWu>(ZhangWu.class));

        System.out.println(zw); //ZhangWu{id=1, zname='吃饭支出', zmoney=247.0}

    }

    /**
     * @Description: 结果集的第四种处理方法,BeanListHandler
     * @Param: 将结果集的每一行封装成JavaBean对象
     * 多个JavaBean对象封装到List集合中
     * @return:
     * @Author: Mr.Huang
     * @Date: 2021/5/15
     */
    public static void BeanListHandler() throws SQLException{
        /**
         * 调用方法,传递结果集实现类对象BeanListHandler
         * BeanListHandler(Clas<T> type)
         *
         */
        List<ZhangWu> zw = qr.query(con,
                select_sql,
                new BeanListHandler<ZhangWu>(ZhangWu.class));

        //遍历集合
        for(ZhangWu z : zw){
            System.out.println(z);
        }
    }
    
    /**
     * @Description: 结果集的第五种处理方法,ColumnListHandler --- 构造器 ColumnListHandler(String columnName)
     * 结果集,指定列的数据,存储到List集合
     * List<Object> 因为每列的数据类型不同
     * @Param:
     * @return:
     * @Author: Mr.Huang
     * @Date: 2021/5/15
     */
    public static void ColumnListHandler() throws SQLException{
        List<Object> list = qr.query(con,
                                select_sql,
                                new ColumnListHandler<Object>("zname"));

        for(Object obj : list){
            System.out.println(obj);
        }
    }
    
    /**
     * @Description: 结果集第六种处理方式,ScalarHandler
     * 适用于: 对于查询后只有一个结果
     * @Param:
     * @return:
     * @Author: Mr.Huang
     * @Date: 2021/5/15
     */
    public static void ScalarHandler() throws SQLException{
        String sql = "SELECT COUNT(*) FROM zhangwu";
        long count = qr.query(con,sql,
                new ScalarHandler<Long>());
        System.out.println(count); //9
    }
    
    /**
     * @Description: 结果集第七种处理方式,MapHandler
     * 将结果集第一行数据封装存储到Map集合
     * Map<键,值对> 键: 列名 值: 这列的数据
     * @Param:
     * @return: 
     * @Author: Mr.Huang
     * @Date: 2021/5/15
     */
    public static void MapHandler() throws SQLException{
        //返回值为Map集合
        Map<String,Object> maplist = qr.query(con
                ,select_sql
                ,new MapHandler());
        //遍历Map集合
        for(String key : maplist.keySet()){
            System.out.println(key+".."+maplist.get(key));
        }

    }

    /**
     * @Description: 结果集第八种处理方式,MapListHandler
     * 将结果集每一行数据封装存储到MapList集合
     * Map<键,值对> 键: 列名 值: 这列的数据
     * Map集合过多,存储到List集合
     * @Param:
     * @return:
     * @Author: Mr.Huang
     * @Date: 2021/5/15
     */
    public static void MapListHandler() throws SQLException{
        //返回值为List<Map<>>
        List<Map<String,Object>> list = qr.query(con
                ,select_sql
                ,new MapListHandler());

        //遍历
        for(Map<String,Object> map : list){
            for(String key : map.keySet()){
                System.out.print(key+".."+map.get(key));
            }
            System.out.println();
        }
    }
}
