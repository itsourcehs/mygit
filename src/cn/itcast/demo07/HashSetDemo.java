package cn.itcast.demo07;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
 * Set接口
 * 它的实现类  HashSet 特点: 无序集合,没有索引,不存储重复元素
 * 代码 和 ArrayList一样
 */
public class HashSetDemo {
    public static void main(String[] args) {
        Set<String> set = new HashSet<String>();
        set.add("cn");
        set.add("itcast");
        set.add("java");
        set.add("java1");

        Iterator<String> it = set.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }

        for(String s : set){
            System.out.println(s);
        }
    }

}
