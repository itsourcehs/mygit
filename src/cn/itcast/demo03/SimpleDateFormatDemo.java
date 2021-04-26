package cn.itcast.demo03;
/*
 * 对日期格式化
 * java.text.DateFormat
 */


import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatDemo {
    public static void main(String[] args) throws Exception {
        //fuc();
        fuct();
    }
    /*
     * 1.创建对象
     * 2.类构造器中,写入字符串的日期格式
     * 3.调用方法 format String format(Date date)
     * Date ---> String
     * String ---> Date 方法 parse
     */
    public static void fuc(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        String date = sdf.format(new Date());
        System.out.println(date);
    }

    public static void fuct() throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse("1995-5-6");//必须与模式格式一致 yyyy-MM-dd
        System.out.println(date);
    }

}
