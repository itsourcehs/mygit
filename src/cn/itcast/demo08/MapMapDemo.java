package cn.itcast.demo08;

import java.util.HashMap;

/*
 * map集合嵌套集合
 *  传智播客
 *    基础班
 *      001 张三
 *      002 李四
 *    就业班
 *      001 王五
 *      002 赵六
 */
public class MapMapDemo {

    public static void main(String[] args) {
        //定义基础班容器
        HashMap<String,String> javase = new HashMap<String, String>();
        //定义就业班容器
        HashMap<String,String> javaee = new HashMap<String, String>();

        //添加学生到基础班
        javase.put("001","张三");
        javase.put("002","李四");

        //添加学生到就业班
        javaee.put("001","王五");
        javaee.put("002","赵六");


        //定义传智播客容器 键为班级名称 值为两个班级容器
        HashMap<String,HashMap<String,String>> cabk =
                new HashMap<String, HashMap<String, String>>();
        cabk.put("基础班",javase);
        cabk.put("就业班",javaee);

    }

    public static void keySet(HashMap<String,HashMap<String,String>> cabk){
        //调用cabk集合方法 keySet将键存储到Set集合


    }

    public static void entrySet(){

    }









}
