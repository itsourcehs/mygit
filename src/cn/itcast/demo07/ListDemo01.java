package cn.itcast.demo07;

import java.util.*;

/*
 * 迭代器的并发修改异常
 * 含义: 在遍历的过程中,使用了集合的方法修改了集合的长度,这是不允许的
 */
public class ListDemo01 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("abc1");
        list.add("abc2");
        list.add("abc3");
        list.add("abc4");

        Iterator<String> it = list.iterator();
        //ListIterator<String> it = list.listIterator();
        while (it.hasNext()){
            String s = it.next();
            if (s.equals("abc3")){
                list.add("ABC3");
            }
        }



    }
}
