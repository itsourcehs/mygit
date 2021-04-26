package cn.itcast.demo06;

import java.util.ArrayList;
import java.util.Collection;



/*
 * Collecton 接口是所有集合的根接口
 * 他的实现类之一 ArrayList
 *
 */
public class CollectionDemo {
    public static void main(String[] args) {
        fuc1();

    }

    private static void fuc1() {
        Collection<String> coll = new ArrayList<String>();
        coll.contains("123");
    }

    /*
     * Collection 接口方法
     * void clear() 清空集合中的所有元素
     */
    public static void fuc(){
        //多态
        Collection<String> coll = new ArrayList<String>();
        coll.add("abc");
        coll.add("adad");
        System.out.println(coll); //[abc, adad]
    }
















}
