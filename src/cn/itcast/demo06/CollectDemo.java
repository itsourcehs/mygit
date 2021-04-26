package cn.itcast.demo06;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
/*
 * 最好加上泛型数据类型 Collection<String>
 */
public class CollectDemo {
    public static void main(String[] args) {
        Collection coll = new ArrayList();
        coll.add("123");
        coll.add("abc");

        Iterator it = coll.iterator();
        while (it.hasNext()){
            Object obg = it.next();
            System.out.println(obg);
            String s = (String)obg;//向下转型，才能调用子类特有
            System.out.println(s.length());
        }
    }
}
