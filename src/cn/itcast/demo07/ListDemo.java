package cn.itcast.demo07;

import java.util.ArrayList;
import java.util.List;

/*
 * List 接口 继承 Collection接口
 * 特点: List的实现类 Arraylist linkedlist
 *  有序,索引,元素可以重复
 */
public class ListDemo {
    public static void main(String[] args) {
        fuc();
    }

    /*
     * add(int index,E)
     * 将元素插入到列表的指定索引上
     */
    public static void fuc(){
        List<String> list = new ArrayList<String>();
        list.add("abc1");
        list.add("abc2");
        list.add("abc3");
        list.add("abc4");

        list.add(1,"itcast");
        System.out.println(list);// [abc1, itcast, abc2, abc3, abc4]
    }

    /*
     * remove(int index)
     * 移除指定索引上的元素 返回 E
     */
    public static void fuc1() {
        List<Double> list = new ArrayList<Double>();
        list.add(1.1);
        list.add(1.2);
        list.add(1.3);
        list.add(1.4);
        list.add(1.5);

        Double d =list.remove(0);
        System.out.println(d);

    }

    /*
     * E set(int index,E)
     */
    public static void fuc2(){
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        list.set(0,11);


    }













}
