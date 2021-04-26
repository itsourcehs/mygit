package cn.itcast.demo06;
import cn.itcast.demo03.Person;

import java.util.ArrayList;

/*
 * jdk 1.5及以后 增强for循环
 * jdk 1.5及以后 java.lang.Iterable 接口
 *  Collection开始继承 Iterable
 *  格式: for(数据类型 变量名 : 数组或集合)
 */
public class ForEachDemo {
    public static void main(String[] args) {

    }

    /*
     * 实现for循环,
     * 好处: 代码少,方便遍历容器
     * 弊端: 没有索引,不能操作容器里的元素
     */
    public static void fuc(){
        int[] arr = {3,1,5,2,1};
        for(int i : arr){
            System.out.println(i+1);// 4 2 6 3 2
        }
        System.out.println(arr[0]);//3
    }

    /*
     * 实现for循环遍历集合
     */
    public static void fuc1(){
        ArrayList<Person> array = new ArrayList<Person>();
        array.add(new Person("a",20));
        array.add(new Person("b",24));
        for(Person p : array){
            System.out.println(p);

        }
    }














}
