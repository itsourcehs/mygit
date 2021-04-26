package cn.itcast.demo07;

import java.util.HashSet;

/*
 * HashSet集合的自身特点
 * 底层数据结构,哈希表
 */
public class HashSetDemo01 {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<String>();
        set.add(new String("abc"));
        set.add(new String("abc"));
        set.add(new String("bbc"));
        set.add(new String("bbc"));

        //System.out.println(set);//两个元素

        HashSet<Person> setPerson = new HashSet<Person>();
        setPerson.add(new Person("a",20));
        setPerson.add(new Person("b",25));
        setPerson.add(new Person("b",25));
        setPerson.add(new Person("c",19));
        setPerson.add(new Person("d",22));

        System.out.println(setPerson);
    }

    /*
     * 去掉重复的元素,重写目标,让对象中属性值 name,age 如果属性值相同,得到相同的哈希值
     *
     */



}
