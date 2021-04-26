package cn.itcast.demo08;

import java.util.HashMap;
import java.util.Map;

/*
 * Map接口的实现类 ---> HashMap
 */
public class MapDemo {
    public static void main(String[] args) {
        fuc1();
    }
    /*
     * 将键值对放入集合中
     * V put(K,V)
     * 返回值一般是null
     * 存储重复键的时候,返回被覆盖前的值
     */
    public static void fuc(){
        //创建集合对象,键是字符串,值是整数
        Map<String,Integer> map = new HashMap<String,Integer>();
        map.put("a",1);
        map.put("b",2);
        map.put("c",3);
        map.put("d",4);

        //System.out.println(map);



    }

    /*
     * 通过key获取值
     * V get(K)
     */
    public static void fuc1(){
        Map<String,Integer> map = new HashMap<String,Integer>();
        map.put("a",1);
        map.put("b",2);
        map.put("c",3);

        Integer i = map.get("a");
        System.out.println(i);


    }




















}
