package cn.itcast.demo07;

import java.util.LinkedHashSet;

/*
 * LinkedHashSet  基于链表的哈希表实现
 * 继承于 HashSet
 * LinkedHashSet 具有顺序
 */
public class LinkedHashSetDemo {


    public static void main(String[] args) {
        LinkedHashSet<Integer> link = new LinkedHashSet<Integer>();
        link.add(1123);
        link.add(123);
        link.add(1223);
        link.add(1323);

        System.out.println(link);
    }

}
