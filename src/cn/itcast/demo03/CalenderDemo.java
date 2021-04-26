package cn.itcast.demo03;

import java.util.Calendar;

public class CalenderDemo {
    public static void main(String[] args) {
        fuc();
        Calendar c =Calendar.getInstance();//静态方法
        /*
         * 获取日历字段 参数 int 返回int 方法 get
         */
        int year = c.get(Calendar.YEAR);//静态方法
        int month = c.get(Calendar.MONTH)+1;
        int day = c.get(Calendar.DAY_OF_MONTH);
        //System.out.println(year+"-"+month+"-"+day);

        /*
         * 设置日历 参数 int field int value 返回
         * set(int field int value)
         * set(int year,int month,int day)
         */
        //c.set(Calendar.MONTH,9);
        //System.out.println(year+"-"+month+"-"+day);


    }
    public static void fuc(){
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_MONTH,280);
        int year = c.get(Calendar.YEAR);//静态方法
        int month = c.get(Calendar.MONTH)+1;
        int day = c.get(Calendar.DAY_OF_MONTH);
        System.out.println(year+"-"+month+"-"+day);
    }

}
