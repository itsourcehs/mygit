package cn.itcast.demo06;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/*
 * 集合中的迭代器
 * Iterator 接口
 *   两个抽象方法 hasNext() 返回布尔值  next() 取出集合中的下个元素
 *   ta的实现类  Iterator iterator()
 *   ArrayList 重写 iterator()方法,返回Iterator接口的实现类对象
 *   Iterator it = array.iterator() it.hasNext() it.next()
 */
public class IteratorDemo {
    public static void main(String[] args) {
        Collection<String> coll = new ArrayList<String>();
        coll.add("abc1");
        coll.add("abc2");
        coll.add("abc3");
        coll.add("abc4");

        //
        Iterator<String> it = coll.iterator();
//        boolean b = coll.iterator().hasNext(); // 判断集合是否有元素
        boolean b = it.hasNext();
//        System.out.println(b);// true
        String s = it.next();
//        System.out.println(s);

        while(it.hasNext()){
            String s1 = it.next();
            System.out.println(s1);
        }
    }















}
